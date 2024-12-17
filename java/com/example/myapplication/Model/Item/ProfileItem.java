package com.example.myapplication.Model.Item;

public class ProfileItem {
    private String title;
    private String value;

    public ProfileItem(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
