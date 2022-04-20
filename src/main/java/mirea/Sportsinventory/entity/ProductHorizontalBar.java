package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "product_horizontal_bar")
@Entity
public class ProductHorizontalBar {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "horizontal_bar_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Catalogue product;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "diameter_mm", nullable = false, precision = 4, scale = 4)
    private double diameterMm;

    @Column(name = "width_cm", nullable = false, precision = 4, scale = 4)
    private double widthCm;

    public double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(double widthCm) {
        this.widthCm = widthCm;
    }

    public double getDiameterMm() {
        return diameterMm;
    }

    public void setDiameterMm(double diameterMm) {
        this.diameterMm = diameterMm;
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