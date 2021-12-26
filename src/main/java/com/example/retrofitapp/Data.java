package com.example.retrofitapp;

public class Data {
    String UserName , UserMail , Password , NumberTel ;

    public Data(String userName, String userMail , String password , String numberTel) {
        UserName = userName;
        UserMail = userMail;
        Password = password;
        NumberTel = numberTel;
    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNumberTel() {
        return NumberTel;
    }

    public void setNumberTel(String numberTel) {
        NumberTel = numberTel;
    }
}
