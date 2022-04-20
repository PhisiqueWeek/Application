package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "factory")
@Entity
public class Factory {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "factory_id", nullable = false, length = 40)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "employer_amount", nullable = false)
    private Integer employerAmount;

    @Convert(disableConversion = true)
    @Column(name = "last_shipment", nullable = false)
    private Instant lastShipment;

    public Instant getLastShipment() {
        return lastShipment;
    }

    public void setLastShipment(Instant lastShipment) {
        this.lastShipment = lastShipment;
    }

    public Integer getEmployerAmount() {
        return employerAmount;
    }

    public void setEmployerAmount(Integer employerAmount) {
        this.employerAmount = employerAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}