package animalshelter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bird extends Animal {

    private String type;
    private String isTalk;
    private int hungerRatio = birdHungerLimit; //kg

    public Bird(int id, String name, int age, String gender, String isSterilize, double length, double weight, String place, String health, String type, String isTalk, String personnel) {
        super(id, name, age, gender, isSterilize, length, weight, place, health, personnel);
        this.type = type;
        this.isTalk = isTalk;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(decraseHungerRatio, 0, 3, TimeUnit.SECONDS);
    }

    public Bird(String name, int age) {
        super(name, age);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String isIsTalk() {
        return isTalk;
    }

    public void setIsTalk(String isTalk) {
        this.isTalk = isTalk;
    }

    public int getHungerRatio() {
        return hungerRatio;
    }

    public void setHungerRatio(int hungerRatio) {
        this.hungerRatio = hungerRatio;
    }

    Runnable decraseHungerRatio = new Runnable() {
        public void run() {
            hungerRatio--;
        }
    };

    @Override
    public int findRemainingLifeTime() {
        int time = (int) (birdAverageLifeTime - this.getAge());
        if (time < 0) {
            return 0;
        } else {
            return time;
        }
    }

    @Override
    public int giveFood() {
        hungerRatio++;
        return hungerRatio;
    }

}
