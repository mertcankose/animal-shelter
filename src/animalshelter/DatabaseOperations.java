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
                boolean sterilize = rs.getBoolean("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("stateOfHealth");
                String strain = rs.getString("strain");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputDog.add(new Dog(id,name,age,gender,sterilize,length,weight,place,health,strain,personnel));     
            }
            return outputDog;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                boolean sterilize = rs.getBoolean("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("stateOfHealth");
                boolean agressive = rs.getBoolean("agressive");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputCat.add(new Cat(id,name,age,gender,sterilize,length,weight,place,health,agressive,personnel));   
            }
            return outputCat;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
                boolean sterilize = rs.getBoolean("sterilize");
                double length = rs.getDouble("length");
                double weight = rs.getDouble("weight");
                String place = rs.getString("place");
                String health = rs.getString("stateOfHealth");
                String strain = rs.getString("strain");
                boolean talk = rs.getBoolean("talk");
                //int hungerRatio = rs.getInt("hungerRatio");
                String personnel = rs.getString("personnel");
              
                //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                outputBird.add(new Bird(id,name,age,gender,sterilize,length,weight,place,health,strain,talk,personnel));   
            }
            return outputBird;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    public void addCat(String name, int age,String gender,boolean sterilize,double length,double weight,String place,String health, boolean agressive, int hungerRatio,Personnel personnel){
        String query = "Insert Into cats (name,age,gender,sterilize,length,weight,place,stateOfHealth,agressive,hungerRatio,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, age);
            prepareStatement.setString(3, gender);
            prepareStatement.setBoolean(4, sterilize);
            prepareStatement.setDouble(5, length);
            prepareStatement.setDouble(6, weight);
            prepareStatement.setString(7, place);
            prepareStatement.setString(8, health);
            prepareStatement.setBoolean(9, agressive);
            prepareStatement.setInt(10, hungerRatio);
            prepareStatement.setString(11, personnel.getName());
            //System.out.println("databasee yollanacak: " + personnel.getName());
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addBird(String name, int age,String gender,boolean sterilize,double length,double weight,String place,String health, String strain, boolean talk, int hungerRatio,Personnel personnel){
        String query = "Insert Into birds (name,age,gender,sterilize,length,weight,place,stateOfHealth,strain,talk,hungerRatio,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, age);
            prepareStatement.setString(3, gender);
            prepareStatement.setBoolean(4, sterilize);
            prepareStatement.setDouble(5, length);
            prepareStatement.setDouble(6, weight);
            prepareStatement.setString(7, place);
            prepareStatement.setString(8, health);
            prepareStatement.setString(9, strain);
            prepareStatement.setBoolean(10, talk);
            prepareStatement.setInt(11, hungerRatio);
            prepareStatement.setString(12, personnel.getName());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void addDog(String name, int age,String gender,boolean sterilize,double length,double weight,String place,String health, String strain, int hungerRatio,Personnel personnel){
        String query = "Insert Into dogs (name,age,gender,sterilize,length,weight,place,stateOfHealth,strain,hungerRatio,personnel) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, age);
            prepareStatement.setString(3, gender);
            prepareStatement.setBoolean(4, sterilize);
            prepareStatement.setDouble(5, length);
            prepareStatement.setDouble(6, weight);
            prepareStatement.setString(7, place);
            prepareStatement.setString(8, health);
            prepareStatement.setString(9, strain);
            prepareStatement.setInt(10, hungerRatio);
            prepareStatement.setString(11, personnel.getName());
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public void addAnimal(String type,String name, String age,String gender,String sterilize,String length,String weight, String place,String health){
        String query = "Insert Into animals (type,name,age,gender,sterilize,length,weight,place,health) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setString(1, type);
            prepareStatement.setString(2, name);
            prepareStatement.setString(3, age);
            prepareStatement.setString(4, gender);
            prepareStatement.setString(5, sterilize);
            prepareStatement.setString(6, length);
            prepareStatement.setString(7, weight);
            prepareStatement.setString(8, place);
            prepareStatement.setString(9, health);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    
    
    
    public void updateCat(int id,String new_name, int new_age, String new_gender,boolean new_sterilize,double new_length,double new_weight,String new_place,String new_health,boolean new_agressive,int new_hungerRatio){
        String query = "Update cats set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, stateOfHealth = ?, agressive = ?, hungerRatio = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setBoolean(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setBoolean(9, new_agressive);
            prepareStatement.setInt(10, new_hungerRatio);

            prepareStatement.setInt(11, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBird(int id,String new_name, int new_age, String new_gender,boolean new_sterilize,double new_length,double new_weight,String new_place,String new_health,String new_strain,boolean new_talk,int new_hungerRatio){
        String query = "Update birds set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, stateOfHealth = ?, strain = ?,talk = ?, hungerRatio = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setBoolean(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setString(9, new_strain);
            prepareStatement.setBoolean(10, new_talk);
            prepareStatement.setInt(11, new_hungerRatio);

            prepareStatement.setInt(12, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void updateDog(int id,String new_name, int new_age, String new_gender,boolean new_sterilize,double new_length,double new_weight,String new_place,String new_health,String new_strain,int new_hungerRatio){
        String query = "Update dogs set name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, stateOfHealth = ?, strain = ?, hungerRatio = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            //prepareStatement.setString(1, new_type);
            prepareStatement.setString(1, new_name);
            prepareStatement.setInt(2, new_age);
            prepareStatement.setString(3, new_gender);
            prepareStatement.setBoolean(4, new_sterilize);
            prepareStatement.setDouble(5, new_length);
            prepareStatement.setDouble(6, new_weight);
            prepareStatement.setString(7, new_place);
            prepareStatement.setString(8, new_health);
            prepareStatement.setString(9, new_strain);
            prepareStatement.setInt(10, new_hungerRatio);

            prepareStatement.setInt(11, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public void updateAnimal(int id,String new_type,String new_name, String new_age, String new_gender,String new_sterilize,String new_length,String new_weight,String new_place,String new_health){
        String query = "Update animals set type = ?, name = ?, age = ?, gender = ?, sterilize = ?, length = ?, weight = ?, place = ?, health = ? where id = ?";

        try {
            prepareStatement = con.prepareStatement(query);

            prepareStatement.setString(1, new_type);
            prepareStatement.setString(2, new_name);
            prepareStatement.setString(3, new_age);
            prepareStatement.setString(4, new_gender);
            prepareStatement.setString(5, new_sterilize);
            prepareStatement.setString(6, new_length);
            prepareStatement.setString(7, new_weight);
            prepareStatement.setString(8, new_place);
            prepareStatement.setString(9, new_health);

            prepareStatement.setInt(10, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
     
     
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
     
     
     /*
    public void deleteAnimal(int id){
        String query = "Delete FROM animals where id = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1,id);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    public boolean login(String username,String password){
        String query = "Select * From admins where username = ? and password = ?";
        
        try {
            prepareStatement = con.prepareStatement(query);
            
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public void register (String username, String password){
        String query = "Insert Into admins (username,password) VALUES(?,?)";
             
        try {
            prepareStatement = con.prepareStatement(query);
            
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DatabaseOperations(){
        //jdbc:mysql://localhost:3306/animal_shelter
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name + "?useUnicode=true&characterEncoding=utf8";
             
        try {
            con = DriverManager.getConnection(url,Database.username,Database.password);
            //System.out.println("Connection is great!");
        } catch (SQLException ex) {
            //System.out.println("Connection failed!!");
        }
    }
}