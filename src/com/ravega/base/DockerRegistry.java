package com.ravega.base;

import java.lang.String;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.ravega.http.HttpConnection;
import com.ravega.util.DockerRegistryAPI;
import com.ravega.util.DockerRegistryUtil;

public class DockerRegistry {
	
	public static final String DOCKER_REGISTRY_PROTOCOL = "http";
	private String host = "localhost";
	private int port = 5000;
	private URL targetURL;
	
	public DockerRegistry() {
		targetURL = DockerRegistryUtil.getURL(
				DockerRegistry.DOCKER_REGISTRY_PROTOCOL,
				this.host,
				this.port);
	}
	
	public DockerRegistry(String host, int port) {
		this.host = host;
		this.port = port;
		targetURL = DockerRegistryUtil.getURL(
				DockerRegistry.DOCKER_REGISTRY_PROTOCOL,
				this.host,
				this.port);
	}

	/*
	 * List all the registry repositories.
	 */
    public String listRepositories() {
    	// GET /v2/_catalog
    	String result = HttpConnection.httpGetRequest(
    			targetURL,
    			DockerRegistryAPI.drListRepositories());
		
        return result;	
    }

    /*
     * Check for the number of repositories in the registry.
     */
    public int listNumberOfRepositories() {
        String jsonStr = this.listRepositories();
        JSONTokener jtokener = null;
        JSONObject jObject = null;
        JSONArray repos = null;
        try {
            jtokener = new JSONTokener(jsonStr);
            jObject = (JSONObject)jtokener.nextValue();
            repos = jObject.getJSONArray("repositories");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
        
        return repos.length();
    }
    
    /*
     * For a given repository image, return all its tags.
     */
    public String listImageTags(String repository) {
    	// GET /v2/<repository>/tags/list
    	String result = HttpConnection.httpGetRequest(
    			targetURL,
    			DockerRegistryAPI.drListImageTags(repository));
		
    	return result;
    }

    public String pullImage(String image) {
    	return "";
    }

    public String pushImage(String image) {
    	return "";
    }
    
    public String deleteImage(String image) {
    	return "";
    }
    
    /*
     * Check for the Library supported version.
     */
    public String getSupportedVersion() {
    	return DockerRegistryAPI.DOCKER_REGISTRY_VERSION;
    }
    
    /*
     * Check for the Registry version.
     */
    public String getRegistryVersion() {
    	String result = HttpConnection.httpGetRequest(
    			targetURL,
    			DockerRegistryAPI.drVersion());
    	if (result != null) return getSupportedVersion();
    	
		return "Only Docker Registry API Version 2 is supported";
    }
}
