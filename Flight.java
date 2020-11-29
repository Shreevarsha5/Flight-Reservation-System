package com.FlightReservationSystem;

        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;

public class Flight {

    private final int[] flightNumbers;
    private final int numberOfFlights;
    public final LocalDateTime dateAndTimeOfDeparture;
    public final LocalDateTime dateAndTimeOfArrival;
    private float ticketPrice;
    private final String[] origin;
    private final String[] destination;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Flight(int numberOfFlights, int[] flightNumbers, String[] origin, LocalDateTime dateAndTimeOfDeparture,
                  String[] destination, LocalDateTime dateAndTimeOfArrival){
        this.numberOfFlights = numberOfFlights;
        this.dateAndTimeOfDeparture = dateAndTimeOfDeparture;
        this.dateAndTimeOfArrival = dateAndTimeOfArrival;
        this.flightNumbers = flightNumbers;
        this.origin = origin;
        this.destination = destination;
        setTicketPrice();
    }

    public void setTicketPrice(){
        this.ticketPrice = (float) (Math.random() * (5000 - 2000)) + 2000;
    }

    public float getTicketPrice(){
        return (float)Math.floor((this.ticketPrice * 100) / 100);
    }

    public int[] getFlightNumber() {
        return flightNumbers;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public String getDateAndTimeOfDeparture() {
        return dateAndTimeOfDeparture.format(formatter);
    }

    public String getDateAndTimeOfArrival() {
        return dateAndTimeOfArrival.format(formatter);
    }

    public String[] getOrigin(){
        return this.origin;
    }

    public String[] getDestination(){
        return this.destination;
    }

}
