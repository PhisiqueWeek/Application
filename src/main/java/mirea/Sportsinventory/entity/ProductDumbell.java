package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "product_dumbell")
@Entity
public class ProductDumbell {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "dumbell_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "weight_kg", nullable = false, precision = 4, scale = 4)
    private double weightKg;

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
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