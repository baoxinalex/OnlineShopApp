package com.company.user;


public class Admin extends User{
    private String password;

    public Admin(String firstName, String lastName, String title, String email, String password) {
        super(firstName, lastName, title, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return getTitle()+"."+this.getFirstName()+" "+getLastName()+"\t\t"+this.getEmail()+"\t\t"+this.getPassword()+"\n";
    }
}
