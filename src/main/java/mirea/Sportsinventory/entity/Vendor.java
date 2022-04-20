package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "vendor")
@Entity
public class Vendor {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "vendor_id", nullable = false, length = 40)
    private String id;

    @Column(name = "vendor_name", nullable = false, length = 50)
    private String vendorName;

    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}