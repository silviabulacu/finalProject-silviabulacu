package ObjectModels;

class RegisterModel
{
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;


    public RegisterModel(String firstname, String lastname, String email, String phone, String password, String confirmPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }
}