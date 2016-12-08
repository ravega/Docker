package com.ravega.base;

import com.ravega.http.HttpConnection;

public class DockerRegistryVersion 
        extends DockerRegistryCmdBase {
    
    public DockerRegistryVersion(DockerRegistry dockerRegistry) {
        super(dockerRegistry);
    }
    
    /*
     * Check for the Registry version.
     */
    @Override
    public String send() {
        String result = HttpConnection.httpGetRequest(
                dockerRegistry.getTargetURL(),
                DockerRegistryCmdBase.DOCKER_REGISTRY_VERSION);
        if (result != null) return DockerRegistryCmdBase.DOCKER_REGISTRY_VERSION;
        
        return "Only Docker Registry API Version 2 is supported";
    }

}
