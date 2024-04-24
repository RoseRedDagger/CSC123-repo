package test;

import java.util.Scanner;

public class LibraryTest {
	 public static void main(String[] args) {
	        Library library = new Library();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        System.out.println("Library Portal Initialized....");

	        while (true) {
	            System.out.println("1. Enter as a librarian");
	            System.out.println("2. Enter as a member");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    librarianMenu(library, scanner);
	                    break;
	                case 2:
	                    memberMenu(library, scanner);
	                    break;
	                case 3:
	                    System.out.println("Thanks for visiting!");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	 
	 private static void librarianMenu(Library library, Scanner scanner) {
	        int choice;
	        while (true) {
	            System.out.println("Librarian Menu:");
	            System.out.println("1. Add a Item");
	            System.out.println("2. Remove a Item");
	            System.out.println("3. Register a member");
	            System.out.println("4. Remove a member");
	            System.out.println("5. List available Items");
	            System.out.println("6. Change Item Status/Issue a Fine");
	            System.out.println("7. Back");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    // Add a Item
	                	AddMenu(library, scanner);
	                    
	                    break;
	                case 2:
	                    // Remove a Item
	                    RemoveMenu(library, scanner);
	                    break;
	                case 3:
	                    // Register a member
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter age: ");
	                    int age = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    System.out.print("Enter phone number: ");
	                    String phoneNumber = scanner.nextLine();
	                    library.registerMember(name, age, phoneNumber);
	                    break;
	                case 4:
	                    // Remove a member
	                    System.out.print("Enter member ID: ");
	                    int memberId = scanner.nextInt();
	                    library.removeMember(memberId);
	                    break;
	                case 5:
	                    // List available Items
	                    library.listAvailableBooks();
	                    library.listAvailableDVDs();
	                    library.listAvailableMagazines();
	                    break;
	                case 6:
	                	//change item status to lost
	                	StatusMenu(library, scanner);
	                	break;
	                case 7:
	                    // Back to the previous menu
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	 
	 private static void AddMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Add Item Menu:");
	            System.out.println("1. Add a book");
	            System.out.println("2. Add a DVD");
	            System.out.println("3. Add a Magazine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//add book
	            	System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book rating(E, T, A) no lowercases: ");
                    char rating = scanner.next().charAt(0);
                    System.out.print("Enter total copies: ");
                    int totalCopies = scanner.nextInt();
                    System.out.print("Enter book list price: ");
                    double cost = scanner.nextDouble();
                    library.addBook(title, author, totalCopies, cost, rating);
	            	break;
	            case 2:
	            	//add dvd
	            	System.out.print("Enter title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter release date (MM/YY) or other date format: ");
                    String publishingdate = scanner.nextLine();
                    System.out.print("Enter DVD rating(E, T, A) no lowercases: ");
                    char rating1 = scanner.next().charAt(0);
                    System.out.print("Enter total copies: ");
                    int totalCopies1 = scanner.nextInt();
                    System.out.print("Enter DVD list price: ");
                    double cost1 = scanner.nextDouble();
                    library.addDVD(title1, publishingdate, totalCopies1, cost1, rating1);
	            	break;
	            case 3:
	            	//add magazine
	            	System.out.print("Enter title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter Publishing date (MM/YY) or other date format: ");
                    String publishingdate2 = scanner.nextLine();
                    System.out.print("Enter Magazine rating(E, T, A) no lowercases: ");
                    char rating2 = scanner.next().charAt(0);
                    System.out.print("Enter total copies: ");
                    int totalCopies2 = scanner.nextInt();
                    System.out.print("Enter Magazine list price: ");
                    double cost2 = scanner.nextDouble();
                    library.addMagazine(title2, publishingdate2, totalCopies2, cost2, rating2);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
	 }
	 
	 private static void RemoveMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Remove Item Menu:");
	            System.out.println("1. Remove a book");
	            System.out.println("2. Remove a DVD");
	            System.out.println("3. Remove a Magazine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//remove book
	            	System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    library.removeBook(bookId);
	            	break;
	            case 2:
	            	//remove dvd
	            	System.out.print("Enter DVD ID: ");
                    int dvdId = scanner.nextInt();
                    library.removeDVD(dvdId);
	            	break;
	            case 3:
	            	//remove magazine
	            	System.out.print("Enter Magazine ID: ");
                    int magId = scanner.nextInt();
                    library.removeMagazine(magId);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
		 
	 }
	 
	 private static void StatusMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Status Menu:");
	            System.out.println("1. Change book status/issue fine");
	            System.out.println("2. Change DVD status/issue fine");
	            System.out.println("3. Change Magazine status/issue fine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//change book to lost
	            	System.out.print("Enter member ID: ");
                    int MemberId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int BookId = scanner.nextInt();
                    library.ChangeBookStatus(MemberId, BookId);
	            	break;
	            case 2:
	            	//change dvd to lost
	            	System.out.print("Enter member ID: ");
                    int MemBerId = scanner.nextInt();
                    System.out.print("Enter DVD ID: ");
                    int DVdId = scanner.nextInt();
                    library.ChangeDVDStatus(MemBerId, DVdId);
	            	break;
	            case 3:
	            	//change magazine to lost
	            	System.out.print("Enter member ID: ");
                    int MemBeRId = scanner.nextInt();
                    System.out.print("Enter Magazine ID: ");
                    int MaGId = scanner.nextInt();
                    library.ChangeMagStatus(MemBeRId, MaGId);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
		 
	 }
	 
	 private static void IssueMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Issue Menu:");
	            System.out.println("1. Issue a Book");
	            System.out.println("2. Issue a DVD");
	            System.out.println("3. Issue a Magazine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//Issue Book
	            	System.out.print("Enter your member ID: ");
                    int memberId = scanner.nextInt();
                    System.out.print("Enter the book ID to issue: ");
                    int bookId = scanner.nextInt();
                    library.issueBook(memberId, bookId);
	            	break;
	            case 2:
	            	//Issue DVD
	            	System.out.print("Enter your member ID: ");
                    int memBerId = scanner.nextInt();
                    System.out.print("Enter the DVD ID to issue: ");
                    int dvdId = scanner.nextInt();
                    library.issueDVD(memBerId, dvdId);
	            	break;
	            case 3:
	            	//Issue Magazine
	            	System.out.print("Enter your member ID: ");
                    int meMberId = scanner.nextInt();
                    System.out.print("Enter the Magazine ID to issue: ");
                    int mAgId = scanner.nextInt();
                    library.issueMagazine(meMberId, mAgId);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
	 }
	 
	 private static void ReturnMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Return Menu:");
	            System.out.println("1. Return a Book");
	            System.out.println("2. Return a DVD");
	            System.out.println("3. Return a Magazine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//Return Book
	            	System.out.print("Enter your member ID: ");
                    int MemberId = scanner.nextInt();
                    System.out.print("Enter the book ID to Return: ");
                    int BookId = scanner.nextInt();
                    library.ReturnMemberBook(MemberId, BookId);
	            	break;
	            case 2:
	            	//Return DVD
	            	System.out.print("Enter your member ID: ");
                    int MembeRId = scanner.nextInt();
                    System.out.print("Enter the DVD ID to Return: ");
                    int DvdId = scanner.nextInt();
                    library.ReturnMemberDVD(MembeRId, DvdId);
	            	break;
	            case 3:
	            	//Return Magazine
	            	System.out.print("Enter your member ID: ");
                    int MEmbeRId = scanner.nextInt();
                    System.out.print("Enter the Magazine ID to Return: ");
                    int MAGId = scanner.nextInt();
                    library.ReturnMemberMag(MEmbeRId, MAGId);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
	 }
	 
	 private static void PayMenu(Library library, Scanner scanner) {
		 int choice;
		 while(true) {
			 System.out.println("Pay Menu:");
	            System.out.println("1. Pay a Book fine");
	            System.out.println("2. Pay a DVD fine");
	            System.out.println("3. Pay a Magazine fine");
	            System.out.println("4. Back");
	            System.out.println("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch(choice) {
	            case 1:
	            	//Pay Book
	            	System.out.print("Enter your member ID: ");
                    int MemberID = scanner.nextInt();
                    System.out.print("Enter Book Id Associated to fine: ");
                    int BookID = scanner.nextInt();
                    library.PayBookFines(MemberID, BookID);
	            	break;
	            case 2:
	            	//Pay DVD
	            	System.out.print("Enter your member ID: ");
                    int MembErID = scanner.nextInt();
                    System.out.print("Enter DVD Id Associated to fine: ");
                    int dVdID = scanner.nextInt();
                    library.PayDVDFines(MembErID, dVdID);
	            	break;
	            case 3:
	            	//Pay Magazine
	            	System.out.print("Enter your member ID: ");
                    int MemBErID = scanner.nextInt();
                    System.out.print("Enter Magazine Id Associated to fine: ");
                    int magID = scanner.nextInt();
                    library.PayMagFines(MemBErID, magID);
	            	break;
	            case 4:
	            	//back to previous menu
	            	return;
	            }
		 }
	 }

	    private static void memberMenu(Library library, Scanner scanner) {
	        int choice;
	        while (true) {
	            System.out.println("Member Menu:");
	            System.out.println("1. List available Items");
	            System.out.println("2. List my Items");
	            System.out.println("3. Issue a Item");
	            System.out.println("4. Return a Item");
	            System.out.println("5. Pay fine");
	            System.out.println("6. View all members along with their Items and fines to be paid");
	            System.out.println("7. Back");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    // List available Items
	                    library.listAvailableBooks();
	                    library.listAvailableDVDs();
	                    library.listAvailableMagazines();
	                    break;
	                case 2:
	                    // List my Items 
	                	System.out.print("Enter your member ID: ");
	                    int memberID = scanner.nextInt();
	                    library.listMemberBooks(memberID);
	                    library.listMemberDVDs(memberID);
	                    library.listMemberMagazines(memberID);
	                    break;
	                case 3:
	                    // Issue an Item
	                    IssueMenu(library, scanner);
	                    break;
	                case 4:
	                    // Return an Item
	                	ReturnMenu(library, scanner);
	                    break;
	                case 5:
	                    // Pay fine
	                	PayMenu(library, scanner);
	                    break;
	                case 6:
	                    // View all members along with their Items and fines to be paid
	                	library.ListMembersAndInformation();
	                    break;
	                case 7:
	                    // Back to the previous menu
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

}
