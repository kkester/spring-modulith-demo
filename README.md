# Spring Modulith Demo

## Overview

This PoC demonstrates the following architecture, design, and coding strategies:

1. Hexagonal Architecture leveraging Spring Modulith.
1. Architecture validation using Spring Modulith, `jmolecules` and `ArchUnit` testing frameworks.
1. Custom native queries leveraging JPA SQL projections.
1. PostGRES database with H2 embedded database for tests.
1. Define mappers utilizing `MapStructs`
1. Project leverages spring starter docker and spring dev tools.

## Spring Modulith Summary

Spring Modulith is a framework that will inspect the application's package structure and identify top level packages as modules.  In the case of this project, two modules are identified called course and student.  Any classes in the root module package will be considered public.  Any classes in sub-packages will be considered private.  As a result, classes with the annotation `PrimaryPort` should be the main type of classes that reside in the module's root package.

One aspect to look out for when implementing applications with spring modulith is that the framework does not allow circular dependencies between modules.  One technique to use to work around this is to introduce a common module where classes needed by multiple modules can reside.

## Architecture Variations
* See the `layered` branch for an example of using [Layered Architecture](https://ddd-practitioners.com/home/glossary/layered-architecture/).
* See the `onion` and `onion-classic` branches for examples using the [Onion Architecture](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)
See also [DDD](https://thedomaindrivendesign.io/) and [Anemic Model](https://thedomaindrivendesign.io/anemic-model/).

## Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.2/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/gradle-plugin/packaging-oci-image.html)
* [Spring Modulith](https://docs.spring.io/spring-modulith/reference/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)

## Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.

