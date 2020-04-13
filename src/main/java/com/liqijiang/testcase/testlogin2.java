package com.liqijiang.testcase;

import org.junit.Test;

import com.liqijiang.htmllog.HTMLLogEntry;
import com.liqijiang.services.LoginService;
import com.liqijiang.store.CommonParameter;
import com.liqijiang.util.SeleniumAPI;

public class testlogin2 {
	@Test
	public void test2() {
		SeleniumAPI.get(CommonParameter.driver, "http://www.doclever.cn/controller/login/login.html");
		LoginService.login("123", "123456");
		SeleniumAPI.sleep(500);
		SeleniumAPI.get(CommonParameter.driver, "http://www.doclever.cn/controller/console/console.html");
		SeleniumAPI.sleep(1000);
		HTMLLogEntry.write("异常登录", "123", "12");
	}

}
