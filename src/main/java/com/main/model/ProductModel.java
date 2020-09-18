package com.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "Product")
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @Column(name = "id_code")
    private String id_code;
    @Column(name = "color_id")
    private String color_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_image")
    private String product_image;
    @Column(name = "price_import")
    private String price_import;
    @Column(name = "price_export")
    private String price_export;
    @Column(name = "quantity_import")
    private String quantity_import;
    @Column(name = "quantity_export")
    private String quantity_export;
    @Column(name = "safe_stock")
    private String safe_stock;
    @Column(name = "date_create")
    private String date_create;
    @Column(name = "date_export")
    private String date_export;
    @Column(name = "status")
    private String status;
    @Column(name = "total_import")
    private String total_import;
    @Column(name = "total_export")
    private String total_export;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getPrice_import() {
        return price_import;
    }

    public void setPrice_import(String price_import) {
        this.price_import = price_import;
    }

    public String getPrice_export() {
        return price_export;
    }

    public void setPrice_export(String price_export) {
        this.price_export = price_export;
    }

    public String getQuantity_import() {
        return quantity_import;
    }

    public void setQuantity_import(String quantity_import) {
        this.quantity_import = quantity_import;
    }

    public String getQuantity_export() {
        return quantity_export;
    }

    public void setQuantity_export(String quantity_export) {
        this.quantity_export = quantity_export;
    }

    public String getSafe_stock() {
        return safe_stock;
    }

    public void setSafe_stock(String safe_stock) {
        this.safe_stock = safe_stock;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_import() {
        return total_import;
    }

    public void setTotal_import(String total_import) {
        this.total_import = total_import;
    }

    public String getTotal_export() {
        return total_export;
    }

    public void setTotal_export(String total_export) {
        this.total_export = total_export;
    }

    public String getDate_export() {
        return date_export;
    }

    public void setDate_export(String date_export) {
        this.date_export = date_export;
    }
}
