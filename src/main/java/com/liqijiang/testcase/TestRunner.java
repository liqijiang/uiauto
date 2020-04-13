package com.liqijiang.testcase;

import org.junit.runner.JUnitCore;

import com.liqijiang.htmllog.HTMLLogEntry;
import com.liqijiang.store.CommonParameter;
import com.liqijiang.util.SeleniumAPI;

public class TestRunner {
	public static void main(String[] args) {
		SeleniumAPI.windowMax(CommonParameter.driver);
		JUnitCore.runClasses(TestSuite.class);

		SeleniumAPI.quit(CommonParameter.driver);
		HTMLLogEntry.colse();
	}
}
