package org.example;

public class Login {
    private  String email;
    private  String password;
    public  void setEmail(String email) {
        this.email = email;

    }
    public  void setPassword(String password) {
        this.password = password;
    }
    public  String Loginrequest() {
        return "{\n" +
                "    \"userEmail\": \""+this.email+"\",\n" +
                "    \"userPassword\": \""+this.password+"\"\n" +
                "}\n";
    }
}
