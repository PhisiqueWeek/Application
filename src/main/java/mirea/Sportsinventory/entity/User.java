package mirea.Sportsinventory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id", nullable = false, length = 40)
    private String id;

    @Column(name = "role", nullable = false, length = 40)
    private String role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "login", nullable = false)
    private Credential login;

    public Credential getLogin() {
        return login;
    }

    public void setLogin(Credential login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}