package by.byportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long employeeId;
    private int portalId = 0;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    //private String jobPosition;
    //private String workingAddress;
    //private Integer age;
    private Long phoneNumber;
    //private byte availibility;
//

    public Employee() {
        System.out.println();
    }

    public Employee(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Employee(int portalId, String firstName, String lastName, String middleName,
                    Date birthDate, //String jobPosition, String workingAddress, Integer age,
                    long phoneNumber){ //byte availibility) {
        this.portalId = portalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        //this.jobPosition = jobPosition;
        //this.workingAddress = workingAddress;
        //this.age = age;
        this.phoneNumber = phoneNumber;
        //this.availibility = availibility;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getPortalId() {
        return portalId;
    }

    public void setPortalId(int portalId) {
        this.portalId = portalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /*public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getWorkingAddress() {
        return workingAddress;
    }

    public void setWorkingAddress(String workingAddress) {
        this.workingAddress = workingAddress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }*/

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*public byte getAvailibility() {
        return availibility;
    }

    public void setAvailibility(byte availibility) {
        this.availibility = availibility;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return portalId == employee.portalId && availibility == employee.availibility && Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(jobPosition, employee.jobPosition) && Objects.equals(workingAddress, employee.workingAddress) && Objects.equals(age, employee.age) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, portalId, firstName, lastName, middleName, birthDate, jobPosition, workingAddress, age, phoneNumber, availibility);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", portalId=" + portalId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", jobPosition='" + jobPosition + '\'' +
                ", workingAddress='" + workingAddress + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", availibility=" + availibility +
                '}';
    }
}

/*
public Date(int year, int month, int date) {
        this(year, month, date, 0, 0, 0);
    }

    /**
     * Allocates a {@code Date} object and initializes it so that
     * it represents the instant at the start of the minute specified by
     * the {@code year}, {@code month}, {@code date},
     * {@code hrs}, and {@code min} arguments, in the local
     * time zone.
     *
     * @param   year    the year minus 1900.
     * @param   month   the month between 0-11.
     * @param   date    the day of the month between 1-31.
     * @param   hrs     the hours between 0-23.
     * @param   min     the minutes between 0-59.
     * @see     java.util.Calendar
     * @deprecated As of JDK version 1.1,
     * replaced by {@code Calendar.set(year + 1900, month, date, hrs, min)}
     * or {@code GregorianCalendar(year + 1900, month, date, hrs, min)}.
     */