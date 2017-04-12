package Rescue.web;

/**
 * Created by maciej on 12.04.17.
 */
public class Register {
    private String name;
    private String surname;
    private String username;
    private String pesel;
    private String password;

    public Register(){}

    public Register(String name, String surname, String username, String pesel, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.pesel = pesel;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
