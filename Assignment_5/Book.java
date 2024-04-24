package test;

public class Book {
    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    private double cost;//use cost variable to add to fine variable
    private boolean lost;
    private char rating;
    

    public Book(int id, String title, String author, int totalCopies, double cost, char rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.lost = lost;
        this.cost = cost;
        this.rating = rating;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
    
    public boolean getLost() {
    	return lost;
    }
    public double getCost() {
    	return cost;
    }
    public char getRating() {
    	return rating;
    }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }

    public void increaseAvailableCopies() {
        availableCopies++;
    }
    
    public void SetStatus() {
    	lost = true;
    	
    }
}
