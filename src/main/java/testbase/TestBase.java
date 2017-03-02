package testbase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.Driver;

public class TestBase {
	@BeforeClass
	public void setup() {
		Driver.Initialize();
	}
	
	
	@AfterClass
	public void cleanup() {
		Driver.close();
	}
}
