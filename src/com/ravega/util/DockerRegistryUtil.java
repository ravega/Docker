package com.ravega.util;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerRegistryUtil {

	public static URL getURL(String protocol, String host, int port) {
		URL targetURL = null;
		try {
			targetURL = new URL(protocol, host, port, "");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return targetURL;
	}
	
	public static String compose(String...strings) {
		String result = "";
		for (int i = 0; i < strings.length; ++i) {
			result += "/" + strings[i];
		}
		return result;
	}
}
