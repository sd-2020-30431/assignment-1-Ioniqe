package model;

import javax.persistence.*;

@Entity
@Table(name = "list")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    public List(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public List() {
    }

    public List(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
