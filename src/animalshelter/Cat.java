
package animalshelter;

public class Cat extends Animal {
    private String health;
    
    public Cat(int id, String type, String name, String age, String gender, String isSterilize, String length, String weight, String place,String health) {
        super(id, type, name, age, gender, isSterilize, length, weight, place);
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    
    @Override
    public void setHealth(String health) {
        this.health = health;
    }
}
