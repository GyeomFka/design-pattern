##싱글톤 (Singleton) 패턴
###실무에서는 어떻게 쓰이나 ?

- 스프링에서 빈의 스코프 중에 하나로 싱글톤 스코프.
- java.lang.Runtime
- 다른 디자인 패턴(빌더, 퍼사드, 추상 팩토리 등) 구현체의 일부로 쓰이기도 한다.

예시
----

### RuntimeExample.class
``` java
public class RuntimeExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //new 키워드 불가능
    }
}
```
- runtime instance → 오직 getRuntime() 으로만 인스턴스 생성이 가능하다
  - 란? 자바 App이 실행되고 있는 일련의 환경, 문맥 정도로 이해하면 된다.
  - 메모리 정보 등
### SpringExample.class
``` java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String hello1 = applicationContext.getBean("hello", String.class);
        String hello2 = applicationContext.getBean("hello", String.class);
        System.out.println(hello1 == hello2);
        //같은 instance가 나오게 되어있다.
    }

}
```
- applicationcontext → 유일한 객체가 필요한 경우