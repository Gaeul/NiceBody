package com.example.kobot.myposition;

/**
 * Created by kobot on 2017-09-25.
 */

public class UserInformation {
    private int userNumber;
    private String userName;
    private int userHeight;
    private int userWeight;

    public UserInformation(int userNumber, String userName, int userHeight, int userWeight) {
        super();
        this.userNumber = userNumber;
        this.userName = userName;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(int userHeight) {
        this.userHeight = userHeight;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("UserNumber : " + userNumber);
        sb.append(" , Name : " + userName);
        sb.append(" , Height : " + userHeight);
        sb.append(" , Weight : " + userWeight);
        return sb.toString();
    }
}
