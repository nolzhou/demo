package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-13 15:35:28
 */
@Entity
@Table(name = "admin", schema = "androiddev")
public class AdminEntity {
    private int id;
    private String adminname;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "adminname")
    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return id == that.id &&
                Objects.equals(adminname, that.adminname) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminname, password);
    }
}
