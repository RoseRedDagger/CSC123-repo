package test;

public class DVD {
	private int id;
    private String title;
    private String publishingdate;
    private int totalCopies;
    private int availableCopies;
    private double cost;
    private boolean lost;
    private char rating;
    
    public DVD(int id, String title, String publishingdate, int totalCopies, double cost, char rating) {
        this.id = id;
        this.title = title;
        this.publishingdate = publishingdate;
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

    public String getDate() {
        return publishingdate;
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
