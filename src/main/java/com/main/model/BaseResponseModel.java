package com.main.model;

import com.sun.istack.Nullable;

import java.io.Serializable;
import java.util.List;

public class BaseResponseModel<T> implements Serializable {

    /*"total": "0",
    "total_page": "0",
    "limit": "20",
    "page": "1",
    "success": "true",*/


    @Nullable
    private String total = "0";

    @Nullable
    private String total_page = "0";

//    @Nullable
//    private String limit = "0";

    @Nullable
    private String page = "0";

    @Nullable
    private String success;

    @Nullable
    private String message = "";


    @Nullable
    private List<T> data;

    public BaseResponseModel() {
    }
    @Nullable
    public String getSuccess() {
        return success;
    }
    @Nullable
    public void setSuccess(String success) {
        this.success = success;
    }
    @Nullable
    public String getMessage() {
        return message;
    }
    @Nullable
    public void setMessage(String message) {
        this.message = message;
    }
    @Nullable
    public String getTotal_page() {
        return total_page;
    }
    @Nullable
    public void setTotal_page(String total_page) {
        this.total_page = total_page;
    }
    @Nullable
    public String getTotal() {
        return total;
    }
    @Nullable
    public void setTotal(String total) {
        this.total = total;
    }
    //    @Nullable
//    public String getLimit() {
//        return limit;
//    }
//    @Nullable
//    public void setLimit(String limit) {
//        this.limit = limit;
//    }
    @Nullable
    public String getPage() {
        return page;
    }
    @Nullable
    public void setPage(String page) {
        this.page = page;
    }
    @Nullable
    public List<T> getData() {
        return data;
    }
    @Nullable
    public void setData(List<T> data) {
        this.data = data;
    }
}
