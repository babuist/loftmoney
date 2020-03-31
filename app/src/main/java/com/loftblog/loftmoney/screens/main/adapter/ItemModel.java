package com.loftblog.loftmoney.screens.main.adapter;

import java.io.Serializable;

public class ItemModel implements Serializable {

    public static String KEY_NAME = ItemModel.class.getName();

    private String name, value;

    public ItemModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
