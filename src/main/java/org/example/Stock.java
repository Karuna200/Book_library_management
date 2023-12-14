package org.example;
public interface Stock {

    public void addBook(Book b);
    public void removeBook(Book b);
    public void findBook(String Name);

    public void findBook(float cost);

    public void findBook(float low, float high);

    public void findCheapestBook();

    public void findCostlyBook();

}

