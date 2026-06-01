package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNg implements ITestListener {

@Override
public void onFinish(ITestContext Result) { // this ITest class defines the test context which conatins all the information in a given run 
		
	}
@Override
	public void onStart(ITestContext Result) {
		
	}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
	
}

@Override // When test failed, this method is called
public void onTestFailure(ITestResult Results) {
	System.out.println("The name of the  test case failed is:"+ Results.getName());
}


@Override // When test Skipped, this method is called
public void onTestSkipped(ITestResult Result) {
	System.out.println("The name of the test case skipped is:"+ Result.getName());
}


@Override // When test starts, this method is called
public void onTestStart(ITestResult Result) {
	System.out.println(Result.getName()+"The Test case started");
}

@Override // When test sucess, this method is called
public void onTestSuccess(ITestResult Result) {
	System.out.println("The name of the test passed is:"+Result.getName());
}
}
