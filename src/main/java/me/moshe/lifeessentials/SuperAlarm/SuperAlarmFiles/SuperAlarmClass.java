package me.moshe.lifeessentials.SuperAlarm.SuperAlarmFiles;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Scanner;

public class SuperAlarmClass {
    static AudioClip clip;



    public static void startSuperAlarm(){
        audioManager();
        unlock();
    }

    public static synchronized void audioManager() {
        try {
            File file = new File("C:\\Users\\97250\\IdeaProjects\\LifeEssentials\\src\\main\\java\\me\\moshe\\lifeessentials\\SuperAlarm\\SuperAlarmFiles\\TestAudio.wav");//FIX
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
