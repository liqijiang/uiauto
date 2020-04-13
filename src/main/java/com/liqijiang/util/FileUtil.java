package com.liqijiang.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtil {
	public static String getProjectDirectory() {
		String projectDirectory = "";
		projectDirectory = new File("").getAbsolutePath();
		return projectDirectory;
	}

	public static Properties readProperties(String fullPathName) {
		if(!fullPathName.endsWith(".properties")) {
			return null;
		}
		Properties p = new Properties();
		InputStreamReader in = null;
		try {
			in = new InputStreamReader(new FileInputStream(new File(fullPathName)), "utf-8");
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return p;

	}

	public static Map<String, Map<String, String>> readINI(String fullPathName) {
		if(!fullPathName.endsWith(".ini")) {
			return null;
		}
		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> map1 = new HashMap<String, String>();
		BufferedReader br = null;
		String line  = null;
		String key = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fullPathName)), "utf-8"));
			while ((line = br.readLine())!=null) {
				
	            if(line.startsWith("#")||line.length() == 0) {
	            	continue;
	            }
	            if(line.startsWith("[") && line.endsWith("]") && key == null) {
	            	key = line.substring(1, line.length()-1);
	            	continue;
	            }
	            if(line.startsWith("[") && line.endsWith("]") ) {
	            	map.put(key, map1);
	            	map1 = new HashMap<String, String>();
	            	key = line.substring(1, line.length()-1);
	            	continue;
	            }
	            String[] s = line.split("=");
	            map1.put(s[0], s[1]);
	        }
			if(map1.size() != 0) {
				map.put(key, map1);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public static String getINI(Map<String, Map<String, String>> map,String key, String valueKey) {
		String s = "";
		Map<String, String> map1 = map.get(key);
		s = map1.get(valueKey);
		return s;
	}
	public static void main(String[] args) {
//		System.out.println(getProjectDirectory());

//		Properties p = FileUtil.readProperties("driver.properties");
//		System.out.println(p.getProperty("chrome"));
		Map<String, Map<String, String>> map = readINI("./src/main/resources/conf/driver.ini");
		
		System.out.println(getINI(map, "webdriver1", "chrome"));
		System.out.println(map);
		
//		Map map = new HashMap();
//		map.put(10, 10);
//		for(int i = 0; i<3;i++) {
//			map.put(i, i);
//		}
//		map.put(20, 20);
//		System.out.println(map);
		
	}

}
