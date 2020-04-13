package com.liqijiang.services;

import com.liqijiang.store.CommonParameter;
import com.liqijiang.store.LoginUIElement;
import com.liqijiang.util.SeleniumAPI;

public class LoginService {

	public static void login(String user, String passwd) {
		CommonParameter.driver.findElement(SeleniumAPI.getElementLocation(LoginUIElement.user)).sendKeys(user);
		CommonParameter.driver.findElement(SeleniumAPI.getElementLocation(LoginUIElement.passwd)).sendKeys(passwd);
		CommonParameter.driver.findElement(SeleniumAPI.getElementLocation(LoginUIElement.loginButton)).click();
		;

	}

	public static void login1(String user, String passwd) {
		SeleniumAPI.sendkeys(CommonParameter.driver, LoginUIElement.user, user);
		SeleniumAPI.sendkeys(CommonParameter.driver, LoginUIElement.passwd, passwd);
		SeleniumAPI.click(CommonParameter.driver, LoginUIElement.loginButton);

	}

	public static String login2() {
		String s = CommonParameter.driver.findElement(SeleniumAPI.getElementLocation(LoginUIElement.loginUser))
				.getText();
		return s;
	}

}
