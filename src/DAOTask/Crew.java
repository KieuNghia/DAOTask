package DAOTask;

import java.util.Date;

public class Crew extends Entity{

    private String lastName;
    private String firstName;
    private Date dateOfBirth;

    public Crew(int id, String lastName, String firstName, Date dateOfBirth) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return  "Crew: " +
                " lastName ='" + lastName + '\'' +
                " firstName ='" + firstName + '\'' +
                " dateOfBirth =" + dateOfBirth +
                "\n";
    }
}
