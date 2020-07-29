package UFT.business;

import java.util.ArrayList;
import java.util.List;

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
    private District agentDistrict;
    private List<Member> enrolledMembers;
    
    
    public Agent() {
        super();
        this.agentID = "None";
        this.agentDistrict = new District();
        this.enrolledMembers = new ArrayList<Member>();

    }

    public Agent (String fName, String lName, String gender, String telephone1, String telephone2,
    String emailAddress, String dateOfBirth, String agentID, District district, List<Member> enrolled) {
        super(fName, lName, gender, telephone1, telephone2, emailAddress, dateOfBirth);
        this.agentID = agentID;
        this.agentDistrict = district;
        this.enrolledMembers = enrolled;
    }

    public String getAgentID() {
        return this.agentID;
    }


    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public District getAgentDistrict() {
        return this.agentDistrict;
    }

    public void setAgentDistrict(District agentDistrict) {
        this.agentDistrict = agentDistrict;
    }

    public List<Member> getEnrolledMembers() {
        return this.enrolledMembers;
    }

    public void setEnrolledMembers(List<Member> enrolledMembers) {
        this.enrolledMembers = enrolledMembers;
    }
    

}