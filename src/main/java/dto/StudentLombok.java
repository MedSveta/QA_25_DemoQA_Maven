package dto;

import enums.Gender;
import enums.Hobbies;
import lombok.*;

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
    private String  currentAddress;
    private String state;
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentLombok)) return false;

        StudentLombok that = (StudentLombok) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (gender != that.gender) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (subjects != null ? !subjects.equals(that.subjects) : that.subjects != null) return false;
        if (currentAddress != null ? !currentAddress.equals(that.currentAddress) : that.currentAddress != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return city != null ? city.equals(that.city) : that.city == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        result = 31 * result + (currentAddress != null ? currentAddress.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
