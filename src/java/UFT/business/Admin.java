package UFT.business;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {

    /**
     *
     */
    private String adminID;
    private String password;
    private List<String> roles; 
   
    public String getAdminID() {
        return this.adminID;
    }
   
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


}