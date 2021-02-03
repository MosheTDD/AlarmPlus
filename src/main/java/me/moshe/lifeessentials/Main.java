package me.moshe.lifeessentials;

import me.moshe.lifeessentials.alarmplus.AlarmPlus;

import java.io.File;

public class Main {
    public static SettingsYamlFile settings;

    public static void main(String[] args) {
        settings = new SettingsYamlFile("settings", new File("./"));
        settings.setup();

        AlarmPlus alarmPlus = new AlarmPlus();
        alarmPlus.start();
    }
}
