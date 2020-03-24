package model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "calories")
    private int calories;

    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @Column(name = "expirationDate")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(name = "consumptionDate")
    @Temporal(TemporalType.DATE)
    private Date consumptionDate;

    public Item(int id, String name, int quantity, int calories,
                Date purchaseDate, Date expirationDate, Date consumptionDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    public Item() {
    }

    public Item(String name, int quantity, int calories,
                Date purchaseDate, Date expirationDate, Date consumptionDate) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calories=" + calories +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", consumptionDate='" + consumptionDate + '\'' +
                '}';
    }
}
