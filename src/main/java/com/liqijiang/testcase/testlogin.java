package com.liqijiang.testcase;

import org.junit.Ignore;
import org.junit.Test;
import com.liqijiang.htmllog.HTMLLogEntry;
import com.liqijiang.services.LoginService;
import com.liqijiang.store.CommonParameter;
import com.liqijiang.util.SeleniumAPI;

public class testlogin {
	
	//api没有封装前
	@Ignore
	@Test
	public void test1() {
		CommonParameter.driver.get("http://www.doclever.cn/controller/login/login.html");
		CommonParameter.driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginService.login("root", "123456");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonParameter.driver.close();
	}
	//api封装后
	@Test
	public void test2() {
//		SeleniumAPI.windowMax(CommonParameter.driver);
		SeleniumAPI.get(CommonParameter.driver, "http://www.doclever.cn/controller/login/login.html");
		LoginService.login("root", "123456");
		SeleniumAPI.sleep(500);
		SeleniumAPI.get(CommonParameter.driver, "http://www.doclever.cn/controller/console/console.html");
		SeleniumAPI.sleep(1000);
		HTMLLogEntry.write("正常登录", "root", LoginService.login2());
//		CommonParameter.driver.close();
	}


}
