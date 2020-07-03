import java.io.Serializable;

public class User implements Serializable {
  
    private static final long serialVersionUID = 1;
    private String firstName;
    private String lastName;
    private String age;
    private String username;
    private String password;
	private int id;

    
    public User() {
    }
 
    public User(int id) {
        this.id = id;
    }
 
    public User(int id, String firstName, String lastName, String age, String username, String password) {
        this(firstName, lastName, age, username, password);
        this.id = id;
    }
     
    public User(String firstName, String lastName, String age, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    private boolean checkUsername(String username) {
    	return true;
    }

}