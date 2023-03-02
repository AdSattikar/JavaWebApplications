/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package library;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import java.util.Iterator;

@Path("library")
public class LibraryResource {

    @Context
    private UriInfo context;

    private static final List<Book> books = new ArrayList<>();
    private static final List<Member> members = new ArrayList<>();

    static {
        // Populate the library with some books and members
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribners Sons", 3, 2, 3));
//        books.add(new Book("Lab Assessment 4", "Sabir Inamdar", 3));
        members.add(new Member(1002, "Jane Smith", "456 Elm St.", "janesmith@example.com", "The Great Gatsby", "2023-03-10"));

    }

    @GET
    @Path("Books")
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBooks() {
        // Return all the books in the library

        return books;
    }

    @PUT
    @Path("Books")
    @Consumes(MediaType.APPLICATION_XML)
    public void putBooks(List<Book> bookstoAdd) {
        // Return all the books in the library
        books.addAll(bookstoAdd);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getInfo() {
        // Return all the members in the library

        return "<info>20MIC0124 Adnan Sattikar: Digital Assignment 1 Choose the below paths to send and retrieve data 1.Books 2.Members</info>";
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("Members")
    public List<Member> getsMembers() {
        // Return all the members in the library

        return members;
    }

    @PUT
    @Path("Members")
    @Consumes(MediaType.APPLICATION_XML)
    public void putsMembers(List<Member> memberstoAdd) {
        // Return all the books in the library
        members.addAll(memberstoAdd);
    }

    @GET
    @Path("Books/{title}")
    @Produces(MediaType.APPLICATION_XML)
    public Book getBook(@PathParam("title") String title) {
        // Find a book by title and return it
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @GET
    @Path("Members/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Member getMember(@PathParam("id") int id) {
        // Find a member by ID and return it
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    @Path("Books/{title}")
    public void deleteBook(@PathParam("title") String title) {
        // Find a book by title and remove it
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
            }
        }
    }

    @DELETE
    @Path("Members/{id}")
    public void deleteMember(@PathParam("id") int id) {
        // Find a member by ID and remove it
        for (Member member : members) {
            if (member.getId() == id) {
                members.remove(member);
            }
        }
    }
}
