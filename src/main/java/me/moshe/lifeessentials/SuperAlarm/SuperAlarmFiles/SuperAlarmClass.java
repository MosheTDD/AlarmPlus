package me.moshe.lifeessentials.SuperAlarm.SuperAlarmFiles;

import me.border.utilities.file.AbstractYamlFile;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SuperAlarmClass extends AbstractYamlFile {
    static AudioClip clip;

    public SuperAlarmClass(String name, File path) {
        super(name, path);
    }


    public static void startSuperAlarm(){
        setDate(23, 00);
    }

    public static void setDate(int h, int m){//FIX
        while(LocalTime.now().getHour() == h){

        }


    }

    public static synchronized void audioManager() {
        try {
            File file = new File("C:\\Users\\97250\\IdeaProjects\\LifeEssentials\\src\\main\\java\\me\\moshe\\lifeessentials\\SuperAlarm\\SuperAlarmFiles\\TestAudio.wav");
            clip = (AudioClip) file.toURI().toURL().getContent();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unlock(){
        Scanner sc = new Scanner(System.in);
        int input = 0;//GET FROM JFX
        int rndNum = (int) Math.floor(Math.random() * (10000 - 1000) + 1000);
        while (input != rndNum){
            System.out.println("Enter this number: " + rndNum);
            clip.play();
            input = sc.nextInt();
            if(input != rndNum)
                System.out.println("Try again!");
        }
        clip.stop();
        System.out.println("Good morning!");
    }
}
