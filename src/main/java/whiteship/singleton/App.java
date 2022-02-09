package whiteship.singleton;

public class App {

    public static void main(String[] args) {

        /*
        Settings set1 = new Settings();
        Settings set2 = new Settings();
        System.out.println(set1 != set2);
        */

        Settings set1 = Settings.getInstance();
        Settings set2 = Settings.getInstance();
        System.out.println(set1 == set2);

    }

}
