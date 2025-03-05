package com.model;


	import java.time.LocalDateTime;

	public class Booking {
	    private int id;
	    private String name;
	    private String email;
	    private LocalDateTime bookingDate;
	    private int numPeople;
	    private String specialRequest;

	    // Constructors
	    public Booking() {}
	    public Booking(String name, String email, LocalDateTime bookingDate, int numPeople, String specialRequest) {
	        this.name = name;
	        this.email = email;
	        this.bookingDate = bookingDate;
	        this.numPeople = numPeople;
	        this.specialRequest = specialRequest;
	    }

	    // Getters and Setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public LocalDateTime getBookingDate() { return bookingDate; }
	    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

	    public int getNumPeople() { return numPeople; }
	    public void setNumPeople(int numPeople) { this.numPeople = numPeople; }

	    public String getSpecialRequest() { return specialRequest; }
	    public void setSpecialRequest(String specialRequest) { this.specialRequest = specialRequest; }
		public boolean bookTable(Booking booking) {
			// TODO Auto-generated method stub
			return false;
		}
	


}

