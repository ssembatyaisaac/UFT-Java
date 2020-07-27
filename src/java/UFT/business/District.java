package UFT.business;


//import java.util.*;

/**
 * 
 */
public class District {

    
    public String districtID;
    public String districtName;
    public int numberOfmembers;
    public int numberOfagents;
    
    
    public District() {
        this.districtID = "None";
        this.districtName = "No District";
        this.numberOfagents = 0;
        this.numberOfmembers = 0;
    }
    
    
    public District(String districtID, String districtName){
        this.districtID = districtID;
        this.districtName = districtName;
        this.numberOfagents = 0;
        this.numberOfmembers = 0;
    }

    public String getDistrictID() {
        return this.districtID;
    }

    
    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    
    public String getDistrictName() {
        return this.districtName;
    }

    
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

   
    public int getNumberOfmembers() {
        return this.numberOfmembers;
    }

    
    public void setNumberOfmembers(int numberOfMembers) {
        this.numberOfmembers = numberOfMembers;
    }

    
    public int getNumberOfagents() {
        return this.numberOfagents;
    }

    
    public void setNumberOfagents(int numberOfagents) {
        this.numberOfagents = numberOfagents;
    }

}