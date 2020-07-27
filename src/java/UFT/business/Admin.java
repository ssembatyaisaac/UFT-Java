package UFT.business;


public class Admin extends Person {

    /**
     *
     */
    private static final long serialVersionUID = 1358088466050025901L;
    public String adminID;
  
    
    
    public Admin() {
        this.adminID = "None";
    }

   
    public String getAdminID() {
        return this.adminID;
    }

    
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

}