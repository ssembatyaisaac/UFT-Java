package UFT.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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

    @ManyToOne
    private Member recommendingMember;

    @ManyToOne
    private Agent enrollerAgent;

    @ManyToOne
    private District district;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Member> introducedMembers;
   
    public String getMemberID() {
        return this.memberID;
    }
   
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public Member getRecommendingMember() {
        return this.recommendingMember;
    }

    public void setRecommendingMember(Member recommendingMember) {
        this.recommendingMember = recommendingMember;
    }

    public Agent getEnrollerAgent() {
        return this.enrollerAgent;
    }

    public void setEnrollerAgent(Agent enrollerAgent) {
        this.enrollerAgent = enrollerAgent;
    }

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Member> getIntroducedMembers() {
        return this.introducedMembers;
    }

    public void setIntroducedMembers(List<Member> introducedMembers) {
        this.introducedMembers = introducedMembers;
    }
    
}