package whiteship.singleton;

public class SettingsByEagerIni {

    private static final SettingsByEagerIni INSTANCE = new SettingsByEagerIni();

    private SettingsByEagerIni() {}

    public static SettingsByEagerIni getInstance() {
        return INSTANCE;
    }
}
