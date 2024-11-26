package example.validateform.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message = "First name is required")
    @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters")
    private String lastName;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Min(value = 18, message = "Age must be 18 or older")
    private int age;

    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    private String email;


    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public @NotEmpty(message = "First name is required") @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty(message = "First name is required") @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty(message = "Last name is required") @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "Last name is required") @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters") String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Min(value = 18, message = "Age must be 18 or older")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "Age must be 18 or older") int age) {
        this.age = age;
    }

    public @Email(message = "Invalid email format") @NotEmpty(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email format") @NotEmpty(message = "Email is required") String email) {
        this.email = email;
    }
}
