package com.ravega.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
	
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";

    private HttpConnection() {}

    public static String httpGetRequest(URL targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection

       	    URL url = new URL(targetURL, urlParameters);
       	    connection = (HttpURLConnection) url.openConnection();
       	    connection.setRequestMethod(HttpConnection.HTTP_METHOD_GET);
       	    connection.setUseCaches(false);
       	    
       	    connection.getResponseCode();
	    
       	    BufferedReader in = new BufferedReader (
       	            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
	    
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
	    
            return response.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
  
	}
	
	public static String httpPostRequest(URL targetURL, String urlParameters) {
	    return "";
	}
}
