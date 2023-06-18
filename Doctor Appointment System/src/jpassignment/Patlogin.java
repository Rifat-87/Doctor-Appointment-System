package jpassignment;

public class Patlogin {

    private String username;
    private String password;
    private int phone;

    public Patlogin(String a, String b, int c) {
        username = a;
        password = b;
        phone = c;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
