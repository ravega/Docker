package com.ravega.base;

import com.ravega.http.HttpConnection;
import com.ravega.util.DockerRegistryUtil;

public class DockerRegistryImageTags
        extends DockerRegistryCmdBase {
    
    private static final String DOCKER_REGISTRY_LIST_IMAGE_TAGS = "tags/list";
    private String image;

    public DockerRegistryImageTags(DockerRegistry dockerRegistry, String image) {
        super(dockerRegistry);
        this.image = image;
    }
    
    /*
     * List all the registry repositories.
     */
    @Override
    public String send() {
        return HttpConnection.httpGetRequest(
                dockerRegistry.getTargetURL(),
                DockerRegistryUtil.compose(DOCKER_REGISTRY_VERSION,
                        this.image, 
                        DOCKER_REGISTRY_LIST_IMAGE_TAGS));
    }
}
