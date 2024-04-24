package test;

import java.util.*;
import java.io.*;

public class Library {
	private List<Magazine> mags;
	private List<DVD> dvds;
    private List<Book> books;
    private List<Member> members;
    private int memberIdCounter;
    private int bookIdCounter;
    private int dvdIdCounter;
    private int magIdCounter;

    public Library() {
    	this.mags = new ArrayList<>();
    	this.dvds = new ArrayList<>();
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.memberIdCounter = 1; // Initial member ID
        this.bookIdCounter = 1; // Initial book ID
        this.dvdIdCounter = 1; //initial dvd ID
        this.magIdCounter = 1; //initial magazine ID
    }
//add and remove methods for respective Items
    public void addBook(String title, String author, int totalCopies, double cost, char rating) {
        int bookId = bookIdCounter++;
        Book book = new Book(bookId, title, author, totalCopies, cost, rating);
        books.add(book);
        System.out.println("Book Added Successfully!");
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                System.out.println("Book Removed Successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
    
    public void addDVD(String title, String publishingdate, int totalCopies, double cost, char rating) {
        int dvdId = dvdIdCounter++;
        DVD dvd = new DVD(dvdId, title, publishingdate, totalCopies, cost, rating);
        dvds.add(dvd);
        System.out.println("DVD Added Successfully!");
    }

    public void removeDVD(int dvdId) {
        for (DVD dvd : dvds) {
            if (dvd.getId() == dvdId) {
                dvds.remove(dvd);
                System.out.println("DVD Removed Successfully!");
                return;
            }
        }
        System.out.println("DVD with ID " + dvdId + " not found.");
    }
    
    public void addMagazine(String title, String publishingdate, int totalCopies, double cost, char rating) {
        int magId = magIdCounter++;
        Magazine mag = new Magazine(magId, title, publishingdate, totalCopies, cost, rating);
        mags.add(mag);
        System.out.println("Magazine Added Successfully!");
    }

    public void removeMagazine(int magId) {
        for (Magazine mag : mags) {
            if (mag.getId() == magId) {
                mags.remove(mag);
                System.out.println("Magazine Removed Successfully!");
                return;
            }
        }
        System.out.println("Magazine with ID " + magId + " not found.");
    }
//registers a member in the library
    public void registerMember(String name, int age, String phoneNumber) {
        int memberId = memberIdCounter++;
        Member member = new Member(memberId, name, age, phoneNumber);
        members.add(member);
        System.out.println("Member Successfully Registered with ID: " + memberId);
    }
//removes a registered member
    public void removeMember(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                members.remove(member);
                System.out.println("Member Removed Successfully!");
                return;
            }
        }
        System.out.println("Member with ID " + memberId + " not found.");
    }
//List Available Items in Library storage methods
    public void listAvailableBooks() {
        System.out.println("List of Available Books:");
        for (Book book : books) {
            if (book.getAvailableCopies() > 0) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available Copies: " + book.getAvailableCopies());
                System.out.println("Rating: " + book.getRating());
                System.out.println("---------------");
            }
        }
        
        
    }
    
    public void listAvailableDVDs() {
        System.out.println("List of Available DVDs:");
        for (DVD dvd : dvds) {
            if (dvd.getAvailableCopies() > 0) {
                System.out.println("DVD ID: " + dvd.getId());
                System.out.println("Title: " + dvd.getTitle());
                System.out.println("Realease Date: " + dvd.getDate());
                System.out.println("Available Copies: " + dvd.getAvailableCopies());
                System.out.println("Rating: " + dvd.getRating());
                System.out.println("---------------");
            }
        }
    }
    
    public void listAvailableMagazines() {
        System.out.println("List of Available Magazines:");
        for (Magazine mag : mags) {
            if (mag.getAvailableCopies() > 0) {
                System.out.println("Magazine ID: " + mag.getId());
                System.out.println("Title: " + mag.getTitle());
                System.out.println("Publishing Date: " + mag.getDate());
                System.out.println("Available Copies: " + mag.getAvailableCopies());
                System.out.println("Rating: " + mag.getRating());
                System.out.println("---------------");
            }
        }
    }
    //List Members held Items methods
    public void listMemberBooks(int memberId) {
    	Member member = findMemberById(memberId);
        System.out.println("List of Borrowed Books For ID: "+memberId);
        member.listMyBooks();
    }
    
    public void listMemberDVDs(int memberId) {
    	Member member = findMemberById(memberId);
        System.out.println("List of Borrowed DVDs For ID: "+memberId);
        member.listMyDVDs();
    }
    
    public void listMemberMagazines(int memberId) {
    	Member member = findMemberById(memberId);
        System.out.println("List of Borrowed Magazines For ID: "+memberId);
        member.listMyMagazines();
    }
    //return Item Methods
    public void ReturnMemberBook(int memberId, int bookId) {
    	Member member = findMemberById(memberId);
    	member.ReturnBook(memberId, bookId);
        
    }
    
    public void ReturnMemberDVD(int memberId, int dvdId) {
    	Member member = findMemberById(memberId);
    	member.ReturnDVD(memberId, dvdId);
        
    }
    
    public void ReturnMemberMag(int memberId, int magId) {
    	Member member = findMemberById(memberId);
    	member.ReturnMagazine(memberId, magId);
        
    }
    //Changing Item status to lost and applying fine methods
    public void ChangeBookStatus(int memberId, int bookId) {
    	Member member = findMemberById(memberId);
    	member.BookStatus(memberId, bookId);
    }
    
    public void ChangeDVDStatus(int memberId, int dvdId) {
    	Member member = findMemberById(memberId);
    	member.DVDStatus(memberId, dvdId);
    }
    
    public void ChangeMagStatus(int memberId, int magId) {
    	Member member = findMemberById(memberId);
    	member.MagazineStatus(memberId, magId);
    }
    //Paying Item Fines methods
    public void PayBookFines(int memberId, int bookId) {
    	Member member = findMemberById(memberId);
    	member.PayPendingBookFines(memberId, bookId);
    }
    
    public void PayDVDFines(int memberId, int dvdId) {
    	Member member = findMemberById(memberId);
    	member.PayPendingDVDFines(memberId, dvdId);
    }
    
    public void PayMagFines(int memberId, int magId) {
    	Member member = findMemberById(memberId);
    	member.PayPendingMagazineFines(memberId, magId);
    }
    //lists all members and their held Items
    public void ListMembersAndInformation() {
    	for(Member member : members) {
    		System.out.println("Member ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Fine amount: $"+ member.getFineAmount());
            listMemberBooks(member.getId());
            listMemberDVDs(member.getId());
            listMemberMagazines(member.getId());
    	}
    	
    }
    
    //methods to issue Items
    
    public void issueBook(int memberId, int bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null || book == null) {
            System.out.println("Member or Book not found.");
            return;
        }

        if (member.getFineAmount() > 0.0) {
            System.out.println("You have pending fines. Please clear them first.");
            return;
        }

        if (member.getBorrowedBooks().size() >= 2) {
            System.out.println("You can only borrow up to 2 books at a time.");
            return;
        }
        if(book.getRating()=='A' && member.getAge()<18) {
        	System.out.println("Member is not of age to issue book rated Adult");
        	return;
        }

        if (book.getAvailableCopies() > 0) {
            member.borrowBook(book);
            book.decreaseAvailableCopies();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("No available copies of the book.");
        }
    }
    
    public void issueDVD(int memberId, int dvdId) {
        Member member = findMemberById(memberId);
        DVD dvd = findDVDById(dvdId);

        if (member == null || dvd == null) {
            System.out.println("Member or DVD not found.");
            return;
        }

        if (member.getFineAmount() > 0.0) {
            System.out.println("You have pending fines. Please clear them first.");
            return;
        }

        if (member.getBorrowedDVDs().size() >= 2) {
            System.out.println("You can only borrow up to 2 DVDs at a time.");
            return;
        }
        if(dvd.getRating()=='A' && member.getAge()<18) {
        	System.out.println("Member is not of age to issue DVD rated Adult");
        	return;
        }

        if (dvd.getAvailableCopies() > 0) {
            member.borrowDVD(dvd);
            dvd.decreaseAvailableCopies();
            System.out.println("DVD issued successfully.");
        } else {
            System.out.println("No available copies of the DVD.");
        }
    }
    
    public void issueMagazine(int memberId, int magId) {
        Member member = findMemberById(memberId);
        Magazine mag = findMagById(magId);

        if (member == null || mag == null) {
            System.out.println("Member or Magazine not found.");
            return;
        }

        if (member.getFineAmount() > 0.0) {
            System.out.println("You have pending fines. Please clear them first.");
            return;
        }

        if (member.getBorrowedMags().size() >= 2) {
            System.out.println("You can only borrow up to 2 Magazines at a time.");
            return;
        }
        if(mag.getRating()=='A' && member.getAge()<18) {
        	System.out.println("Member is not of age to issue Magazine rated Adult");
        	return;
        }

        if (mag.getAvailableCopies() > 0) {
            member.borrowMag(mag);
            mag.decreaseAvailableCopies();
            System.out.println("Magazine issued successfully.");
        } else {
            System.out.println("No available copies of the Magazine.");
        }
    }

    // Helper methods to find a member by ID and a Item by ID
    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }
    
    private DVD findDVDById(int dvdId) {
        for (DVD dvd : dvds) {
            if (dvd.getId() == dvdId) {
                return dvd;
            }
        }
        return null;
    }
    
    private Magazine findMagById(int magId) {
        for (Magazine mag : mags) {
            if (mag.getId() == magId) {
                return mag;
            }
        }
        return null;
    }

   

    
}
