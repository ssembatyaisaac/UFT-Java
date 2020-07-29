package UFT.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


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
    private Member recommendingMember;
    private Agent enrollerAgent;
    private District district;
    private List<Member> introducedMembers;

    public Member() {
        super();
        this.memberID = "None";
        this.recommendingMember = new Member();
        this.enrollerAgent = new Agent();
        this.district = new District();
        this.introducedMembers = new ArrayList<Member>();
    }

    public Member(String fName, String lName, String gender, String telephone1,
    String telephone2, String emailAddress, String dateOfBirth,
    String memberID, Member recommender, Agent enrollerAgent, District district, List<Member> introductions) {
        super(fName, lName, gender, telephone1, telephone2, emailAddress, dateOfBirth);
        this.memberID = memberID;
        this.recommendingMember = recommender;
        this.enrollerAgent =  enrollerAgent;
        this.district = district;
        this.introducedMembers = introductions;
    }
   
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