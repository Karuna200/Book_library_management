package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

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
        mySqlConnect db = new mySqlConnect();
        Connection mConnection = db.getmConnection();
        Library st = new Library(mConnection);

        while (true) {

            System.out.println("Welcome to My Library Management!! ");
            Book b = new Book();

            while (true) {

                System.out.println("Please Select Your Operation\n1. Add Book\n2. Remove Book\n3. Find By Book Name\n4. Find By Author Name\n5. Update the Book \n6. Find Book by Cost. \n7. Find Book by Category. \n8. Find by Book given in the range\n9. Find Cheapest Book\n10. Find Most Costliest Book\n11. Find Book 2 year old Book\n12. Remove 2yr old Books.");
                try {
                    obj.select_Operation = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                switch (obj.select_Operation) {
                    case 1:
                        st.addBook();
                        break;
                    case 2:
                        st.removeBook();
                        break;
                    case 3:
                        st.findBookByName();
                        break;
                    case 4:
                        st.findBookByAuthorName();
                        break;
                    case 5:
                        st.UpdateBook();
                        break;
                    case 6: st.findBookByCost();
                             break;
                    case 7: st.findBookByCategory();
                            break;
                    case 8: st.findCostRange();
                           break;
                    case 9: st.findCheapestBook();
                            break;
                    case 10: st.findCostliestBook();
                            break;
                    case 11: st.find2yrOldBook();
                            break;
                    case 12: st.remove2yrOldBook();
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