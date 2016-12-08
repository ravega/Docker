package com.ravega.base;

import java.lang.String;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.ravega.exception.DRImageDoesNotExistException;
import com.ravega.util.DockerRegistryUtil;

public class DockerRegistry {
	
    public static final String DOCKER_REGISTRY_PROTOCOL = "http";
    private String host = "localhost";
    private int port = 5000;
    
    public DockerRegistry() {
    }
    
    public DockerRegistry(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public URL getTargetURL() {
        return DockerRegistryUtil.getURL(
                DockerRegistry.DOCKER_REGISTRY_PROTOCOL,
                this.host,
                this.port);
    }
	
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /*
     * List all the current repositories in the registry
     */
    public List<String> listRepositories() {
        List<String> list = new ArrayList<String>();
        String jsonStr = new DockerRegistryListRepositories(this).send();
        JSONTokener jtokener = null;
        JSONObject jObject = null;
        JSONArray repos = null;
        try {
            jtokener = new JSONTokener(jsonStr);
            jObject = (JSONObject)jtokener.nextValue();
            repos = jObject.getJSONArray("repositories");
            for (int i=0; i<repos.length(); i++) {
                list.add(repos.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    /*
     * List the tags for a given repository
     */
    public List<String> listImageTags(String repo) {
        List<String> listRepositories = this.listRepositories();
        try {
            if (!listRepositories.contains(repo)) {
                throw new DRImageDoesNotExistException("Image " + repo + " not found in Registry.");
            } else {
                List<String> list = new ArrayList<String>();
                String jsonStr = new DockerRegistryImageTags(this, repo).send();
                JSONTokener jtokener = null;
                JSONObject jObject = null;
                JSONArray repos = null;
                try {
                    jtokener = new JSONTokener(jsonStr);
                    jObject = (JSONObject)jtokener.nextValue();
                    repos = jObject.getJSONArray("tags");
                    for (int i=0; i<repos.length(); i++) {
                        list.add(repos.getString(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                
                return list;
            }
        } catch (DRImageDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
        
        return new ArrayList<String>();
    }
    
    /*
     * Returns the version supported by the library.
     */
    public String getSupportedVersion() {
        return new DockerRegistrySupportedVersion(this).send();
    }
    
    /*
     * Returns the supported version for the registry.
     */
    public String getRegistryVersion() {
        return new DockerRegistryVersion(this).send();
    }
    
    public int getNumberOfRepositories() {
        List<String> list = this.listRepositories();
        return list.size();
    }
    

}
