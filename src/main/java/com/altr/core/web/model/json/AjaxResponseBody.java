package com.altr.core.web.model.json;


import com.altr.core.web.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class AjaxResponseBody {
    @JsonView(Views.Public.class)
    String msg;

    @JsonView(Views.Public.class)
    String code;

    @JsonView(Views.Public.class)
    ShoppingCart results;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ShoppingCart getResults() {
        return results;
    }

    public void setResults(ShoppingCart results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AjaxResponseBody{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", result=" + results +
                '}';
    }
}
