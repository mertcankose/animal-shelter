
package animalshelter;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Dog extends Animal {
    private String type;
    private int hungerRatio = dogHungerLimit; 

    public Dog(int id,String name, int age, String gender, String isSterilize, double length, double weight, String place, String health,String type,String personnel) {
        super(id,name, age, gender, isSterilize, length, weight, place, health,personnel);
        this.type = type;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(decraseHungerRatio, 0, 3, TimeUnit.SECONDS); 
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
    
    
    
    Runnable decraseHungerRatio = new Runnable() {
    public void run() {
        hungerRatio--;
    }
    };

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
    public int giveFood() {
       hungerRatio++;
        return hungerRatio;
    }
  

}
