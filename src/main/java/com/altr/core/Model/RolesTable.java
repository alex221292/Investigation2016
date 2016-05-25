package com.altr.core.Model;

import javax.persistence.*;

/**
 * Created by Алексей on 21.05.2016.
 */
@Entity
@Table(name="roles")
public class RolesTable implements java.io.Serializable {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RolesTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
