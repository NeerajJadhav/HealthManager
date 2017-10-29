package com.fitbit.sampleandroidoauth2.Home;
import android.content.Context;
import android.util.Base64;
/**
 * Created by niraj on 04-08-17.
 */

public class HMUserClass{
    private int userID = 0;
    private String userEmail = "";
    private String userPassword = "";
    private static String userGender = "";
    private static String userTarget = "";
    private static int userWeight = 0;
    private static int userHeight = 0;
    private static int userAge = 0;
    private static int userDesiredWeight = 0;
    private static int noOfWeeks = 0;
    private double goal=0;

    /** Constructor for HMUser Class
     *
     * @param userID Integer user ID
     * @param userEmail String user email
     * @param userPassword String user password
     * @param userWeight String user height
     * @param userHeight String user target
     * @param userTarget String user age
     * @param userAge String user gender
     * @param userGender String user gender
     * @param userDesiredWeight Integer user desired weight
     * @param noOfWeeks Integer no of weeks
     * @param goal Double goal
     */
    public HMUserClass(int userID, String userEmail, String userPassword, int userWeight, int userHeight,String userTarget,
                       int userAge, String userGender,int userDesiredWeight,int noOfWeeks,double goal) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userWeight = userWeight;
        this.userHeight = userHeight;
        this.userTarget=userTarget;
        this.userAge = userAge;
        this.userDesiredWeight=userDesiredWeight;
        this.noOfWeeks=noOfWeeks;
        this.goal=goal;
    }

    /**
     * Returns current user's id
     *
     * @return Integer user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets id of a user
     * @param userID Integer user id
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /** Returns current user's password
     *
     * @return String user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Returns get user email
     * @return String user email id
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email id for current user object
     * @param userEmail String user email id
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Returns current user's desired weight
     * @return Integer returns user weight
     */
    public static int getuserDesiredWeight() {
        return userDesiredWeight;
    }

    /**
     * Sets current user's desired weight
     * @param userDesiredWeight Integer user desired weight
     */
    public static void setuserDesiredWeight(int userDesiredWeight) {
        HMUserClass.userDesiredWeight = userDesiredWeight;
    }

    /**
     * Returns User gender
     *
     * @return String user gender
     */
    public static String getUserGender() {
        return userGender;
    }

    /**
     * Returns user target gain lose or maintain
     *
     * @return String returns user target string
     */
    public static String getUserTarget() {
        return userTarget;
    }

    public static void setUserTarget(String userTarger) {
        HMUserClass.userTarget = userTarget;
    }



    /**
     * Sets user gender
     * @param userGender String gender
     */
    public static void setUserGender(String userGender) {
        HMUserClass.userGender = userGender;
    }

    /**
     * Returns user's no of Weeks
     * @return Integer no of weeks
     */
    public static int getnoOfWeeks() {
        return noOfWeeks;
    }

    /**
     *
     * @param noOfWeeks
     */
    public static void setnoOfWeeks(int noOfWeeks) {
        HMUserClass.noOfWeeks = noOfWeeks;
    }

    /**
     *
     * @return
     */
    public HMUserClass getLoggedInUser(){
        return this;
    }

    /**
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = this.getEncryptedPassword(userPassword);
    }

    /**
     *
     * @return
     */
    public int getUserWeight() {
        return userWeight;
    }

    /**
     *
     * @param userWeight
     */
    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    /**
     *
     * @return
     */
    public int getUserHeight() {
        return userHeight;
    }

    /**
     *
     * @param userHeight
     */
    public void setUserHeight(int userHeight) {
        this.userHeight = userHeight;
    }

    /**
     *
     * @return
     */
    public int getUserAge() {
        return userAge;
    }

    /**
     *
     * @param userAge
     */
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    /**
     *
     * @return
     */
    public int getBMR(){

        return 0;
    }

    public double getGoal(){
        return goal;
    }

    /**
     * Returns base64 encoded password
     *
     * @param password String password
     * @return String returns encrypted password
     */
    public static String getEncryptedPassword(String password){
        return Base64.encodeToString(password.getBytes(),Base64.DEFAULT);
    }

    public static String getDecryptedPassword(String password){
        return String.valueOf(Base64.decode(password,Base64.DEFAULT));
    }

    /**
     * Checks if current user has the same password as string in params
     *
     * @param password String password string
     * @return Boolean true if matched else false
     */
    public boolean checkPassword(String password){
       //String p1=this.getEncryptedPassword(password);
        //String p2=this.getUserPassword();
        if(this.getEncryptedPassword(password).equals(this.userPassword)) return true;
        return false;
    }

    /**
     * Returns HMUserClass by searching the Userid in user table
     * @param ID Integer user id to search
     * @param context Context of current activity
     * @return HMUser class object
     */
    public static HMUserClass getUserFromID(int ID,Context context){
        HMDatabaseHandler dbInstance = new HMDatabaseHandler(context);
        HMUserClass User = dbInstance.getUserFromID(ID);
        return User;
    }

    /**
     * Returns HMUserClass by searching the email in user table
     *
     * @param email String user email id
     * @param context Context current activity context
     * @return HMUserClass object.
     */
    public static HMUserClass getUserFromEmail(String email,Context context){
        HMDatabaseHandler dbInstance = new HMDatabaseHandler(context);
        HMUserClass User = dbInstance.getUserFromEmail(email);
        return User;
    }

}
