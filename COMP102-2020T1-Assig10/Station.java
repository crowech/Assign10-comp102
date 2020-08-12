// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2020T1, Assignment 10
 * Name:
 * Username:
 * ID:
 */

/**
 * Station
 * Information about an individual station:
 * - The name
 * - The fare zone it is in (1 - 14)
 * The constructor takes the name and the zone;
 */

public class Station {
    private String name;
    private int zone;

    public Station(String n, int z){
        this.name = n;
        this.zone = z;
    }

    public String getName(){
        return this.name;
    }

    public int getZone(){
        return this.zone;
    }

    public String toString(){
        return (this.name + " at zone: " + this.zone);
    }
}

