package com.main.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;

public class ListProductModel implements Serializable {
    private String id;
    private String id_code;
    private String color_id;
    private String product_name;
    private String product_image;
    private String price_import;
    private String price_export;
    private String quantity_import;
    private String quantity_export;
    private String safe_stock;
    private String date_create;
    private String status;
    ArrayList<SizeColorModel> sizeColor = null;

    public ListProductModel() {
    }

    public ListProductModel(String id, String id_code, String color_id, String product_name, String product_image, String price_import, String price_export, String quantity_import, String quantity_export, String safe_stock, String date_create, String status, ArrayList<SizeColorModel> sizeColor) {
        this.id = id;
        this.id_code = id_code;
        this.color_id = color_id;
        this.product_name = product_name;
        this.product_image = product_image;
        this.price_import = price_import;
        this.price_export = price_export;
        this.quantity_import = quantity_import;
        this.quantity_export = quantity_export;
        this.safe_stock = safe_stock;
        this.date_create = date_create;
        this.status = status;
        this.sizeColor = sizeColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<SizeColorModel> getSizeColorModel() {
        return sizeColor;
    }

    public void setSizeColorModel(ArrayList<SizeColorModel> sizeColor) {
        this.sizeColor = sizeColor;
    }
}
