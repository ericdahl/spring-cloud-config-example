[![Build Status](https://travis-ci.org/ericdahl/spring-cloud-config-example.svg)](https://travis-ci.org/ericdahl/spring-cloud-config-example)

# spring-cloud-config-example
basic example of using spring-cloud-config to retrieve configs from a git-backed server

## Quick Start

### Build code

```bash
git clone git@github.com:ericdahl/spring-cloud-config-example.git
cd spring-cloud-config-example
mvn clean package
```

### Start Config Server

```bash
java -jar server/target/spring-cloud-config-example-server-1.0-SNAPSHOT.jar
```

Load [http://localhost:8888/master/development](http://localhost:8888/master/development). 
This displays the config properties which are being retrieved from the git repo defined 
in bootstrap.yml. This currently is the [`server-config` directory in this repository](https://github.com/ericdahl/spring-cloud-config-example/tree/master/server-config).

Note: keep the server running in backround. The client app in the next step needs to connect to it.

### Start Client App
```bash
java -jar client/target/*jar
```

Load [http://localhost:8080](http://localhost:8080) to see the property from the server. 
Alternatively, you can inspect the properties and their sources from the spring-boot-actuator
endpoint at [http://localhost:8080/env](http://localhost:8080/env)

### Reload configuration from server (at runtime)

Spring Cloud Config has a `@RefreshScope` mechanism to allow beans to be reinitialized
on demand to fetch updated configuration values. The AppController on the client
has this annotation, so it will display the new config value once the refresh
endpoint is called.

```bash
curl -X POST 'http://localhost:8080/actuator/refresh'
```
