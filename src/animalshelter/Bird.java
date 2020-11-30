
package animalshelter;


public class Bird extends Animal {

    public Bird(String name, String type, double age, double length, double weight, String place, String gender, double healthRatio, String registerDate, double hungerRatio, String keeper, boolean isSterilize) {
        super(name, type, age, length, weight, place, gender, healthRatio, registerDate, hungerRatio, keeper, isSterilize);
    }

    @Override
    public void setHealth(double health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
