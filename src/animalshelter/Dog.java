
package animalshelter;


public class Dog extends Animal {

    public Dog(String name, String type, double age, double length, double weight, String place, String gender, double healthRatio, String registerDate, double hungerRatio, String keeper, boolean isSterilize) {
        super(name, type, age, length, weight, place, gender, healthRatio, registerDate, hungerRatio, keeper, isSterilize);
        System.out.println("asdassad");
    }

    @Override
    public void setHealth(double health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
