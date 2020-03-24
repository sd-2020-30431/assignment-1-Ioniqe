package model;

import javax.persistence.*;

@Entity
@Table(name = "charities")
public class Charities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Charities(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Charities(String name) {
        this.name = name;
    }

    public Charities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Charities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
