package com.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Color")
public class ColorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @Column(name = "id_code")
    private String id_code;
    @Column(name = "size_id")
    private String  size_id;
    @Column(name = "product_id")
    private String  product_id;
    @Column(name = "color_name")
    private String color_name;
    @Column(name = "color_description")
    private String color_description;
    @Column(name = "status")
    private String status;

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

    public String getSize_id() {
        return size_id;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getColor_description() {
        return color_description;
    }

    public void setColor_description(String color_description) {
        this.color_description = color_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
