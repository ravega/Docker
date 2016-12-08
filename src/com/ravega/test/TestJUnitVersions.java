package com.ravega.test;

import org.junit.Test;

import com.ravega.base.DockerRegistry;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class TestJUnitVersions {

    private DockerRegistry dockerRegistry;
   
    @Before
    public void setUp() {
        dockerRegistry = new DockerRegistry();
    }
    
    /*
     * Check that the registry supported Version is v2.
     */
    @Test
    public void testCheckRegistryV2Version() {
        assertEquals(dockerRegistry.getRegistryVersion(), "v2");     
    }
   
    /*
     * Check that the library supported version is v2.
     */
    @Test
    public void testCheckSupportedV2Version() {
        assertEquals(dockerRegistry.getSupportedVersion(), "v2");     
    }
}
