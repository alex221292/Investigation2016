package com.altr.core.Model;

import javax.persistence.*;

@Entity
@Table(name = "user_boxes")
public class BoxesTable implements java.io.Serializable {
    @Id
    @Column(name = "box_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserTable user;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductTable product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    public ProductTable getProduct() {
        return product;
    }

    public void setProduct(ProductTable product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "BoxesTable{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
