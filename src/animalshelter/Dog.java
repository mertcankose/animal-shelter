
package animalshelter;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Dog extends Animal {
    private String type;
    private int hungerRatio = animalHungerRatioLimit; 

    public Dog(int id,String name, int age, String gender, String isSterilize, double length, double weight, String place, String health,String type,String personnel) {
        super(id,name, age, gender, isSterilize, length, weight, place, health,personnel);
        this.type = type; 
    }
    
    public Dog(String name, int age, String gender, String sterilize, double length, double weight, String place, String health, int hungerRatio, String type, Personnel personnel) {
        super(name, age, gender, sterilize, length, weight, place, health,personnel);
        this.type = type;
        this.hungerRatio = hungerRatio;
    }

    public Dog(String name, int age) {
        super(name,age);
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getHungerRatio() {
        return hungerRatio;
    }

    public void setHungerRatio(int hungerRatio) {
        this.hungerRatio = hungerRatio;
    }
    

    @Override
    public int findRemainingLifeTime() {
        int time = (int) (dogAverageLifeTime - this.getAge());
        if(time < 0){
            return 0;
        }else{
            return time;
        }
    }
    
    @Override
    public int learnFoodAmount() {
        int amount = (int) (dogAverageLifeTime - this.getAge());
        if (amount < 0) {
            return 0;
        } else {
            return amount;
        }
    }
}
