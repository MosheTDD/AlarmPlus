package me.moshe.alarmplus;

import me.moshe.alarmplus.ui.Interface;

import java.io.File;

public class Main {
    public static SettingsYamlFile settings;
    private static Interface inf = new Interface();

    public static void main(String[] args) {
        settings = new SettingsYamlFile("settings", new File("./"));
        settings.setup();

        AlarmPlus.start();
        inf.start(args);
    }
}
