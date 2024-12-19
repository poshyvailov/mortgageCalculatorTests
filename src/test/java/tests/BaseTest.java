package tests;

import com.codeborne.selenide.Configuration;
import config.EnvironmentConfig;
import config.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static config.EnvironmentConfig.getBrowser;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(Method method) {
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 300000;
        Configuration.browserSize = "1900x1080";
        Configuration.browser = getBrowser();
        try {
            open();
        } catch (SessionNotCreatedException e) {
            Logger.out.warn("Try to open page again");
            open();
        }
    }

    @Step("Open page")
    public void openMainPage() {
        openPage(EnvironmentConfig.getBaseUrl());
    }

    @Step("Open {url}")
    protected void openPage(String url) {
        open(url);
    }

    @Step(" {stepName}")
    public void stepName(String stepName) {
        Logger.out.info(stepName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        Logger.out.info("Closing browser");
        closeWebDriver();
    }
}