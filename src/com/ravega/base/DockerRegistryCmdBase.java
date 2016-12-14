package com.ravega.base;

public abstract class DockerRegistryCmdBase
    implements DockerRegistryCommand {

    public static final String DOCKER_REGISTRY_VERSION = "v2";
    
    protected DockerRegistry dockerRegistry;
    
    public DockerRegistryCmdBase(DockerRegistry dockerRegistry) {
        this.dockerRegistry = dockerRegistry;
    }

}
