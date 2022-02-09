
싱글톤(Singleton) 패턴 
====
인스턴스를 오직 한개만 제공하는 클래스
----
- [백기선님 유튜브 링크](https://www.youtube.com/watch?v=OwOEGhAo3pI&list=PLfI752FpVCS_v_sc8Q6V9QQN7GhoyktKD&index=1)
-  시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있다. 
 인스턴스를 **오직 한개만** 만들어 제공하는(전역적으로 접근할 수 있도록 방법제공) 클래스가 필요하다.

- **핵심 키워드 - 오직 하나의 인스턴스 && 글로벌 접근**


 | **Singleton**  |
 ---------|
| - instance: Singleton |
| + getInstance(): Singleton |

Example
====
### App.class
``` java
public class App {
 
  public static void main() {

    //Settings set1 = new Settings();
    //Settings set2 = new Settings();
    //System.out.println(set1 != set2);    

    Settings set1 = Settings.getInstance();
    Settings set2 = Settings.getInstance();
    System.out.println(set1 == set2);

  }

}
```
### Settings.class
``` java
public class Settings {

    private static Settings instance;

    private Settings() {}

    public static Settings getInstance() {
        //별도로 핸들링 하지 않으면 getInstance가 각각 new로 생성된다.
        if(instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
```

설명
====
- new 연산자로 인한 두 instance가 다름 → 싱글톤을 사용하려면 ? → **new 연산자로 직접 생성은 안된다**
- 대상 클래스의 private 생성자 → 외부에서 인스턴스 생성 불가능
- 해당 클래스 내부에서 인스턴스 생성 → 글로벌하게 접근 가능한 방법 제공 → static method 구현
  - private 생성자 + public static method
 
- 문제점이 있을 수 있다. → 가령 웹 에서는 "멀티쓰레드"를 사용한다.

그러면 ?
====
- 멀티스레드 환경에서 이 코드(싱글톤 구현)가 안전한가 ?
- 안전하지 않다 안전하지 않은 이유 
  - ex)a 쓰레드와 b 쓰레드가 있다 가정 → a 쓰레드가 if문을 지날때 b 쓰레드가 생성되면 new 연산자 두 번 호출

멀티스레드에서 안전하게 싱글톤을 구현하는 방법
====
I. 메소드 동기화
----
``` java
public class Settings {

    private static Settings instance;

    private Settings() {}

    public static synchronized Settings getInstance() {
        if(instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
```
- **synchronized 키워드 사용하기 → 해당 메서드에 한 번에 한 개의 스레드만 들어오게**
    - 단점 : getInstance() 사용시 성능 저하 → 동기화 처리 작업때문에 → 동기화라는 메커니즘 자체가 lock을 컨트롤 하기때문

II. 이른 초기화(eager initialization) 사용하기
----
``` java
public class Settings {

    private static final Settings INSTANCE = new Settings();

    private Settings() {}

    public static Settings getInstance() {
        return INSTANCE;
    }
}
```
- 객체를 만드는 비용이 크지 않다고 한다고 가정
    - INSTANCE가 클래스 로딩 시점에 스태틱하게 초기화가 된다.
    - 단점 : '미리 만든다는 것 자체'가 단점이 될 수 있음 (안쓰는 객체를 만든다면)

III. double checked locking 사용하기
----
``` java
public class Settings {

    private static volatile Settings instance;

    private Settings() {}

    public static Settings getInstance() {
        if(instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}
```
- 기존 **메소드 동기화** 보다 효율적이다 → getInstance() 메소드를 호출 할 때마다 Synchronized가 걸리지 않는다.   
→ instance가 있는 경우에는 Synchronized 키워드를 스킵한다 == Synchronized 메커니즘을 사용하지 않는다.

- Instance를 필요한 시점에만 생성할 수 있다.
    - 단점
      - 굉장히 복잡한 volatile을 이해해야 한다.
      - 1.5 이상부터 써야한다.
      - 소스코드가 복잡해진다.

IV. static inner class(권장)
----
``` java
public class Settings {
    //private static Settings instance;
    private Settings() {}

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
```
- 권장사항 중 하나
- 멀테스레드 환경에서도 안전하다 
  → getInstance가 호출될 때 holder 클래스가 로딩이 되고(= 인스턴스화 시킨다) 지연로딩도 가능하다.
