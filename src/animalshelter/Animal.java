
package animalshelter;


public class Animal {
    private String name;
    private String type;
    private double age;
    private double length;
    private double weight;
    private String gender;
    private String place;
    private double healthRatio;
    private String registerDate;
    private double hungerRatio;
    private String keeper;
    private boolean isSterilize;
    

    public Animal(String name, String type, double age, double length, double weight, String place, String gender, double healthRatio, String registerDate, double hungerRatio,String keeper,boolean isSterilize) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.length = length;
        this.weight = weight;
        this.place = place;
        this.gender = gender;
        this.healthRatio = healthRatio;
        this.registerDate = registerDate;
        this.hungerRatio = hungerRatio;
        this.keeper = keeper;
        this.isSterilize = isSterilize;
    }
    
    public double eat(){
        return this.hungerRatio;
    }
    public double getDrug(){
        return this.healthRatio;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHealth() {
        return this.healthRatio;
    }

    public void setHealth(String health) {
        this.healthRatio = healthRatio;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", type=" + type + ", age=" + age + ", length=" + length + ", weight=" + weight + ", place=" + place + ", gender=" + gender + ", health=" + healthRatio + ", registerDate=" + registerDate + '}';
    }
    
    
}

