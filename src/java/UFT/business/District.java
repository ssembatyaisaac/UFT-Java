package UFT.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class District implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long districtID;
    private String districtName;
    
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Member> members;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Agent> agents;
    

    public long getDistrictID() {
        return this.districtID;
    }
   
    public void setDistrictID(long districtID) {
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