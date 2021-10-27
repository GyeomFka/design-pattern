package s2.singleton;

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
