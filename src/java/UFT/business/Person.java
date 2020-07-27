package UFT.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    private String firstName;
    private String lastName;
    private String gender;
    private String telephone1;
    private String telephone2;
    private String emailAddress;
    private String dateOfBirth;

    public Person() {
        firstName = "None";
        lastName = "None";
        gender = "None";
        telephone1 = "None";
        telephone2 = "None";
        emailAddress = "None";
        dateOfBirth = "None";
    }

    public Person(String fName, String lName, String gender, String telephone1, String telephone2,
    String emailAddress, String dateOfBirth) {
        this.firstName = fName;
        this.lastName = lName;
        this.gender = gender;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(long personid) {
        this.personId = personid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone1() {
        return this.telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return this.telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}