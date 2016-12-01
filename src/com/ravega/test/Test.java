package com.ravega.test;

import com.ravega.base.DockerRegistry;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Test {

	public static void main(String[] args) {
        DockerRegistry dockerRegistry = new DockerRegistry();
        
        System.out.println(dockerRegistry.getSupportedVersion());
        
        System.out.println(dockerRegistry.getRegistryVersion());
        
        System.out.println(dockerRegistry.listRepositories());
        
        String jsonStr = dockerRegistry.listRepositories();

		try {
			JSONTokener jtokener = new JSONTokener(jsonStr);
			JSONObject jObject = (JSONObject)jtokener.nextValue();
			Iterator it = jObject.keys();
			while (it.hasNext()) {
                System.out.println(it.next());
			}
			JSONArray repos = jObject.getJSONArray("repositories");
			System.out.println(repos.toString());
			System.out.println(repos.length());
			for (int i=0; i<repos.length(); ++i ) {
			    System.out.println(repos.getString(i));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
