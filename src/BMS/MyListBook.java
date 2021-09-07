/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BMS;
import java.io.*;
/**
 *
 * @author Admin
 */
public class MyListBook {
    bNode head;
    bNode tail;

    public MyListBook() {
    }
    
    
    public MyListBook(bNode head, bNode tail) {
        this.head = this.tail;
    }
    
    void clear(){
        head = tail = null;
    }
    
    boolean isEmpty(){
        return (head == null);
    }
    
    void visit(bNode p){
        if(p!=null){
            System.out.println(p.info);
        }
    }
    
    void traverse(){
        bNode p = head;
        while(p!=null){
            visit(p);
            p = p.next;
        }
        System.out.println();
    }
    
    bNode SearchBybcode(String xbcode){
        if(isEmpty()) return null;
        bNode p = head;
        while(p!=null){
            if(p.info.bcode.equalsIgnoreCase(xbcode)){
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    void removefrist(){
        if(isEmpty()){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
    }
    void DeleteBybcode(String xbcode){
        bNode q = SearchBybcode(xbcode);
        if(q == head){
            removefrist();
        }
        bNode f = head;
        while(f != null && f.next != q){
            f = f.next;
        }
        if(f == null){
            return; // q is not found;
        }else{
            bNode q1 = q.next;
            f.next = q1;
            if(q == tail){
                tail = f;
            }
        }
    }
    
    void SortBybcode(){
        bNode pi,pj;
        Book temp;
        for(pi = head ; pi != null ; pi = pi.next){
            for(pj = pi.next; pj != null ; pj = pj.next){
                if(pi.info.bcode.compareToIgnoreCase(pj.info.bcode) > 0){
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
    void addFrist(Book xBook){
        head = new bNode(xBook, head);
    }
    
    void addLast(Book xBook){
        bNode q = new bNode(xBook);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;;
    }
    
    void addAfter(bNode q, Book b){
        if (q == null) {
            return;
        }
        bNode p = new bNode(b, q.next);
        q.next = p;
        if (tail == q) {
            tail = q;
        }
    }
    
    bNode searchByPosition(int k){
        int i = 0;
        bNode p = head;
        while(p!=null){
            if(i==k){
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }
    void DeletePosition(int k){
        int i = 0;
        bNode p = searchByPosition(k);
        DeleteBybcode(p.info.bcode);
    }
    
    void loadFile(String fname)throws IOException{
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String [] a;
        String xbcode, xtitle;
        int xquantity,xlended;
        double xprice;
        while(true){
            s = br.readLine();
            a = s.split("[|]");
            if(a==null || a.length <5){
                break;
            }
            xbcode = a[0].trim();
            xtitle = a[1].trim();
            xquantity = Integer.parseInt(a[2].trim());
            xlended = Integer.parseInt(a[3].trim());
            xprice = Double.parseDouble(a[4].trim());
            addLast(new Book(xbcode, xtitle, xquantity, xlended, xprice));
        }
        fr.close();
        br.close();
    }
    
    
    void saveFile(String fname) throws IOException{
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fname);
        bNode p = head;
        while(p != null){
            String bcode = p.info.bcode;
            String title = p.info.title;
            int quantity = p.info.quantity;
            int lended = p.info.lended;
            double price = p.info.price;
            System.out.format("%10s|%10s|%10d|%10d|%10f",bcode,title,quantity,lended,price);
            p = p.next;
        }
        pw.close();
        pw.close();
    }
}
