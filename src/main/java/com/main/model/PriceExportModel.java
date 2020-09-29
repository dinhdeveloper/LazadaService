package com.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PriceExport")
public class PriceExportModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @Column(name = "price_print")
    private String price_print;
    @Column(name = "price_ship")
    private String price_ship;
    @Column(name = "price_sell")
    private String price_sell;
    @Column(name = "price_fees")
    private String price_fees;
    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice_print() {
        return price_print;
    }

    public void setPrice_print(String price_print) {
        this.price_print = price_print;
    }

    public String getPrice_ship() {
        return price_ship;
    }

    public void setPrice_ship(String price_ship) {
        this.price_ship = price_ship;
    }

    public String getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(String price_sell) {
        this.price_sell = price_sell;
    }

    public String getPrice_fees() {
        return price_fees;
    }

    public void setPrice_fees(String price_fees) {
        this.price_fees = price_fees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
