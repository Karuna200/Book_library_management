package org.example;

import java.util.ArrayList;

public class Library implements Stock{

    static ArrayList<Book> Book_List = new ArrayList<>();

    @Override
    public void findBook(String name) {
        int indx = -1;
        for(int i=0;i<Book_List.size();i++){
            Book b = Book_List.get(i);
            if(b.getName().equalsIgnoreCase(name) || b.getauthorName().equalsIgnoreCase(name)){
                indx = i;
            }
        }
        if(indx==-1){
            System.out.println("Sorry!! Book not found :(");
        }else{
            System.out.println("Your book is found!!!");
        }

    }

    @Override
    public void addBook(Book b) {
        Book_List.add(b);
        System.out.println("Your Book is added!!!");
    }

    @Override
    public void removeBook(Book b) {
        Book_List.remove(b);
        System.out.println("Your Book is removed!!");
    }

    @Override
    public void findBook(float cost) {
        int indx = -1;
        for(int i=0;i<Book_List.size();i++){
            Book book = Book_List.get(i);
            if(book.getPrice() == cost){
                indx = i;
                break;
            }
        }
        if(indx == -1){
            System.out.println("Sorry!! Book not found :(");
        }else{
            System.out.println("Your Book is found for the price: " + cost +" And the book is " + Book_List.get(indx).getName());
        }
    }

    @Override
    public void findBook(float l,float h){
        for(int i=0;i<Book_List.size();i++){
            Book book = Book_List.get(i);
            if(book.getPrice() >=l && book.getPrice()<=h){
                for(float j=l;j<=h;j++){
                    System.out.println("The books found for the given price range are "+ book.getName());
                }
            }else{
                System.out.println("Sorry!! Book not found :(");
            }
        }

    }

    @Override
    public void findCheapestBook(){
        float mini = Float.MAX_VALUE;
        int indx = -1;
        for(int i=0;i<Book_List.size();i++){
            Book b = Book_List.get(i);
            if(mini > b.getPrice()){
                mini = b.getPrice();
                indx = i;
            }
        }
        String name = Book_List.get(indx).getName();
        System.out.println("The Cheapest Book is "+ name);
    }

    @Override
    public void findCostlyBook(){
        float maxi = Float.MIN_VALUE;
        int indx = -1;
        for(int i=0;i<Book_List.size();i++){
            Book b = Book_List.get(i);
            if(maxi < b.getPrice()){
                maxi = b.getPrice();
                indx = i;
            }
        }
        String name = Book_List.get(indx).getName();
        System.out.println("The Cheapest Book is: "+ name);
    }
}

