package com.FlightReservationSystem;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

//        Departure Date and Time of Flight
        LocalDateTime departureDateAndTime1 = LocalDateTime.of(2021, 1, 12, 10, 35);

        LocalDateTime departureDateAndTime2 = LocalDateTime.of(2021, 1, 24, 18, 5);


//        Departure Date and Time of Flight
        LocalDateTime arrivalDateAndTime1 = LocalDateTime.of(2021, 1, 12, 12, 50);

        LocalDateTime arrivalDateAndTime2 = LocalDateTime.of(2021, 1, 30, 5, 20);


//        Flight Available Locations
//        These are used for Tourist locations also
        String[] locations = {"India", "Australia", "New Zealand", "Andaman and Nicobar Islands", "Singapore", "Switzerland"};

//        Flight Numbers
        int[] flightNumbers = {1001, 1002};

//        Setting the Flight constructor
        Flight flight1 = new Flight(2, flightNumbers, locations, departureDateAndTime1, locations, arrivalDateAndTime1);

        Flight flight2 = new Flight(2, flightNumbers, locations, departureDateAndTime2, locations, arrivalDateAndTime2);

//        Setting the SeatMap constructor with Number of Seats
//        Number of Seats should be at least 10
//        Number of Seats are divided into Rows and Columns
//        Number of Seats = Number of Rows * Number of Columns
//        For every one Column there are 10 Rows
        SeatMap seatMap1 = new SeatMap(50);

        SeatMap seatMap2 = new SeatMap(100);

//        Setting the Passenger constructor with Passenger details
        PassengerRegistration passenger1 = new PassengerRegistration("Periyar Street", "Chennai",
                "Tamil Nadu", "Ladeela Sai Arjun", "8639953455",
                "saiarjun@gmail.com", 10000);

        PassengerRegistration passenger2 = new PassengerRegistration("A.P.H.B. Colony", "Anantapur",
                "Andhra Pradesh", "Chinna", "9491369257",
                "chinna@gmail.com", 25000);

//        Prints Passenger Details
        printPassengerDetails(passenger1);
//        System.out.println();
//        printPassengerDetails(passenger2);

//        Prints Passenger Wallet Amount
//        Passenger Wallet Amount is provided in Passenger constructor
        printWalletAmount(passenger1);
//        printWalletAmount(passenger2);

//        This method books a Regular Ticket and displays the Ticket details in the output
        generateRegularTicket(flight1, passenger1, seatMap1);
//        System.out.println();
//        This method books a Tourist Ticket and displays the Ticket details in the output
//        generateTouristTicket(flight2, passenger2, seatMap2);

//        printTicketDetails(bookRegularTicket(flight, passenger,seatMap));
        printWalletAmount(passenger1);
//        printWalletAmount(passenger2);
    }

    public static void printTicketDetails(BookingTicket ticket){
//        A Random 6 digit PNR Number is printed for the Ticket booked (I made it to generate randomly)
        System.out.println("PNR Number is: " + ticket.getPNRNumber());
    }

    public static void printPassengerDetails(PassengerRegistration passenger){

        System.out.println("\nYour Contact Details: " + passenger.getContactDetails() + "\n");
        System.out.println("Your Address Details: " + passenger.getAddressDetails() + "\n");
        System.out.println("Number of Passengers: " + passenger.getPassengerCount() + "\n");

    }

    public static void printWalletAmount(PassengerRegistration passenger){
        System.out.println("Your Wallet Amount: ₹ " + passenger.checkDue());
    }

    public static void printRegularTicketDetails(RegularTicket ticket){

        if(ticket.getClass().getSimpleName().equals("RegularTicket")){
            System.out.print("Your Ticket from " + ticket.getDepartureLocation());
            System.out.println(" to " + ticket.getDestinationLocation() + " is " + ticket.getStatus() + "\n");
            System.out.println("Ticket Type: " + ticket.getTypeOfTicket() + "\n");
            System.out.println("Flight Number: " + ticket.getFlightNumber());
            System.out.print("Departure Date & Time: " + ticket.getDateAndTimeOfDeparture());
            System.out.println("\t\tArrival Date & Time: " + ticket.getDateAndTimeOfArrival());
            System.out.println("Duration of Journey: " + ticket.getDuration() + "\n");
            System.out.println("PNR Number: " + ticket.getPNRNumber());
            System.out.println("Your Seat: " + ticket.getSeatNumber());
//            Ticket Price is generated randomly (I made it random)
            System.out.println("Ticket Status: " + ticket.getStatus());
            System.out.println("Ticket Price: ₹ " + ticket.getTicketPrice());
            System.out.println("\n**********HAPPY JOURNEY**********\n");
        }

    }

    public static void printTouristTicketDetails(TouristTicket ticket){

        if(ticket.getClass().getSimpleName().equals("TouristTicket")){
            System.out.println("Your Tourist Ticket from " + ticket.getDestinationLocation() + " is " + ticket.getStatus());
            System.out.println("Ticket Type: " + ticket.getTypeOfTicket() + "\n");
            System.out.println("Flight Number: " + ticket.getFlightNumber());
            System.out.print("Departure Date & Time: " + ticket.getDateAndTimeOfDeparture());
            System.out.println("\nYour Selected Locations are: ");
            for(String location:ticket.getSelectedLocations())
                System.out.println(location);
            System.out.println("\nHotel Address: " + ticket.getHotelAddress());
            System.out.println("\nPNR Number: " + ticket.getPNRNumber());
            System.out.println("Your Seat Number is: " + ticket.getSeatNumber());
            System.out.println("Ticket Status: " + ticket.getStatus());
//            Ticket Price is generated randomly (Rs.2000 to Rs.5000) (I made it random)
            System.out.println("Ticket Price: ₹ " + ticket.getTicketPrice());
            System.out.println("\n**********HAPPY JOURNEY**********");
        }
    }

    public static RegularTicket bookRegularTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        return  new RegularTicket(flight, passenger, seatMap,"Australia", "New Zealand",
                true, true, true);

    }

    public static TouristTicket bookTouristTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        return new TouristTicket(flight, passenger, seatMap, "Australia", "Thailand", "Andaman and Nicobar Islands",
                "Singapore", "Switzerland", "India", "Country street, Country");
    }

    public static void cancelTicket(BookingTicket ticket){
        ticket.cancelTicket();
        System.out.println("YOUR " + ticket.getTypeOfTicket().toUpperCase() + " HAS BEEN "+ ticket.getStatus() +"!!!!");
    }

    public static void generateRegularTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        if(seatMap.getAvailableSeats() > 0) {
            RegularTicket bookingTicket1 = bookRegularTicket(flight, passenger, seatMap);
            printRegularTicketDetails(bookingTicket1);
        }
        else
            System.out.println("Seats are not available!!!!");

    }

    public static void generateTouristTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        if(seatMap.getAvailableSeats() > 0) {
            TouristTicket bookingTicket2 = bookTouristTicket(flight, passenger, seatMap);
            printTouristTicketDetails(bookingTicket2);
        }
        else
            System.out.println("Seats are not available!!!!");

    }
}

