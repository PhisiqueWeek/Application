package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "product_ball")
@Entity
public class ProductBall {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_ball_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @Column(name = "volume_cm3", nullable = false, precision = 4, scale = 4)
    private double volumeCm3;

    public double getVolumeCm3() {
        return volumeCm3;
    }

    public void setVolumeCm3(double volumeCm3) {
        this.volumeCm3 = volumeCm3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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