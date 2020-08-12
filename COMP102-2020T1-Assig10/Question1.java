// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2020T1, Assignment 10
 * Name: Chloe Crowe
 * Username: Crowechlo
 * ID: 300539785
 */

import ecs100.*;

/**
 * Question 1. Writing programs with if.    
 */
public class Question1{

    /**
     * This method should calculate and return the infringement fine.
     * It has two integer parameters: 
     * - the speed limit of a road and,
     * - the speed of a car, 
     *
     * How far over the speed limit   Infringement fine
     * 10km/h or less                   $30
     * 11-15km/h                        $80
     * 16km/h or more                   $150  
     */
    public int calculateFine(int speedLimit, int speed) {
        //Fine is 0
        int fine = 0;
        //If the speed is greater than the speed limit
        if (speed > speedLimit){
            //Calculates the difference in speed
            int speedDifference = speed - speedLimit;
            UI.println("You are over the speed Limit!");
            if((speedDifference >0) && (speedDifference <= 10)){
                //If the difference is speed is greater than 0 and less than 10.
                fine = 30;
            }
            else if ((speedDifference >=11) && (speedDifference <= 15)){
                //If the speed difference is 11 or greater and under 16
                fine = 80;
            }
            else if (speedDifference >=16){
                //If the speed difference is bigger than 16.
                fine = 150;
            }
        }
        return fine;
    }

    //----------------------------------------------------------------------
    /*
     * This method should return the hour that an alarm should be set
     * It has three parameters:
     * - day: integer, 1-5 for Mon-Fri, 6-7 for Sat-Sun;
     * - holiday: boolean
     * - sick: boolean
     *
     * return the alarm time as an integer: 7, 9, 10, 11, or -1 (none)
     *
     * Your alarm should normally be set to 7am during weekdays and 9am
     *    during weekends
     * But if it is a holiday, you sleep in and the alarm should be set
     *    to 10am on weekdays and 11am on weekends
     * However, if you are sick, you do not set the alarm at all, whatever
     *    day it is, and the method should return -1
     */
    public int setAlarm(int day, boolean holiday, boolean sick) {
        //Sets the alarm to 0
        int alarm = 0;
        //Sets the day to a weekday
        String weekdayOrEnd = "weekday";

        //If the day is 1 to 5 then it sets as a weekday
        if((day <=5)&& (day>0)){
            weekdayOrEnd = "weekday";
        }
        //If a weekend sets to weekend
        else if (day >=6){
            weekdayOrEnd = "weekend";
        }

        // If its a hoilday and a weekday
        if((holiday) && (weekdayOrEnd.equals("weekday"))){
            alarm = 10;
        }
        //Not a hoilday and a weekday
        else if((!holiday) && (weekdayOrEnd.equals("weekday"))){
            alarm = 7;
        }
        //hoilday and a weekend
        else if((holiday) && (weekdayOrEnd.equals("weekend"))){
            alarm = 11;
        }
        //Not a hoilday and a weekend
        else if((!holiday) && (weekdayOrEnd.equals("weekend"))){
            alarm = 9;
        }

        //If sick then the alarm returns -1.
        if (sick){
            alarm = -1;
        }

        return alarm;
    }

    /******************************************************
     * YOU CAN USE THE METHODS BELOW THIS LINE            *
     * TO TEST YOUR PROGRAM                               *
     ******************************************************/
    public void testFine(){
        int speedLimit = UI.askInt("Limit is:");
        int speed = UI.askInt("Speed is: ");
        int fine = this.calculateFine(speedLimit, speed);
        UI.printf("calculateFine(%d, %d) is $%d\n",
                speedLimit, speed, fine);
    }

    public void testAlarm(){
        int day = UI.askInt("What day is it:");
        boolean holiday = UI.askBoolean("Is it a holiday?");
        boolean sick = UI.askBoolean("Are you sick?");
        int alarm = this.setAlarm(day, holiday, sick);
        UI.printf("setAlarm(%d, %b, %b) is %d\n", day, holiday, sick, alarm);
    }

    public void setupGUI() {
        UI.initialise();
        UI.addButton("Test Fine", this::testFine);
        UI.addButton("Test Alarm", this::testAlarm);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(500,500);
        UI.setDivider(1.0);
    }

    public static void main(String[] args) {
        new Question1().setupGUI();
    }
}

