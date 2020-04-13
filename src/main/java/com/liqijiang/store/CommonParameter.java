package com.liqijiang.store;

import org.openqa.selenium.WebDriver;

import com.liqijiang.util.SeleniumAPI;

public class CommonParameter {
	public static String driverName = "chrome";
	public static String driverPath = "G:\\软件安装包下载放置目录\\chromedriver_win32_75.0.3770.8\\chromedriver.exe";
	public static WebDriver driver = SeleniumAPI.getDriver(driverName, driverPath);
	




}
