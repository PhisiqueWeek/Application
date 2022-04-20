package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "product_mat")
@Entity
public class ProductMat {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_mat_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "square_cm2", nullable = false, precision = 4, scale = 4)
    private double squareCm2;

    public double getSquareCm2() {
        return squareCm2;
    }

    public void setSquareCm2(double squareCm2) {
        this.squareCm2 = squareCm2;
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