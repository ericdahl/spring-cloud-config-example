[![Build Status](https://travis-ci.org/ericdahl/spring-cloud-config-example.svg)](https://travis-ci.org/ericdahl/spring-cloud-config-example)

# spring-cloud-config-example
basic example of using spring-cloud-config to retrieve configs from a git-backed server

## Quick Start

### Build code

```bash
$ git clone git@github.com:ericdahl/spring-cloud-config-example.git
$ cd spring-cloud-config-example
$ mvn clean package
```

### Start Config Server

```bash
$ java -jar server/target/*jar
```

Load http://localhost:8888/master/development. This displays the config
properties which are being retrieved from the git repo defined in bootstrap.yml
which currently is the `config` directory in this repository.

### Start Client App
```bash
java -jar client/target/*jar
```

Load http://localhost:8080/env/info.foo