package animalshelter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bird extends Animal {

    private String type;
    private String isTalk;
    private int hungerRatio = animalHungerRatioLimit; //kg

    public Bird(int id, String name, int age, String gender, String isSterilize, double length, double weight, String place, String health, String type, String isTalk, String personnel) {
        super(id, name, age, gender, isSterilize, length, weight, place, health, personnel);
        this.type = type;
        this.isTalk = isTalk;
    }
    
    public Bird(String name, int age, String gender, String sterilize, double length, double weight, String place, String health, int hungerRatio, String type, String isTalk, Personnel personnel) {
        super(name, age, gender, sterilize, length, weight, place, health, personnel);
        this.type = type;
        this.isTalk = isTalk;
        this.hungerRatio = hungerRatio;
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

    public String getIsTalk() {
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
    public int learnFoodAmount() {
        int amount = (int) (birdAverageLifeTime - this.getAge());
        if (amount < 0) {
            return 0;
        } else {
            return amount;
        }
    }
}
