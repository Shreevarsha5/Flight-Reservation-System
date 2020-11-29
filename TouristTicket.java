package com.FlightReservationSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class TouristTicket extends BookingTicket {

    private String hotelAddress;
    private ArrayList<String> selectedLocations = new ArrayList<>();

    public TouristTicket(Flight flightDetails, PassengerRegistration passengerDetails,
                         SeatMap seatMap, String location1, String location2,
                         String location3, String location4, String location5,
                         String origin, String hotelAddress){

        super(flightDetails, passengerDetails, seatMap);
        departureLocation = origin;
        destinationLocation = origin;
        this.hotelAddress = hotelAddress;
        // assert false;
        selectedLocations.addAll(Arrays.asList(location1, location2, location3,
                location4, location5));
        validateOriginAndDestination();
        typeOfTicket = "Tourist Ticket";

        if(origin.equals("Australia") || origin.equals("New Zealand") || origin.equals("Singapore"))
            flightNumber = flightDetails.getFlightNumber()[0];
        else
            flightNumber = flightDetails.getFlightNumber()[1];

    }

    public void addTouristLocation(String newLocation){
        if(selectedLocations.size() >= 5){
            System.out.println("You cannot add more than 5 locations");
        }else {
            selectedLocations.add(newLocation);
        }
    }

    public void removeTouristLocations(String location){
        selectedLocations.remove(location);
    }

    public String getDepartureLocation() {
        return super.departureLocation;
    }

    public String getDestinationLocation(){
        return super.destinationLocation;
    }

    public ArrayList<String> getSelectedLocations(){
        return selectedLocations;
    }

    public String getTypeOfTicket(){
        return typeOfTicket;
    }

    public String getHotelAddress(){
        return hotelAddress;
    }
}
