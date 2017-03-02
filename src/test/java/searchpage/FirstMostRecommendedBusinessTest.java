package searchpage;

import org.testng.annotations.Test;

import pages.SearchPage;
import config.Configuration;
import testbase.TestBase;
import utilities.Driver;

public class FirstMostRecommendedBusinessTest extends TestBase {

	@Test
	public void searchResultTest() {
		Driver.Instance.navigate().to(Configuration.url.app_url);
		SearchPage sp=new SearchPage();
		sp.showMostRecommendedBusiness(Driver.Instance);
	}
}
