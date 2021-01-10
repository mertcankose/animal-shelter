
package animalshelter;

public abstract class Animal implements IOzellik {
    private int id;
    private String name;
    private int age;
    private String gender;
    private boolean isSterilize;
    private double length;
    private double weight;
    private String place;
    private String stateOfHealth;
    private Personnel personnel;
    private String personnelName;
    
    public Animal(int id,String name, int age, String gender, boolean isSterilize, double length, double weight, String place, String stateOfHealth,String personnelName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isSterilize = isSterilize;
        this.length = length;
        this.weight = weight;
        this.place = place;
        this.stateOfHealth = stateOfHealth;
        this.personnelName = personnelName;
    }
    
    public abstract int giveFood();

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isIsSterilize() {
        return isSterilize;
    }

    public void setIsSterilize(boolean isSterilize) {
        this.isSterilize = isSterilize;
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

    public String getStateOfHealth() {
        return stateOfHealth;
    }

    public void setStateOfHealth(String stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", isSterilize=" + isSterilize + ", length=" + length + ", weight=" + weight + ", place=" + place + ", stateOfHealth=" + stateOfHealth + '}';
    }
}

