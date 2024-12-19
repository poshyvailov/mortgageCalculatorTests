package config;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {

    @Override
    public void onTestStart(final ITestResult testResult) {
        Logger.out.info("START TEST: %s (%s)", testResult.getName(), testResult.getInstanceName());
    }

    @Override
    public void onTestSuccess(final ITestResult testResult) {
        Logger.out.info("TEST PASSED - (%s milliseconds)\n-------------------------------------------------------",
                getDuration(testResult));
    }

    @Override
    public void onTestSkipped(final ITestResult testResult) {
        Logger.out.trace("TEST SKIPPED - %s\n-------------------------------------------------------",
                testResult.getName());
    }

    @Override
    public void onTestFailure(final ITestResult testResult) {
        Logger.out.error("TEST FAILED - (%s milliseconds)\n-------------------------------------------------------",
                getDuration(testResult));
    }

    private long getDuration(final ITestResult testResult) {
        return testResult.getEndMillis() - testResult.getStartMillis();
    }
}
