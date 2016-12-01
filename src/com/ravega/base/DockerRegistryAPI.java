package com.ravega.base;

import com.ravega.util.DockerRegistryUtil;

public class DockerRegistryAPI {

	public static final String DOCKER_REGISTRY_VERSION = "v2";
	
	private static final String DOCKER_REGISTRY_LIST_REPOS = "_catalog";
	private static final String DOCKER_REGISTRY_LIST_IMAGE_TAGS = "tags/list";
	
	public static String drVersion() {
		return DockerRegistryUtil.compose(DockerRegistryAPI.DOCKER_REGISTRY_VERSION);
	}
	
	public static String drListRepositories() {
		return DockerRegistryUtil.compose(DockerRegistryAPI.DOCKER_REGISTRY_VERSION, 
				DockerRegistryAPI.DOCKER_REGISTRY_LIST_REPOS);
	}
	
	public static String drListImageTags(String image) {
		return DockerRegistryUtil.compose(DockerRegistryAPI.DOCKER_REGISTRY_VERSION,
				image,
				DockerRegistryAPI.DOCKER_REGISTRY_LIST_IMAGE_TAGS);
	}
}
