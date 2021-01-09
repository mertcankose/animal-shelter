
package animalshelter;

public class Personnel {
    private String name;
    private boolean authority;
    
    
    public Personnel(String name, boolean authority) {
        this.name = name;
        this.authority = authority;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getAuthority() {
        return authority;
    }

    public void setAuthority(boolean authority) {
        this.authority = authority;
    }
    
    
}
