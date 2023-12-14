package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    BufferedReader buff;
    InputStreamReader isr;

    int select_Operation;

    public Main(){
        if(isr==null) {
            isr = new InputStreamReader(System.in);
        }
        if(buff == null){
            buff = new BufferedReader(isr);
        }

    }
    Stock st = null;
    public static void main(String[] args) {
        Main obj = new Main();
        while (true) {

            System.out.println("Welcome to My Library Management!! ");
            Book b = new Book(obj.buff, obj.isr);
            System.out.println("Enter The Book Details: ");
            try {
                System.out.println("Name: ");
                b.setName(obj.buff.readLine());
                System.out.println("AuthorName: ");
                b.setauthorName(obj.buff.readLine());
                System.out.println("Category: ");
                b.setCategory(obj.buff.readLine());
                System.out.println("Price: ");
                b.setPrice(Float.parseFloat(obj.buff.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                System.out.println("Please Select Your Operation\n1. Add Book\n2. Remove Book\n3. Find By Book Name\n4. Find By Author Name\n5. Find By price");
                try {
                    obj.select_Operation = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                obj.st = new Library();

                switch (obj.select_Operation) {
                    case 1:
                        obj.st.addBook(b);
                        break;
                    case 2:
                        obj.st.removeBook(b);
                        break;
                    case 3:
                        System.out.println("Enter the name of the Book: ");
                        try {
                            String x = obj.buff.readLine();
                            obj.st.findBook(x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4:
                        System.out.println("Enter the name of the Author of the Book: ");
                        try {
                            String x = obj.buff.readLine();
                            obj.st.findBook(x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 5:
                        System.out.println("Enter the price of the book: ");
                        try {
                            float price = Integer.parseInt(obj.buff.readLine());
                            obj.st.findBook(price);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        break;
                }
                System.out.println("Do you want to Continue ? yes/no");
                try {
                    String x = obj.buff.readLine();
                    if (x.equalsIgnoreCase("no")) {
                        break;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Do you want to Exit the app? yes/no");
            try {
                String x = obj.buff.readLine();
                if (x.equalsIgnoreCase("yes")) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}