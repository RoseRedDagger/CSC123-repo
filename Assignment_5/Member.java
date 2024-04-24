package test;
import java.util.ArrayList;
import java.util.List;

public class Member{
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private double fineAmount;
    private List<Book> borrowedBooks;
    private List<DVD> borrowedDVDs;
    private List<Magazine> borrowedMags;

    public Member(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.fineAmount = 0.0;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedDVDs = new ArrayList<>();
        this.borrowedMags = new ArrayList<>();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    public List<DVD> getBorrowedDVDs(){
    	return borrowedDVDs;
    }
    
    public List<Magazine> getBorrowedMags(){
    	return borrowedMags;
    }

    public void addFine(double amount) {
        fineAmount += amount;
    }

    public void clearFine() {
        fineAmount = 0.0;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    
    public void borrowDVD(DVD dvd) {
    	borrowedDVDs.add(dvd);
    }
    
    public void borrowMag(Magazine mag) {
    	borrowedMags.add(mag);
    }

    
    public void listMyBooks() {
        for (Book book : borrowedBooks) {
            if (book.getAvailableCopies() > 0) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("IsLostStatus: " + book.getLost());
                System.out.println("Rating: "+ book.getRating());
                System.out.println("---------------");
            }
        }
    }
    
    public void listMyDVDs() {
        for (DVD dvd : borrowedDVDs) {
            if (dvd.getAvailableCopies() > 0) {
                System.out.println("DVD ID: " + dvd.getId());
                System.out.println("Title: " + dvd.getTitle());
                System.out.println("Release Date: " + dvd.getDate());
                System.out.println("IsLostStatus: " + dvd.getLost());
                System.out.println("Rating: "+ dvd.getRating());
                System.out.println("---------------");
            }
        }
    }
    
    public void listMyMagazines() {
        for (Magazine mag : borrowedMags) {
            if (mag.getAvailableCopies() > 0) {
                System.out.println("Magazine ID: " + mag.getId());
                System.out.println("Title: " + mag.getTitle());
                System.out.println("Publication Date: " + mag.getDate());
                System.out.println("IsLostStatus: " + mag.getLost());
                System.out.println("Rating: "+ mag.getRating());
                System.out.println("---------------");
            }
        }
    }
    //returns member book back to library inventory
    public void ReturnBook(int memberId, int bookId) {
        for (Book book : borrowedBooks) {
            if (book.getId() == bookId) {
                borrowedBooks.remove(book);
                book.increaseAvailableCopies();
                System.out.println("Book Returned Successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
    
    public void ReturnDVD(int memberId, int dvdId) {
        for (DVD dvd : borrowedDVDs) {
            if (dvd.getId() == dvdId) {
                borrowedDVDs.remove(dvd);
                dvd.increaseAvailableCopies();
                System.out.println("DVD Returned Successfully!");
                return;
            }
        }
        System.out.println("DVD with ID " + dvdId + " not found.");
    }
    
    public void ReturnMagazine(int memberId, int magId) {
        for (Magazine mag : borrowedMags) {
            if (mag.getId() == magId) {
                borrowedMags.remove(mag);
                mag.increaseAvailableCopies();
                System.out.println("Magazine Returned Successfully!");
                return;
            }
        }
        System.out.println("Magazine with ID " + magId + " not found.");
    }
    //sets book status to lost and applies a fine (fine only applies to one instance of a book type, if 2 are held, both are lost but only 1 is charged)
    public void BookStatus(int memberId, int bookId) {
        for (Book book : borrowedBooks) {
            if (book.getId() == bookId) {
                book.SetStatus();
                addFine(book.getCost());
                System.out.println("Book Status Changed: Fine Added!");
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
    
    public void DVDStatus(int memberId, int dvdId) {
        for (DVD dvd : borrowedDVDs) {
            if (dvd.getId() == dvdId) {
                dvd.SetStatus();
                addFine(dvd.getCost());
                System.out.println("DVD Status Changed: Fine Added!");
                return;
            }
        }
        System.out.println("DVD with ID " + dvdId + " not found.");
    }
    
    public void MagazineStatus(int memberId, int magId) {
        for (Magazine mag : borrowedMags) {
            if (mag.getId() == magId) {
                mag.SetStatus();
                addFine(mag.getCost());
                System.out.println("Magazine Status Changed: Fine Added!");
                return;
            }
        }
        System.out.println("Magazine with ID " + magId + " not found.");
    }
    //clears fines and removes book from members inventory without returning a copy
    public void PayPendingBookFines(int memberId, int bookId) {
    	
    	for (Book book : borrowedBooks) {
            if (book.getId() == bookId) {
            	if(book.getLost()==true) {
            		System.out.println("Fine of : $"+ book.getCost()+" Will be paid");
                	System.out.println("Processing payment...");
                	fineAmount-=book.getCost();
            		borrowedBooks.remove(book);
                	System.out.println("Fine payed and book removed from directory!");
                	System.out.println("New fine balance: "+fineAmount);
                    return;
            	}
            	System.out.println("Book ID "+bookId+" Not Associated with Fine");
            }
        }
    	System.out.println("Book with ID " + bookId + " not found.");
    	
    	
    	
    }
    
public void PayPendingDVDFines(int memberId, int dvdId) {
    	
    	for (DVD dvd : borrowedDVDs) {
            if (dvd.getId() == dvdId) {
            	if(dvd.getLost()==true) {
            		System.out.println("Fine of : $"+ dvd.getCost()+" Will be paid");
                	System.out.println("Processing payment...");
                	fineAmount-=dvd.getCost();
            		borrowedDVDs.remove(dvd);
                	System.out.println("Fine payed and DVD removed from directory!");
                	System.out.println("New fine balance: "+fineAmount);
                    return;
            	}
            	System.out.println("DVD ID "+dvdId+" Not Associated with Fine");
            }
        }
    	System.out.println("DVD with ID " + dvdId + " not found.");
    	
    	
    	
    }

public void PayPendingMagazineFines(int memberId, int magId) {
	
	for (Magazine mag : borrowedMags) {
        if (mag.getId() == magId) {
        	if(mag.getLost()==true) {
        		System.out.println("Fine of : $"+ mag.getCost()+" Will be paid");
            	System.out.println("Processing payment...");
            	fineAmount-=mag.getCost();
        		borrowedMags.remove(mag);
            	System.out.println("Fine payed and Magazine removed from directory!");
            	System.out.println("New fine balance: "+fineAmount);
                return;
        	}
        	System.out.println("Magazine ID "+magId+" Not Associated with Fine");
        }
    }
	System.out.println("Magazine with ID " + magId + " not found.");
	
	
	
}
    
    
}
