package me.moshe.lifeessentials.alarmplus;

import me.border.utilities.scheduler.TaskBuilder;
import me.moshe.lifeessentials.Main;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AlarmPlus extends Thread{
    private Clip clip;
    private boolean stop = false;

    public void run(){
        audioManager();
        setDate(21, 39);
    }

    private void setDate(int h, int m){//FIX
        calculateTime(h, m);
    }

    private synchronized void audioManager() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Main.settings.getString("SuperAlarm.AudioFilePath")).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    private void unlock(){
        if(stop) {
            stop = false;
            return;
        }
        Scanner sc = new Scanner(System.in);
        int input = 0;//GET FROM JFX
        int rndNum = (int) Math.floor(Math.random() * (10000 - 1000) + 1000);
        while (input != rndNum){
            System.out.println("Enter this number: " + rndNum);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            input = sc.nextInt();
            if(input != rndNum)
                System.out.println("Try again!");
        }
        clip.stop();
        stop = true;
        System.out.println("Good morning!");

    }

    private void calculateTime(int designatedHour, int designatedMinute){
        LocalDateTime time = LocalDateTime.now();
        int year = time.getYear();
        Month month = time.getMonth();
        int dayOfMonth = time.getDayOfMonth();
        int hour = time.getHour();
        int minute = time.getMinute();

        long millis;
        LocalDateTime then;
        if (hour > designatedHour || hour == designatedHour && minute >= designatedMinute) {
            boolean leapYear = time.getChronology().isLeapYear(year);
            int lastDayOfYear = leapYear ? 366 : 365;
            int lastDayOfMonth = month.length(leapYear);

            boolean monthOver = dayOfMonth == lastDayOfMonth;

            then = LocalDateTime.of(time.getDayOfYear() == lastDayOfYear ? year+1 : year,
                    monthOver ? month.plus(1) : month,
                    monthOver ? 1 : dayOfMonth+1, designatedHour, designatedMinute);

        } else {
            then = LocalDateTime.of(year, month, dayOfMonth, designatedHour, designatedMinute);
        }
        System.out.println(then);
        millis = time.until(then, ChronoUnit.MILLIS);

        TaskBuilder.builder()
                .async()
                .after(millis, TimeUnit.MILLISECONDS)
                .task(new TimerTask() {
                    @Override
                    public void run() {
                        unlock();
                        calculateTime(designatedHour, designatedMinute);
                    }
                })
                .build();
    }
}
