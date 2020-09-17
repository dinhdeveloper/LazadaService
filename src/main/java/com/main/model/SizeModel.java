package com.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Size")
public class SizeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @Column(name = "id_code")
    private String id_code;
    @Column(name = "color_id")
    private String color_id;
    @Column(name = "size_name")
    private String  size_name;
    @Column(name = "size_description")
    private String size_description;
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

    public String getSize_name() {
        return size_name;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    public String getSize_description() {
        return size_description;
    }

    public void setSize_description(String size_description) {
        this.size_description = size_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
