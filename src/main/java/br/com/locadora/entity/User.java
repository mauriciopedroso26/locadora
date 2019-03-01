package br.com.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TA_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1729970853360921152L;

    @Id
    @GeneratedValue
    @Column(name = "ID_USER", nullable = false)
    private Long idUser;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
