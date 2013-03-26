Spock extension for Google Appengine
====================================

Start/stop GAE testing environment for your Spock tests

Latest stable version: *0.1*

Compiled against Groovy 2.1.0, Spock 0.7-groovy-2.0 and GAE 1.7.5, but it should be working under other
versions.

Maven dependency
----------------

```xml
<dependency>
    <groupId>com.the6hours</groupId>
    <artifactId>spock-appengine</artifactId>
    <version>0.1</version>
    <scope>test</scope>
</dependency>
```

and repository:

```xml
<repositories>
    <repository>
        <id>the6hours</id>
        <url>http://maven.the6hours.com/release</url>
        <releases><enabled>true</enabled></releases>
        <snapshots><enabled>false</enabled></snapshots>
    </repository>
</repositories>
```

And don't forget to add dependencies to Appengine stubs/testing:

```xml
<dependency>
    <groupId>com.google.appengine</groupId>
    <artifactId>appengine-api-stubs</artifactId>
    <version>${gae.version}</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>com.google.appengine</groupId>
    <artifactId>appengine-testing</artifactId>
    <version>${gae.version}</version>
    <scope>test</scope>
</dependency>
```

How to use
----------

Add `@WithGae` annotation to your specification. Just it.

Example:
```Groovy
import com.the6hours.spockappengine.WithGae

@WithGae
class MyTest extends Specification {

  def 'Test something under GAE'() {
    .......
  }

}
```

License
-------

Licensed under the Apache License, Version 2.0

