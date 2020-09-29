package com.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QuantityImport")
public class QuantityImportModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @Column(name = "id_product")
    private String id_product;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity_import")
    private String quantity_import;
    @Column(name = "total_import")
    private String total_import;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity_import() {
        return quantity_import;
    }

    public void setQuantity_import(String quantity_import) {
        this.quantity_import = quantity_import;
    }

    public String getTotal_import() {
        return total_import;
    }

    public void setTotal_import(String total_import) {
        this.total_import = total_import;
    }
}
