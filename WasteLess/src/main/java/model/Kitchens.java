package model;

import javax.persistence.*;

@Entity
@Table(name = "kitchens")
public class Kitchens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Kitchens(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kitchens() {
    }

    public Kitchens(String name) {
        this.name = name;
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
        return "Kitchens{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
