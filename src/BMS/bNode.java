/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMS;

/**
 *
 * @author Admin
 */
public class bNode {
    Book info;
    bNode next;

    public bNode() {
    }
    public bNode(Book info){
        this.info = info;
        this.next = null;
    }
    public bNode(Book info, bNode next) {
        this.info = info;
        this.next = next;
    }
    
}
