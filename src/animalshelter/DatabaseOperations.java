package animalshelter;

// import com.mysql.cj.xdevapi.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseOperations {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement prepareStatement = null;
    
    public ArrayList<Dog> getDogs(){
        ArrayList<Dog> outputDog = new ArrayList<Dog>();
        try {
            statement = con.createStatement();
            
            String query = "Select * From dogs";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                //String type = rs.getString("type");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                String type = rs.getString("type");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputDog.add(new Dog(id,name,age,gender,sterilize,length,weight,place,health,type,personnel));     
            }
            return outputDog;
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemAnimal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Cat> getCats(){
        ArrayList<Cat> outputCat = new ArrayList<Cat>();
        
        try {
            statement = con.createStatement();
            
            String query = "Select * From cats";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                //String type = rs.getString("type");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                String agressive = rs.getString("agressive");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputCat.add(new Cat(id,name,age,gender,sterilize,length,weight,place,health,agressive,personnel));   
            }
            return outputCat;
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemAnimal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Bird> getBirds(){
        ArrayList<Bird> outputBird = new ArrayList<Bird>();
        
        try {
            statement = con.createStatement();
            
            String query = "Select * From birds";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                //String type = rs.getString("type");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                String type = rs.getString("type");
                String talk = rs.getString("talk");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputBird.add(new Bird(id,name,age,gender,sterilize,length,weight,place,health,type,talk,personnel));   
            }
            return outputBird;
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemAnimal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    public void addCat(Cat cat){
        String query = "Insert Into cats (name,age,gender,sterilize,length,weight,place,health,hungerRatio,agressive,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, cat.getName());
            prepareStatement.setInt(2, cat.getAge());
            prepareStatement.setString(3, cat.getGender());
            prepareStatement.setString(4, cat.getIsSterilize());
            prepareStatement.setDouble(5, cat.getLength());
            prepareStatement.setDouble(6, cat.getWeight());
            prepareStatement.setString(7, cat.getPlace());
            prepareStatement.setString(8, cat.getStateOfHealth());
             prepareStatement.setInt(9, cat.getHungerRatio());
            prepareStatement.setString(10, cat.getIsAgressive());
            prepareStatement.setString(11, cat.getPersonnel().getName());
            //System.out.println("databasee yollanacak: " + personnel.getName());
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addBird(String name, int age,String gender,String sterilize,double length,double weight,String place,String health,int hungerRatio, String type, String talk,Personnel personnel){
        String query = "Insert Into birds (name,age,gender,sterilize,length,weight,place,health,hungerRatio,type,talk,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, age);
            prepareStatement.setString(3, gender);
            prepareStatement.setString(4, sterilize);
            prepareStatement.setDouble(5, length);
            prepareStatement.setDouble(6, weight);
            prepareStatement.setString(7, place);
            prepareStatement.setString(8, health);
             prepareStatement.setInt(9, hungerRatio);
            prepareStatement.setString(10, type);
            prepareStatement.setString(11, talk);
            prepareStatement.setString(12, personnel.getName());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void addDog(String name, int age,String gender,String sterilize,double length,double weight,String place,String health, int hungerRatio, String type,Personnel personnel){
        String query = "Insert Into dogs (name,age,gender,sterilize,length,weight,place,health,hungerRatio,type,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, age);
            prepareStatement.setString(3, gender);
            prepareStatement.setString(4, sterilize);
            prepareStatement.setDouble(5, length);
            prepareStatement.setDouble(6, weight);
            prepareStatement.setString(7, place);
            prepareStatement.setString(8, health);
            prepareStatement.setInt(9, hungerRatio);
            prepareStatement.setString(10, type);
            prepareStatement.setString(11, personnel.getName());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
    public void updateCat(int id,String new_name, int new_age, String new_gender,String new_sterilize,double new_length,double new_weight,String new_place,String new_health,int new_hungerRatio,String new_agressive){
        String query = "Update cats set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, health = ?, hungerRatio = ?, agressive = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setString(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setInt(9, new_hungerRatio);
            prepareStatement.setString(10, new_agressive);
            prepareStatement.setInt(11, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBird(int id,String new_name, int new_age, String new_gender,String new_sterilize,double new_length,double new_weight,String new_place,String new_health,int new_hungerRatio,String new_type,String new_talk){
        String query = "Update birds set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, health = ?, hungerRatio = ? , type = ?, talk = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setString(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setInt(9, new_hungerRatio);
            prepareStatement.setString(10, new_type);
            prepareStatement.setString(11, new_talk);
            prepareStatement.setInt(12, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void updateDog(int id,String new_name, int new_age, String new_gender,String new_sterilize,double new_length,double new_weight,String new_place,String new_health,int new_hungerRatio,String new_type){
        String query = "Update dogs set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, health = ?, hungerRatio = ?, type = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setString(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setInt(9, new_hungerRatio);
            prepareStatement.setString(10, new_type);
            prepareStatement.setInt(11, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void deleteCat(int id){
        String query = "Delete FROM cats where id = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1,id);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    public void deleteBird(int id){
        String query = "Delete FROM birds where id = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1,id);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDog(int id){
        String query = "Delete FROM dogs where id = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1,id);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public boolean login(Personnel personnel){
        String query = "Select * From users where username = ? and password = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            
            prepareStatement.setString(1, personnel.getName());
            prepareStatement.setString(2, personnel.getPassword());
            
            ResultSet rs = prepareStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public void register (Personnel personnel){
        String query = "Insert Into users (username,password) VALUES(?,?)";
             
        try {
            prepareStatement = con.prepareStatement(query);
            System.out.println("test-register " + personnel.getName() + " " + personnel.getPassword());
            prepareStatement.setString(1, personnel.getName());
            prepareStatement.setString(2, personnel.getPassword());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DatabaseOperations(){
        //jdbc:mysql://localhost:3306/animal_shelter
        String url = "jdbc:mysql://" + SystemAnimal.host + ":" + SystemAnimal.port + "/" + SystemAnimal.db_name + "?useUnicode=true&characterEncoding=utf8";
             
        try {
            con = DriverManager.getConnection(url,SystemAnimal.username,SystemAnimal.password);
            //System.out.println("Connection is great!");
        } catch (SQLException ex) {
            //System.out.println("Connection failed!!");
        }
    }
}