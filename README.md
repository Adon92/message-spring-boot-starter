# Overview

Unify the response message body with annotations

# Useing

maven pom.xml

```xml
<dependency>
    <groupId>com.github.adon92</groupId>
    <artifactId>message-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

```java
import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
}

```

Introduce annotations `@MessageReponse`

```java

@MessageResponse
@RestController
@RequestMapping
public class TestController {

    @GetMapping
    public User get() {
        User user = new User();
        user.setName("Tony");
        user.setAge(18);
        return user;
    }
}
```

Response Body

```json
{
  "success": true,
  "msg": "ok",
  "data": {
    "name": "Tony",
    "age": 18
  }
}
```

Exception Handler

```java
// method
public void Test(){
        // some code
        if(null==object){
        throw new MessageExcption("error message");
        }
        }
```

Response Body

```json
{
  "success": true,
  "msg": "error message",
  "data": null
}
}
```
