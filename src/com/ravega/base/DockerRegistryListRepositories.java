package com.ravega.base;

import com.ravega.http.HttpConnection;
import com.ravega.util.DockerRegistryUtil;

public class DockerRegistryListRepositories 
        extends DockerRegistryCmdBase {

    private static final String DOCKER_REGISTRY_LIST_REPOS = "_catalog";
    
    public DockerRegistryListRepositories(DockerRegistry dockerRegistry) {
        super(dockerRegistry);
    }
    
    /*
     * List all the registry repositories.
     */
    @Override
    public String send() {
        return HttpConnection.httpGetRequest(
                dockerRegistry.getTargetURL(),
                DockerRegistryUtil.compose(DOCKER_REGISTRY_VERSION, 
                        DOCKER_REGISTRY_LIST_REPOS));
    }
}
