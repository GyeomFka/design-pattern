package whiteship.singleton;

public class SettingsInnerClass {

    private SettingsInnerClass() {}

    private static class SettingsHolder{
        private static final SettingsInnerClass INSTANCE = new SettingsInnerClass();
    }

    public static SettingsInnerClass getInstance() {
        return SettingsHolder.INSTANCE;
    }

    /*
    권장사항 중 하나!
    * getInstance가 호출될때 holder 클래스가 로딩이 되고 지연로딩도 가능하다.

    문제는... 지금까지 살펴본 모든 방법을 깨뜨릴 수 있는 다양한 코딩 방법이 존재한다

    그러므로 우린 다 공부해야한다.
    * */

}
