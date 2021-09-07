/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMS;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {

    public Main() {
    }

    public Book checkbook(Book b, MyListBook list) {
        String bcode = b.bcode;
        String title = b.title;
        int quantity = b.quantity;
        int lended = b.lended;
        double price = b.price;
        bNode p = list.head;
        String checkBcode = "This Book was exited in the list!";
        String checlLended = "Wrong number of book lended!";
        while (p != null) {
            if (p.info.bcode.equalsIgnoreCase(bcode)) {
                System.out.println(checkBcode);
                return null;
            }
            p = p.next;
        }
        if (lended > quantity) {
            System.out.println(checlLended);
            return null;
        }
        return new Book(bcode, title, quantity, lended, price);
    }

    public static void main(String[] args) {
        MyListBook list = new MyListBook();
        Scanner sc = new Scanner(System.in);
        String choice = null;
        do {
            System.out.println("1.      Load data from file");
            System.out.println("2.      Input & add to the end");
            System.out.println("3.      Display data");
            System.out.println("4.      Save book list to file");
            System.out.println("5.      Search by bcode");
            System.out.println("6.      Delete by bcode");
            System.out.println("7.      Sort by bcode");
            System.out.println("8.      Input & add to beginning");
            System.out.println("9.      Add after position  k");
            System.out.println("10.     Delete position k");
            System.out.println("0.      Exit");
            System.out.print("Enter your choice: ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    sc = new Scanner(System.in);
                    System.out.print("Enter file's name to loading: ");
                    String fname = sc.next();
                    try {
                        list.loadFile(fname);
                    } catch (Exception e) {
                        System.out.println("This file was not exit! please return program!");
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    sc = new Scanner(System.in);
                    System.out.print("Enter book's code: ");
                    String bcode = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the title: ");
                    String title = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the quantity: ");
                    int quantity = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the lended: ");
                    int lended = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the price: ");
                    double price = sc.nextDouble();
                    Main main = new Main();
                    Book b = new Book(bcode, title, quantity, lended, price);
                    if (main.checkbook(b, list) == null) {
                        System.out.println("Please reenter!");
                    } else {
                        list.addLast(b);
                    }
                    break;
                case "3":
                    list.traverse();
                    break;
                case "4":
                    System.out.print("Enter the file's name want to save data: ");
                    sc = new Scanner(System.in);
                    String fnames = sc.next();
                    try {
                        list.saveFile(fnames);
                    } catch (Exception e) {
                        System.out.println("This file was not exit yet! please return program!");
                    }
                    break;
                case "5":
                    sc = new Scanner(System.in);
                    System.out.print("Enter the book'code want to find: ");
                    String scode = sc.next();
                    if (list.SearchBybcode(scode) == null) {
                        System.out.println("This book doesn't in the system!");
                    } else {
                        System.out.println(list.SearchBybcode(scode).info);
                    }
                    break;
                case "6":
                    sc = new Scanner(System.in);
                    System.out.print("Enter the book'code want to find: ");
                    String dcode = sc.next();
                    if (list.SearchBybcode(dcode) == null) {
                        System.out.println("This book doesn't in the system");
                    } else {
                        list.DeleteBybcode(dcode);
                        System.out.println("This book has been deleted in the system!");
                    }
                    break;
                case "7":
                    list.SortBybcode();
                    System.out.println("This list in system has been sorted!");
                    break;
                case "8":
                    sc = new Scanner(System.in);
                    System.out.print("Enter book's code: ");
                    String xbcode = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the title: ");
                    String xtitle = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the quantity: ");
                    int xquantity = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the lended: ");
                    int xlended = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the price: ");
                    double xprice = sc.nextDouble();
                    Main xmain = new Main();
                    Book xb = new Book(xbcode, xtitle, xquantity, xlended, xprice);
                    if (xmain.checkbook(xb, list) == null) {
                        System.out.println("Please reenter!");
                    } else {
                        list.addFrist(xb);
                    }
                    break;
                case "9":
                    sc = new Scanner(System.in);
                    System.out.print("Enter the position want to add befor this position: ");
                    int pos = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter book's code: ");
                    String abcode = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the title: ");
                    String atitle = sc.next();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the quantity: ");
                    int aquantity = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the lended: ");
                    int alended = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Enter the price: ");
                    double aprice = sc.nextDouble();
                    Book bookk = new Book(abcode, atitle, aquantity, alended, aprice);
                    Main m = new Main();
                    m.checkbook(bookk, list);
                    if (m.checkbook(bookk, list) == null) {
                        System.out.println("please reenter!");
                    } else {
                        list.addAfter(list.searchByPosition(pos), bookk);
                    }
                    break;
                case "10":
                    sc = new Scanner(System.in);
                    System.out.print("Enter the position to delete: ");
                    int posi = sc.nextInt();
                    if (list.searchByPosition(posi) == null) {
                        System.out.println("This position not exited!");
                    } else {
                        list.DeleteBybcode(list.searchByPosition(posi).info.bcode);
                    }
                    break;
                default:
                    System.out.println("Invaild of choice, please reenter!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("0"));
    }

}
