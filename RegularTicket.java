package com.FlightReservationSystem;

public class RegularTicket extends BookingTicket {


    private static class SpecialServiceRequest{

        boolean isFoodRequested, isWaterRequested, areSnacksRequested;

        public SpecialServiceRequest(boolean isFoodRequested, boolean isWaterRequested, boolean areSnacksRequested) {
            this.isFoodRequested = isFoodRequested;
            this.isWaterRequested = isWaterRequested;
            this.areSnacksRequested = areSnacksRequested;
        }
    }

    private SpecialServiceRequest specialServices;

    public RegularTicket(Flight flightDetails, PassengerRegistration passengerDetails,
                         SeatMap seatMap, String departureLocation, String destinationLocation,
                         boolean food, boolean water, boolean snacks) {
        super(flightDetails, passengerDetails, seatMap);
        super.departureLocation = departureLocation;
        super.destinationLocation = destinationLocation;
        specialServices = new SpecialServiceRequest(food, water, snacks);
        validateOriginAndDestination();
        typeOfTicket = "Regular Ticket";

        if(departureLocation.equals("Australia") || departureLocation.equals("New Zealand") || departureLocation.equals("Singapore"))
            super.flightNumber = flightDetails.getFlightNumber()[0];
        else
            super.flightNumber = flightDetails.getFlightNumber()[1];
    }

    public String getDepartureLocation(){
        return super.departureLocation;
    }

    public String getDestinationLocation(){
        return super.destinationLocation;
    }

    public String getTypeOfTicket(){
        return typeOfTicket;
    }

}

