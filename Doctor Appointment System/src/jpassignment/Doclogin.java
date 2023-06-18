package jpassignment;

public class Doclogin {
    private String username;
    private String password;
    public Doclogin(String a, String b){
        username = a;
        password = b;
    }
   
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
