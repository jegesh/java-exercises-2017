import javax.persistence.*;

@Entity
@Table (name="dish")
public class Dish {
    String name;
    int id;

    //need to copy jar? sql connector
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
