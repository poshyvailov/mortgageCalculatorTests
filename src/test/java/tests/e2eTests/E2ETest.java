package tests.e2eTests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.MortgageCalculatorPage;
import tests.BaseTest;

import static config.Constants.*;

public class E2ETest extends BaseTest {

    MortgageCalculatorPage mortgageCalculatorPage = new MortgageCalculatorPage();

    @Test(groups = {E2E}, description = "Full mortgage calculation workflow with valid interest rate")
    @TmsLink("E2E-1")
    public void e2ETest() {
        stepName("1. Open \"MortgageCalculator\"");
        openMainPage();
        mortgageCalculatorPage.shouldSeeMortgageCalculatorPage();

        stepName("2. Enter 300,000 in “Home Price” field");
        mortgageCalculatorPage.setValueForField(HOME_PRICE, "300,000");

        stepName("3. Enter 60,000 in “Down Payment” field");
        mortgageCalculatorPage.setValueForField(DOWN_PAYMENT, "60,000");

        stepName("4. Select “30-year fixed” for “Loan Program”");
        mortgageCalculatorPage.selectValueInDropdown("30 year fixed");

        stepName("4. Enter “5.0” in “Interest Rate” field");
        mortgageCalculatorPage.setValueForField(INTEREST_RATE, "5.0")
                .clickOutside()
                .shouldSeeCorrectPaymentAmount();
    }
}