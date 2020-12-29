
package animalshelter;

public class Dog extends Animal {

    public Dog(int id, String type, String name, String age, String gender, String isSterilize, String length, String weight, String place) {
        super(id, type, name, age, gender, isSterilize, length, weight, place);
    }
    
    @Override
    public void setHealth(String health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
