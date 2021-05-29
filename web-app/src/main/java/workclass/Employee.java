package workclass;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private int portalId = 0;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    // private Calendar birthCalendar;
    private String jobPosition;
    private String workingAddress;
    private Integer age;
    private List<String> phoneNumbers;
    private byte availibility;

    public Employee(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

}