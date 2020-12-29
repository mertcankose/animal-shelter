
package animalshelter;

public abstract class Animal {
    private int id;
    private String type;
    private String name;
    private String age;
    private String length;
    private String weight;
    private String gender;
    private String place;
    private String isSterilize;
    
    public Animal(int id,String type, String name, String age, String gender,String isSterilize, String length, String weight, String place) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.length = length;
        this.weight = weight;
        this.place = place;
        this.gender = gender;
        this.isSterilize = isSterilize;
    }
    
    public abstract void setHealth(String health);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIsSterilize() {
        return isSterilize;
    }

    public void setIsSterilize(String isSterilize) {
        this.isSterilize = isSterilize;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    @Override
    public String toString() {
        return "Animal{" + "type=" + type + ", name=" + name + ", age=" + age + ", length=" + length + ", weight=" + weight + ", gender=" + gender + ", place=" + place + ", isSterilize=" + isSterilize + '}';
    }

  
    
    
}

