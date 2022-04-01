# Overview

Unify the response message body with annotations

# Useing

maven pom.xml

```xml
&lt;dependency&gt;&#10;  &lt;groupId&gt;com.github.adon92&lt;/groupId&gt;&#10;  &lt;artifactId&gt;message-spring-boot-starter&lt;/artifactId&gt;&#10;  &lt;version&gt;1.0.0&lt;/version&gt;&#10;&lt;/dependency&gt;
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
