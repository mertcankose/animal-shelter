package animalshelter;

public class Cat extends Animal {

    private String isAgressive;
    private int hungerRatio = animalHungerRatioLimit;

    public Cat(int id, String name, int age, String gender, String isSterilize, double length, double weight, String place, String health, String isAgressive, String personnel) {
        super(id, name, age, gender, isSterilize, length, weight, place, health, personnel);
        this.isAgressive = isAgressive;
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name, int age, String gender, String sterilize, double length, double weight, String place, String health, int hungerRatio, String agressive, Personnel personnel) {
        super(name, age, gender, sterilize, length, weight, place, health, personnel);
        this.isAgressive = agressive;
        this.hungerRatio = hungerRatio;
    }

    public String getIsAgressive() {
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
    public int learnFoodAmount() {
        int amount = (int) (catAverageLifeTime - this.getAge());
        if (amount < 0) {
            return 0;
        } else {
            return amount;
        }
    }
}
