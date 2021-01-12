package animalshelter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    private String isAgressive;
    private int hungerRatio = catHungerLimit;

    public Cat(int id, String name, int age, String gender, String isSterilize, double length, double weight, String place, String health, String isAgressive, String personnel) {
        super(id, name, age, gender, isSterilize, length, weight, place, health, personnel);
        this.isAgressive = isAgressive;

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(decraseHungerRatio, 0, 3, TimeUnit.SECONDS);
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public String isIsAgressive() {
        return isAgressive;
    }

    public void setIsAgressive(String isAgressive) {
        this.isAgressive = isAgressive;
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
        int time = (int) (catAverageLifeTime - this.getAge());
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
