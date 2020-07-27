package UFT.business;

import javax.persistence.Entity;

//import java.util.*;

/**
 * 
 */
@Entity
public class Agent extends Person {

    /**
     *
     */
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String agentID;
    private String districtName;
    private int numberOfEnrolled;
    
    
    public Agent() {
        super();
        this.agentID = "None";
        this.districtName = "No District";
        this.numberOfEnrolled = 0;
    }

    public Agent (String fName, String lName, String gender, String telephone1, String telephone2,
    String emailAddress, String dateOfBirth, String agentID, String districtName, int enrolled) {
        super(fName, lName, gender, telephone1, telephone2, emailAddress, dateOfBirth);
        this.agentID = agentID;
        this.districtName = districtName;
        this.numberOfEnrolled = enrolled;
    }

    public String getAgentID() {
        return this.agentID;
    }


    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    
    public String getDistrictName() {
        return this.districtName;
    }


    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    public int getNumberOfEnrolled() {
        return this.numberOfEnrolled;
    }


    public void setNumberOfEnrolled(int numberOfEnrolled) {
        this.numberOfEnrolled = numberOfEnrolled;
    }

}