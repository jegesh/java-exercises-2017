package il.co.electriccollege.restaurant.yossi.hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name="menu")
public class Menu {

    private int id;
    private String name;
    private String time;

    /*public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }*/

    public Menu() {
    }

    public Menu(String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="hours_available")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
