package com.altr.core.Model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderTable implements java.io.Serializable {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "box_id")
    private BoxesTable box;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BoxesTable getBox() {
        return box;
    }

    public void setBox(BoxesTable box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "id=" + id +
                ", box=" + box +
                '}';
    }
}
