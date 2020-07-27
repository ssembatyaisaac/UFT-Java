package UFT.business;


//import java.util.*;

/**
 * 
 */
public class AgentHead extends Agent {

    /**
     *
     */
    private static final long serialVersionUID = 9214872316309942004L;
    public String agentHeadID;
    
    public AgentHead() {
        this.agentHeadID = "None";
    }

    
    public AgentHead(String agentHeadID){
        this.agentHeadID = agentHeadID;
    }

    
    public String getAgentHeadID() {
        return this.agentHeadID;
    }


    public void setAgentHeadID(String agentHeadID) {
        this.agentHeadID = agentHeadID;
    }

}