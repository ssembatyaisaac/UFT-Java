package UFT.business;

import java.util.List;

//import java.util.*;

/**
 * 
 */
public class District {

    
    public String districtID;
    public String districtName;
    public List<Member> members;
    public List<Agent> agents;
    
    
    public District() {
        this.districtID = "None";
        this.districtName = "No District";
        
    }
    
    public District(String districtID, String districtName){
        this.districtID = districtID;
        this.districtName = districtName;
        
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

    public List<Member> getMembers() {
        return this.members;
    }

    public void setMembers(List<Member> members) {
            this.members = members;
    }

    public List<Agent> getAgents() {
            return this.agents;
    }

    public void setAgents(List<Agent> agents) {
            this.agents = agents;
    }

}