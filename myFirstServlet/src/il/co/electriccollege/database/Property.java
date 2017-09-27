package il.co.electriccollege.database;

import javax.persistence.*;

/**
 * Created by yaakov on 9/18/17.
 */
public class Property {
    private long id;
    private String name;
    private String address;
    private int numOfRooms;
    private int floor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getYard() {
        return isYard?1:0;
    }

    public void setYard(int yard) {
        isYard = yard == 1;
    }

    private boolean isYard;
}
