package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Book {


    String name;
    String authorName;
    float price;
    String category;

    BufferedReader buff;
    InputStreamReader isr;

    public Book(String name, String authorName, float price, String category) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.category = category;
    }

    public Book(BufferedReader buff, InputStreamReader isr){
        this.buff = buff;
        this.isr = isr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getauthorName() {
        return authorName;
    }

    public void setauthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
