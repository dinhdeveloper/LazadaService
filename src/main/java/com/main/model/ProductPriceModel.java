package com.main.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductPriceModel implements Serializable {
    private String id;
    private String product_name;
    private String quantity_export;

    ArrayList<PriceFeesModel> price = null;

    public ProductPriceModel() {
    }

    public ProductPriceModel(String id, String product_name, String quantity_export, ArrayList<PriceFeesModel> price) {
        this.id = id;
        this.product_name = product_name;
        this.quantity_export = quantity_export;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity_export() {
        return quantity_export;
    }

    public void setQuantity_export(String quantity_export) {
        this.quantity_export = quantity_export;
    }

    public ArrayList<PriceFeesModel> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<PriceFeesModel> price) {
        this.price = price;
    }
}
