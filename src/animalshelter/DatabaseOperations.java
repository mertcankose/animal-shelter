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
            
            String query = "Select * From animals";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                String length = rs.getString("length");
                String weight = rs.getString("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                
                if(type.equals("Dog")){
                    //output.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                    outputDog.add(new Dog(id,type,name,age,gender,sterilize,length,weight,place,health));
                }     
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
            
            String query = "Select * From animals";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                String length = rs.getString("length");
                String weight = rs.getString("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                
                if(type.equals("Cat")){
                    //output.add(new Cat(id,type,name,age,gender,sterilize,length,weight,place,health));
                    outputCat.add(new Cat(id,type,name,age,gender,sterilize,length,weight,place,health));
                }  
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
            
            String query = "Select * From animals";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String sterilize = rs.getString("sterilize");
                String length = rs.getString("length");
                String weight = rs.getString("weight");
                String place = rs.getString("place");
                String health = rs.getString("health");
                
                if(type.equals("Bird")){
                    //output.add(new Bird(id,type,name,age,gender,sterilize,length,weight,place,health));
                    outputBird.add(new Bird(id,type,name,age,gender,sterilize,length,weight,place,health));
                }
            }
            return outputBird;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
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
            System.out.println("Connection is great!");
        } catch (SQLException ex) {
            System.out.println("Connection failed!!");
        }
    }
}