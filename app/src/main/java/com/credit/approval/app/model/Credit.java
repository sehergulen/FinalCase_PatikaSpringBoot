package com.credit.approval.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Getter
@Setter
@Entity
public class Credit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "credit_limit")
    private double creditLimit;
    @Basic
    @Column(name = "approved")
    private boolean approved;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", creditLimit=" + creditLimit +
                ", approved=" + approved +
                '}';
    }
}
