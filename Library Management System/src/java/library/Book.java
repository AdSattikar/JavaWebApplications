/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import jakarta.ws.rs.Path;
import jakarta.xml.bind.annotation.XmlRootElement;
@Path("/library/books")
@XmlRootElement
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int floor;
    private int shelf;
    
    private int availableCopies;

    public Book() {
    }

    public Book(String title, String author, String publisher ,int availableCopies, int floor,int shelf ) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.floor = floor;
        this.shelf = shelf;
        this.availableCopies = availableCopies;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
     public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
     public int getFloor() {
        return floor;
    }
     public void setFloor(int floor){
         this.floor = floor;
     }
     public int getShelf() {
        return shelf;
    }
     public void setShelf(int shelf){
         this.shelf = shelf;
     }
    public int getAvailableCopies() {
        return availableCopies;
    }
     public void setAvailableCopies(int copies) {
        this.availableCopies = copies;
    }

}

