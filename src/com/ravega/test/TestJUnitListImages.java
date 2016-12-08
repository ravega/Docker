package com.ravega.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.ravega.base.DockerRegistry;

public class TestJUnitListImages {
    
    private DockerRegistry dockerRegistry;
    
    @Before
    public void setUp() {
        dockerRegistry = new DockerRegistry();
    }
    
    /*
     * Testing with 3 Images in my local Registry.
     */
    @Test
    public void testListNumberOfImages() {
        assertEquals(dockerRegistry.getNumberOfRepositories(), 3);     
    }
    
    /*
     * Check for a failed number check.
     */
    @Test
    public void testListNumberOfImagesWrong() {
        assertNotEquals(dockerRegistry.getNumberOfRepositories(), 0);     
    }
}
