package il.co.electriccollege.realestate.entity;

import javax.persistence.*;

/**
 * Created by yaakov on 9/18/17.
 */
@Entity
@Table(name = "property")
public class Property {
    private long id;
    private String name;
    private String address;
    private int numOfRooms;
    private int floor;

    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "num_of_rooms")
    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Column
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Column(name = "has_yard")
    public int getYard() {
        return isYard?1:0;
    }

    public void setYard(int yard) {
        isYard = yard == 1;
    }

    private boolean isYard;
}
