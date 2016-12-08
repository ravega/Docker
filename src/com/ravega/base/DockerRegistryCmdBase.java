package com.ravega.base;

public abstract class DockerRegistryCmdBase {

    public static final String DOCKER_REGISTRY_VERSION = "v2";
    
    protected DockerRegistry dockerRegistry;
    
    public DockerRegistryCmdBase(DockerRegistry dockerRegistry) {
        this.dockerRegistry = dockerRegistry;
    }
    
    protected abstract String send();
}
