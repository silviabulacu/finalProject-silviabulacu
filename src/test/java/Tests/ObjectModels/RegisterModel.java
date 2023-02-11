package Tests.ObjectModels;

public class RegisterModel
{
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
    private String error;
    private String errorType;


//    public RegisterModel(String firstname, String lastname, String email, String phone, String password, String confirmPassword, String error, String errorType) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//        this.error = error;
//        this.errorType = errorType;
//    }

    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }


    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getError() {
        return error;
    }


    public void setError(String error) {
        this.error = error;
    }

    public String getErrorType() {
        return errorType;
    }


    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "firstname:" + this.getFirstname() + "" +
                ",lastname:" + this.getLastname() +
                ",email:" + this.getEmail() +
                ",phone:" + this.getPhone() +
                ",password:" + this.getPassword() +
                ",confirmPassword:" + this.getConfirmPassword() +
                ",error:" + this.getError() +
                ",errorType:" + this.getErrorType() +
                "}";
    }
}