package com.ravega.test;

import com.ravega.base.DockerRegistry;
import com.ravega.base.DockerRegistryImageTags;
import com.ravega.base.DockerRegistryListRepositories;
import com.ravega.base.DockerRegistrySupportedVersion;
import com.ravega.base.DockerRegistryVersion;

import java.util.Iterator;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        /*
         * Test commands
         */
        System.out.println("Testing Docker Registry Commands...");
        System.out.println("[REGISTRY SUPPORTED VERSION] " + new DockerRegistrySupportedVersion(new DockerRegistry()).send());
        System.out.println("[DOCKER REGISTRY VERSION] " + new DockerRegistryVersion(new DockerRegistry()).send());
        System.out.println("[REPOSITORY LIST] " + new DockerRegistryListRepositories(new DockerRegistry()).send());
        System.out.println("[LIST IMAGE TAGS] " + new DockerRegistryImageTags(new DockerRegistry(), "ubuntu").send());
        
        /*
         * Test Docker Registry
         */
        System.out.println("");System.out.println("");
        System.out.println("Testing DockerRegistry API...");
        DockerRegistry dr = new DockerRegistry();
        System.out.println("Number of repositories: " + dr.getNumberOfRepositories());

        List<String> listTags = dr.listImageTags("ubunttuu");
        Iterator<String> itTags = listTags.iterator();
        while(itTags.hasNext()) {
            System.out.println(itTags.next());
        }
	    
        System.out.println("List al repository tags: ");
        List<String> repoList = dr.listRepositories();
        List<String> tagList;
        Iterator<String> itRepos = repoList.iterator();
        String repo = "";
        while (itRepos.hasNext()) {
            repo = itRepos.next();
            System.out.println("Repository: " + repo);
            tagList = dr.listImageTags(repo);
            itTags = tagList.iterator();
            while (itTags.hasNext()) {
                System.out.println(itTags.next());
            }
        }

	}

}
