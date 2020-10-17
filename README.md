# hello_spring

#### Generated with [spring initializr](https://start.spring.io/)

### How to run application?
```
mvn install
java -jar ./target/springhello-0.0.1-SNAPSHOT.jar
``` 

### How to copy to the server ?
- ``7000`` - server's ssh port
- ``user`` - server's user
- ``127.0.0.1`` - server's ip
- ``./target/springhello-0.0.1-SNAPSHOT.jar`` - path of application's jar
```
scp -p 7000 ./target/springhello-0.0.1-SNAPSHOT.jar user@127.0.0.1:/home/user
```

### How to run application on the server ?
```
java -jar springhello-0.0.1-SNAPSHOT.jar
```