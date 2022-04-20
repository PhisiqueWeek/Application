package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "product_monkey_bars")
@Entity
public class ProductMonkeyBar {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_monkey_bars_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "height_cm", nullable = false, precision = 4, scale = 4)
    private double heightCm;

    @Column(name = "width_cm", nullable = false, precision = 4, scale = 4)
    private double widthCm;

    public double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(double widthCm) {
        this.widthCm = widthCm;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
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