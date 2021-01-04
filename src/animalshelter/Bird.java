
package animalshelter;

public class Bird extends Animal {
    private String health;
    public Bird(int id, String type, String name, String age, String gender, String isSterilize, String length, String weight, String place,String health) {
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
