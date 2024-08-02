package demo.wrappers;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import demo.TestCases;


public class ListenersTestNG  implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
       
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       
        System.out.println("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
      
      System.out.println("Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
        System.out.println("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        
        throw new UnsupportedOperationException("Unimplemented method 'onTestFailedButWithinSuccessPercentage'");
    }

    @Override
    public void onStart(ITestContext context) {
       
       System.out.println("test started");
    }

    @Override
    public void onFinish(ITestContext context) {
       
       System.out.println("test finished");
    }

}
    

