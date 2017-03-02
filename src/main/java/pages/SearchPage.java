package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testbase.TestBase;

public class SearchPage  {
	
	
	String searchBlocksLocator="div[class$='-listing']";
	String BusinessNameLocator="div[class$='-listing'] a[class$='-listing__title']";
	String RecommendationsLocator="div[class$='-listing'] div[class$='-listing__recommendations'] a";
	String reactIdLocator="data-reactid";
	
	By searchResult=By.cssSelector(searchBlocksLocator);
	By businessName=By.cssSelector(BusinessNameLocator);
	By recommendationsCount=By.cssSelector(RecommendationsLocator);
	
	public int extractNumOfRecommendation(String str) {
		String REGEX = "[^0-9]";
		String REPLACE = "";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(str.toString()); 
	    str = m.replaceAll(REPLACE);
		return Integer.parseInt(str);
	}
	
	
	public List<WebElement> findSearchResults(WebDriver driver) {
		List<WebElement> we_list=null;
		we_list=driver.findElements(searchResult);
		return we_list;
	}
	
	public HashMap<Integer, String> fetchAllRecommendationsAndName(WebDriver driver) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		List<WebElement> rec=driver.findElements(recommendationsCount);
		List<WebElement> name=driver.findElements(businessName);
		for(int i=0;i<rec.size();i++) {
			map.put(extractNumOfRecommendation(rec.get(i).getText()),name.get(i).getText());
		}
		return map;
	}
	
	public void showMostRecommendedBusiness(WebDriver driver) {
	
		HashMap<Integer, String> hmap = fetchAllRecommendationsAndName(driver);
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(hmap);
		int max=tmap.lastKey();
		System.out.println("BusinessName: ("+tmap.get(max)+") Is Most Recommended With ("+max+") Recommendations");
	}
}
