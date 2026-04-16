package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int maxRetry = 2; // number of retries

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            System.out.println("Retrying test: " + result.getName());
            return true; // retry again
        }

        return false; // stop retry
    }
}