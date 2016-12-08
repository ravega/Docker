package com.ravega.base;


public class DockerRegistrySupportedVersion
        extends DockerRegistryCmdBase {

    public DockerRegistrySupportedVersion(DockerRegistry dockerRegistry) {
        super(dockerRegistry);
    }
    
    /*
     * Check for the Library supported version.
     */
    @Override
    public String send() {
        return DOCKER_REGISTRY_VERSION;
    }
}
