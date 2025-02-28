package utils.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.common.LogUtil;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    private long timeStart, timeEnd;
    private long totalTime;

    @Override
    public void onStart(ITestContext Result) {
        totalTime = System.currentTimeMillis();
    }

    @Override
    public void onTestStart(ITestResult Result) {
        LogUtil.info("*********************************");
        LogUtil.info("Start Test Case: " + Result.getMethod().getDescription());
        LogUtil.info("*********************************");
        timeStart = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        timeEnd = System.currentTimeMillis();
        long eachTestElapsed = timeEnd - timeStart;
        LogUtil.info("*********************************");
        LogUtil.info("Test case PASSED in " + String.format("%d minute(s), %d second(s)",
                TimeUnit.MILLISECONDS.toMinutes(eachTestElapsed),
                TimeUnit.MILLISECONDS.toSeconds(eachTestElapsed)));
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        timeEnd = System.currentTimeMillis();
        long eachTestElapsed = timeEnd - timeStart;
        LogUtil.info("*********************************");
        LogUtil.info("Test case FAILED in " + String.format("%d minute(s), %d second(s)",
                TimeUnit.MILLISECONDS.toMinutes(eachTestElapsed),
                TimeUnit.MILLISECONDS.toSeconds(eachTestElapsed)));
    }

    @Override
    public void onTestSkipped(ITestResult Result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
    }

    @Override
    public void onFinish(ITestContext Result) {
        long wholeTestsElapsed = System.currentTimeMillis() - totalTime;
        LogUtil.info("*********************************");
        LogUtil.info("TOTAL RUN TIME: " + String.format("%d minute(s), %d second(s)",
                TimeUnit.MILLISECONDS.toMinutes(wholeTestsElapsed),
                TimeUnit.MILLISECONDS.toSeconds(wholeTestsElapsed)));
    }
}
