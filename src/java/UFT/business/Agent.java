package UFT.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * 
 */
@Entity
public class Agent extends Person {


    private String agentID;
    
    @ManyToOne
    private District agentDistrict; 
    
    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private List<Member> enrolledMembers;

    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private List<Agent> agentHead;


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

    public List<Agent> getAgentHead() {
        return this.agentHead;
    }

    public void setAgentHead(List<Agent> agentHead) {
        this.agentHead = agentHead;
    }


}