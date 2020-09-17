package com.main.model;

import java.util.ArrayList;

public class SizeColorModel {
    private String id;
    private String color_name;
    private String color_description;

    private ArrayList<SizeModel> sizeModel = null;

    public SizeColorModel() {
    }

    public SizeColorModel(String id, String color_name, String color_description, ArrayList<SizeModel> sizeModel) {
        this.id = id;
        this.color_name = color_name;
        this.color_description = color_description;
        this.sizeModel = sizeModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<SizeModel> getSizeModel() {
        return sizeModel;
    }

    public void setSizeModel(ArrayList<SizeModel> sizeModel) {
        this.sizeModel = sizeModel;
    }
}
