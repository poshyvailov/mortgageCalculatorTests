package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static config.Constants.*;


public class MortgageCalculatorPage {

    SelenideElement homePriceField = $("#homePrice");
    SelenideElement downPaymentField = $("#form-2_downPayment");
    SelenideElement loanProgramField = $("#form-2_term");
    SelenideElement interestRateField = $("#rate");

    @Step
    public MortgageCalculatorPage shouldSeeMortgageCalculatorPage() {
        $$("h1").findBy(text("Mortgage Calculator")).shouldBe(visible);
        homePriceField.shouldBe(visible);
        downPaymentField.shouldBe(visible);
        loanProgramField.shouldBe(visible);
        interestRateField.shouldBe(visible);
        $("#breakdown").shouldHave(attribute("aria-selected", "true"));
        $("#breakdown-panel").shouldBe(visible);
        return this;
    }

    @Step
    public MortgageCalculatorPage setValueForField(String fieldName, String value) {
        switch (fieldName) {
            case "Interest rate" -> interestRateField.setValue(value);
            case "Home Price" -> homePriceField.setValue(value);
            case "Down Payment" -> {
                int i = 0;
                while (!downPaymentField.getValue().isEmpty() && i < 15) {
                    downPaymentField.sendKeys(Keys.BACK_SPACE);
                    i++;
                }
                downPaymentField.setValue(value);
            }
            default -> throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
        return this;
    }

    @Step
    public MortgageCalculatorPage clickOutside() {
        $("#breakdown-panel").click();
        return this;
    }

    @Step
    public MortgageCalculatorPage selectValueInDropdown(String value) {
        loanProgramField.selectOption(value);
        return this;
    }

    @Step
    public int getPaymentValue(String fieldName, int index) {
        SelenideElement field = $$("text").findBy(text(fieldName)).sibling(index);
        return parseToNumber(field.text());
    }

    private int parseToNumber(String value) {
        return Integer.parseInt(value.replace("$", "").replace(",", ""));
    }

    @Step
    public MortgageCalculatorPage shouldSeeChangedValue(String fieldName, int previousValue) {
        SelenideElement field = $$("text").findBy(text(fieldName)).sibling(0);
        int currentValue = parseToNumber(field.text());
        Assert.assertNotEquals(currentValue, previousValue, "Amount of " + fieldName + " should change!");
        return this;
    }

    @Step
    public MortgageCalculatorPage shouldSeeErrorForInterestsRateField(String errorText) {
        $(byText(errorText)).shouldBe(visible);
        return this;
    }

    @Step
    public MortgageCalculatorPage shouldSeeFieldValue(String fieldName, String value, int index) {
        $$("text").findBy(text(fieldName))
                .sibling(index)
                .shouldHave(text(value));
        return this;
    }

    @Step
    public MortgageCalculatorPage shouldSeeCorrectPaymentAmount() {
        int taxes = getPaymentValue(TAXES, 0);
        int insurance = getPaymentValue(INSURANCE, 0);
        int pi = getPaymentValue(PI, 1);
        int commonAmount = taxes + insurance + pi;
        int fieldValue = parseToNumber($$("text").findBy(text(YOUR_PAYMENT)).sibling(0).text());
        Assert.assertEquals(commonAmount, fieldValue, "Your payment amount must be " + (taxes + insurance + pi));
        return this;
    }
}