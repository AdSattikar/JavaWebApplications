/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import jakarta.ws.rs.Path;
import jakarta.xml.bind.annotation.XmlRootElement;
@Path("/members")
@XmlRootElement
public class Member {
    private int id;
    private String name;
    private String Address;
    private String Contact;
    private String book;
    private String dueDate;
    public Member() {
    }

    public Member(int id, String name,String Address, String Contact,String book_borrowed, String dueDate) {
        this.id = id;
        this.name = name;
        this.Address = Address;
        this.Contact = Contact;
        this.book = book_borrowed;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public String getAddress() {
        return Address;
    }
     public void setAddress(String add) {
        this.Address = add;
    }
    public String getContact() {
        return Contact;
    }
     public void setContact(String contact) {
        this.Contact = contact;
    }
     public String getBookBorrowed() {
        return book;
    }
      public void setBookBorrowed(String bookbor) {
        this.book = bookbor;
    }
      public String getDueDate() {
        return dueDate;
    }
       public void setDate(String date) {
        this.dueDate = date;
    }
}
