# Docker

Docker Registry Library by Raúl Vega.

* INTRODUCTION
--------------

Here you will find a main API to request the Docker Registry 
(DockerRegistry.java) and a reduced set of registry commands to
send requests to the registry.

* DEPENDENCIES
--------------

Dependencies for the library have been introduced in the pom.xml file.
They are basically junit and java-json jar files.

* TESTING
---------

Testing is limited to the few commands implemented. They expect 3 installed
repositories in order to succeed.

TestRunner.java: Basic junit test for the library commands.

Test.java: A main testing class where I quickly tested my things.

* HOW TO
--------

This library has a main API class named DockerRegistry.java where all the 
functionallity will be available for an easy access as part of the class
methods:

 // Defaulted to localhost listening on port 5000
 // Use DockerRegistry(host, port) to target somewhere else.
 DockerRegistry dr = new DockerRegistry();
 dr.listRespositories();
