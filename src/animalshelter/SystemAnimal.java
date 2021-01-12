
package animalshelter;

import java.util.ArrayList;

public class SystemAnimal {
    
    //database - local
    /*
    public static final String username = "root";
    public static final String password = "";
    public static final String db_name = "animal_shelter";
    public static final String host = "localhost";
    public static final int port = 3306;
    */
    
    //database - remote
    public static final String username = "a6dace_animals";
    public static final String password = "newAnimalmert96!";
    public static final String db_name = "db_a6dace_animals";
    public static final String host = "mysql5044.site4now.net";
    public static final int port = 3306;  
    
    //ShelterGui
    public static ArrayList<Dog> dogsArrayList = new ArrayList<Dog>();
    public static ArrayList<Cat> catsArrayList = new ArrayList<Cat>();
    public static ArrayList<Bird> birdsArrayList = new ArrayList<Bird>();
}