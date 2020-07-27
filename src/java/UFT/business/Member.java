package UFT.business;

import javax.persistence.Entity;

//import java.util.*;

/**
 * 
 * @author ducky
 */
@Entity
public class Member extends Person {

    /**
     *
     */
    private String memberID;
    private String recommenderID;
    private String enrollerAgentID;
    private String districtName;
    private int numberOfIntroductions;

    public Member() {
        super();
        this.memberID = "None";
        this.recommenderID = "None";
        this.enrollerAgentID = "None";
        this.districtName = "No District";
        this.numberOfIntroductions = 0;
    }

    public Member(String fName, String lName, String gender, String telephone1,
    String telephone2, String emailAddress, String dateOfBirth,
    String memberID, String recommenderID, String enrollerAgentID, String districtName) {
        super(fName, lName, gender, telephone1, telephone2, emailAddress, dateOfBirth);
        this.memberID = memberID;
        this.recommenderID = recommenderID;
        this.enrollerAgentID =  enrollerAgentID;
        this.districtName = districtName;
        this.numberOfIntroductions = 0;
    }

    
    public String getMemberID() {
        return this.memberID;
    }

    
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    
    public String getRecommenderID() {
        return this.recommenderID;
    }

    
    public void setRecommenderID(String recommenderID) {
        this.recommenderID = recommenderID;
    }

    
    public String getEnrollerAgentID() {
        return this.enrollerAgentID;
    }

    
    public void setEnrollerAgentID(String enrollerAgentID) {
        this.enrollerAgentID = enrollerAgentID;
    }

    
    public String getDistrictName() {
        return this.districtName;
    }

    
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    
    public int getNumberOfIntroductions() {
        return this.numberOfIntroductions;
    }

    
    public void setNumberOfIntroductions(int numberOfIntroductions) {
        this.numberOfIntroductions = numberOfIntroductions;
    }

}