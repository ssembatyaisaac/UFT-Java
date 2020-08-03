package UFT.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import java.util.*;

/**
 * 
 */
@Entity
public class Donor {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long donorID;
    private String donorName;
    private String dateOfDonation;
    private int amountDonated;


    public long getDonorID() {
        return this.donorID;
    }

    
    public void setDonorID(long donorID) {
        this.donorID = donorID;
    }


    public String getDonorName() {
        return this.donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDateOfDonation() {
        return this.dateOfDonation;
    }

    public void setDateOfDonation(String dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }

    public int getAmountDonated() {
        return this.amountDonated;
    }
    
    public void setAmountDonated(int amountDonated) {
        this.amountDonated = amountDonated;
    }

}