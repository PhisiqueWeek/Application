package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "warehouse")
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "warehouse_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalogue getProduct() {
        return product;
    }

    public void setProduct(Catalogue product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}