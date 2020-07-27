package UFT.business;


//import java.util.*;

/**
 * 
 */
public class Donor extends Person {

    /**
     *
     */
    private static final long serialVersionUID = 402107230787812267L;
    public String donorID;
    public int amountDonated;

    
    public Donor() {
        this.donorID = "None";
        this.amountDonated = 0;
    }

    
    public String getDonorID() {
        return this.donorID;
    }

    
    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    
    public int getAmountDonated() {
        return this.amountDonated;
    }

    
    public void setAmountDonated(int amountDonated) {
        this.amountDonated = amountDonated;
    }

}