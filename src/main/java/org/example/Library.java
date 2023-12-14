package org.example;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;






public class Library<SimpleDateFormat> implements Stock {

    Connection mConnection;
    PreparedStatement ptsmt = null;

    public Library(Connection mConnection) {
        this.mConnection = mConnection;
    }

    @Override
    public void findBookByName() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of the Book: ");
        try {
            String str = buff.readLine();
            ptsmt = mConnection.prepareStatement("Select book_name from book_details where book_name = ?");
            ptsmt.setString(1, str);
            ResultSet rs = ptsmt.executeQuery();
            if (rs.next()) {
                Book bk = new Book();
                bk.setName(rs.getString(1));
                System.out.println("Your Book is found " + bk.getName());
            } else {
                System.out.println("Sorry, the book was not found in the database.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void findBookByAuthorName() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Name of the Author: ");
        try {
            String str = buff.readLine();
            ptsmt = mConnection.prepareStatement("Select book_name from book_details where author_name = ? ");
            ptsmt.setString(1, str);
            ResultSet rs = ptsmt.executeQuery();
            System.out.println("The name of the books found from the given author are: ");
            boolean flag = false;
            while (rs.next()) {
                Book bk = new Book();
                bk.setauthorName(rs.getString(1));
                System.out.println(bk.getauthorName());
                flag = true;
            }
            if (!flag) {
                System.out.println("Sorry!! Book is not found");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook() {
        try {
            Book b = new Book();
            //Statement stmt = mConnection.createStatement();
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Book id: ");
            b.setBook_id(Integer.parseInt(buff.readLine()));
            System.out.println("Enter the Name of the Book: ");
            b.setName(buff.readLine());
            System.out.println("Enter Author Name: ");
            b.setauthorName(buff.readLine());
            System.out.println("Enter the Book Category: ");
            b.setCategory(buff.readLine());
            System.out.println("Enter the price: ");
            b.setPrice(Float.parseFloat(buff.readLine()));
            System.out.println("Enter the date: ");

            String dateString = buff.readLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate bookAddedDate = LocalDate.parse(dateString, formatter);
            java.sql.Date sqlDate = java.sql.Date.valueOf(bookAddedDate);
            b.setDate(sqlDate);

            ptsmt = mConnection.prepareStatement("Insert into book_details values(?,?,?,?,?,?)");
            ptsmt.setInt(1, b.getBook_id());
            ptsmt.setString(2, b.getName());
            ptsmt.setString(3, b.getauthorName());
            ptsmt.setString(4, b.getCategory());
            ptsmt.setFloat(5, b.getPrice());
            ptsmt.setDate(6, b.getDate());
            ptsmt.executeUpdate();

            System.out.println("Your Book is saved successfully: ");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBook() {
        System.out.println("Enter the id of the book to be removed:: ");
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(buff.readLine());
            ptsmt = mConnection.prepareStatement("delete from book_details where book_id = ?");
            ptsmt.setInt(1, id);
            ptsmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Your Book is removed!!");
    }

    @Override
    public void UpdateBook(){
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try {
            // Get book details to update
            System.out.println("Enter the Book ID to update: ");
            int bookId = Integer.parseInt(buff.readLine());

            System.out.println("Enter the new Book Name: ");
            String newBookName = buff.readLine();

            System.out.println("Enter the new Author Name: ");
            String newAuthorName = buff.readLine();

            // Perform the update
            String updateQuery = "UPDATE book_details SET book_name = ?, author_name = ? WHERE book_id = ?";
            try (PreparedStatement ptsmt = mConnection.prepareStatement(updateQuery)) {
                ptsmt.setString(1, newBookName);
                ptsmt.setString(2, newAuthorName);
                ptsmt.setInt(3, bookId);

                int rowsUpdated = ptsmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Book updated successfully.");
                } else {
                    System.out.println("No book found with the specified ID. Update failed.");
                }
            }

        } catch (IOException | SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}

