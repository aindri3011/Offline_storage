package com.example.sqllite_recycler;

public class UserModel {
    private String Name;
    private String Email;
    private int Img;

    public UserModel(String name, String email, int img) {
        this.Name = name;
        this.Email = email;
        this.Img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
