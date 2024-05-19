package dto;

import enums.Gender;
import enums.Hobbies;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder

public class StudentLombok {
    private String name;
    private String lastName;
    private String email;

    private Gender gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private List<Hobbies> hobbies;
}
