package s1.singleton;

public class SettingsByDoubleChecked {

    private static volatile SettingsByDoubleChecked instance;

    private SettingsByDoubleChecked() {
    }

    public static SettingsByDoubleChecked getInstance() {
        if(instance == null) {
            synchronized (SettingsByDoubleChecked.class) {
                if (instance == null) {
                    instance = new SettingsByDoubleChecked();
                }
            }
        }
        return instance;
    }

}
/*
* instance변수에 volatile이라는 키워드까지 완성해야한다.
* 기존 메소드 동기화보다 효율적인 이유?
* -> getInstance 메소드 호출때마다 싱크로가 걸리지 않는다. 인스턴스가 있는 경우에는
*       싱크로 부분을 스킵을 하게 된다. -> 인스턴스 있을때 동기화 메커니즘을 사용하지 않는다.
*
*  메소드 자체에 싱크로 걸려 있는것 보단. 더 효율적이다.
*
*  또다른 장점 -> 인스턴스를 필요로 하는 시점에 만들 수 있다
*
* 또다른 문제 -> 굉장히 복잡 volatile을 왜 써야하는지까지 이해하려면 ... 어렵다 1.5이상부터 동작한다.
*
* */

