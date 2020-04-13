package uiauto;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import com.liqijiang.store.CommonParameter;
import com.liqijiang.store.UIElement;
import com.liqijiang.util.SeleniumAPI;

public class SeleniuAPITest {
	@Ignore
	@Test
	public void testGetDriver() {
		CommonParameter.driver.manage().window().maximize();
		CommonParameter.driver.get("https://www.baidu.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonParameter.driver.quit();
	}
	@Test
	public void testGetElementLocation() {
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element1));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element2));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element3));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element4));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element5));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element6));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element7));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element8));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element9));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element10));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element11));
		System.out.println(SeleniumAPI.getElementLocation(UIElement.element12));
	}
	
}
