package s1.singleton;

public class SettingsBySynchro {

    private static SettingsBySynchro instance;

    private SettingsBySynchro() {}

    public static synchronized SettingsBySynchro getInstance() {
        if(instance == null) {
            instance = new SettingsBySynchro();
        }
        return instance;
    }

}
