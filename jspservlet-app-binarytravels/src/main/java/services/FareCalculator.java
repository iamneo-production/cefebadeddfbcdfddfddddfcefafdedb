package services;

import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking{
//Enter code here...
public double book(Flight flight) {

    double totalFare = booking(flight.getNoOfPersons(),flight.getRates());

    if(flight.getTriptype().equalsIgnoreCase("one-way")){
        return totalFare;
    }else{
        int comp = (flight.getFrom()).compareTo(flight.getTo());
        if(comp <= 0)
            return 2 * totalFare;
        else
            return 0;
    }
}

public double book(Bus bus) {
    return booking(bus.getNoOfPersons(),bus.getRates());
}

public double book(Hotel hotel) {
    double totalFare = 0;
    if(hotel.getFromdate().isBefore(hotel.getTodate())){
        totalFare = booking(hotel.getNoOfPersons(), hotel.getRates());
    }
    return totalFare;
}

public double book(Train train) {
    return booking(train.getNoOfPersons(),train.getRates());
}

}