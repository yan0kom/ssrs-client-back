package ru.yan0kom.ssrs.back;

import java.util.HashMap;

public class SsrsEncoding {
	private static HashMap<String, String> encoding;
	
	static {
		encoding = new HashMap<String, String>();
		encoding.put("Unicode (UTF-8)", "UTF-8");
	}
	
	public static String toJava(String ssrsEncoding) {
		return encoding.get(ssrsEncoding);
	}
}
