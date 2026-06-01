package Simplepackage;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation_Ex3 { // The method can be created in jumbled way but the flow will be the same as below 
	
@BeforeSuite
	public void beforeSuite() {
	System.out.println("Before Suite");
}
@BeforeTest
public void beforeTest() {
	System.out.println("Before Test");
	
}
@BeforeClass
public void beforeClass() {
	System.out.println("Before Class");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("Before Method");
}
@Test
public void test() {
	System.out.println("Test case method 1");
}

@Test
public void test2() {
	System.out.println("Test case method 2");
}
@AfterMethod
public void afterMethod() {
	System.out.println("After method");
}

@AfterClass
public void afterClass() {
	System.out.println("After class");
}
@AfterTest
public void afterTest() {
	System.out.println("After Test");
}
@AfterSuite
public void afterSuite() {
	System.out.println("After suite");
}
}
