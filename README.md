# b2w

- Java 8
- Maven
- Docker
- Spring

##### Instalação:

```java
mvn: install
 mvn clean install spring-boot:run
```

##### Instalação Docker:

```java
 mvn clean package
docker build -t app . 
docker run -it -p 8092:8092 --name app-container app
```

#### Configurações globais:
src\main\resources\application.properties 

#### Configurações Gerais
server.port=8092

#### Execução MAVEN:
 mvn clean install spring-boot:run
