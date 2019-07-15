import com.thoughtworks.tdd.*;
import com.thoughtworks.tdd.exception.TicketMissingException;
import com.thoughtworks.tdd.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParkingLotMainTest {

    private ParkingLot parkingLot = new ParkingLot();
    private SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    private SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

    @Test
    public void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, car);
    }

    @Test
    public void should_return_tickets_when_paring_car_given_multiple_car() {
        //given
        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket ticket1 = parkingBoy.parkingCar(car);
        Ticket ticket2 = parkingBoy.parkingCar(benz);
        Ticket ticket3 = parkingBoy.parkingCar(honda);
        //when
        Car fetchCar1 = parkingBoy.fetchCar(ticket1);
        Car fetchCar2 = parkingBoy.fetchCar(ticket2);
        Car fetchCar3 = parkingBoy.fetchCar(ticket3);
        //then
        Assertions.assertSame(car, fetchCar1);
        Assertions.assertSame(benz, fetchCar2);
        Assertions.assertSame(honda, fetchCar3);
    }

    @Test
    public void should_throw_unrecognized_ticket_exception_when_fetch_car_given_wrong_ticket() {
        //given
        Car benz = new Car("benz","no2");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket fakeTicket = new Ticket();
        //then
        Assertions.assertThrows(UnrecognizedTicketException.class, ()-> parkingBoy.fetchCar(fakeTicket));
    }

    @Test
    public void should_throw_unrecognized_exception_when_fetch_car_given_tickets_used() {
        //given
        Car benz = new Car("benz","no1");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket ticket = parkingBoy.parkingCar(benz);
        //when
        Car fetchCar1 = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertThrows(UnrecognizedTicketException.class, ()-> parkingBoy.fetchCar(ticket));
    }

    @Test
    public void should_throw_parkinglot_full_exception_when_no_position_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingBoy.addParkingLot(parkingLot2);
        Car honda = new Car("honda", "no2");
        parkingBoy.parkingCar(honda);
        //when
        Car benz = new Car("benz", "no1");
        Ticket ticket = parkingBoy.parkingCar(benz);
        String message = parkingBoy.showMessage();
        //then
        Assertions.assertSame("", message);
    }

    @Test
    public void should_throw_ticket_missing_exception_when_fetch_car_given_no_ticket() {
        //given
        Car benz = new Car("benz","no2");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket fakeTicket = null;
        //then
        Assertions.assertThrows(TicketMissingException.class, ()-> parkingBoy.fetchCar(fakeTicket));
    }

    @Test
    public void should_parking_car_to_first_parkingLot_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);

        Car car = new Car("car","no1");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertSame(parkingLot, ticket.getParkingLot());
    }

    @Test
    public void should_parking_car_to_next_parkingLot_when_first_parkingLot_is_full_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);

        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        Ticket ticket2 = parkingBoy.parkingCar(benz);
        Ticket ticket3 = parkingBoy.parkingCar(honda);
        //then
        Assertions.assertSame(parkingLot2, ticket2.getParkingLot());
        Assertions.assertSame(parkingLot2, ticket3.getParkingLot());
    }

    @Test
    public void should_park_and_fetch_car_to_more_empty_lot_when_parked_by_smart_parkingBoy() {
        //given
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot2 = new ParkingLot(4);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car("car","no1");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        ParkingLot parkedLot = ticket.getParkingLot();
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(parkingLot2, parkedLot);
        Assertions.assertSame(car, fetchCar);
    }


    @Test
    public void should_park_car_to_larger_available_position_rate_lot() {
        //given
        ParkingLot parkingLot2 = new ParkingLot(3);
        superSmartParkingBoy.addParkingLot(parkingLot);
        superSmartParkingBoy.addParkingLot(parkingLot2);
        //when
        Car car = new Car("car","no1");
        Ticket ticket = superSmartParkingBoy.parkingCar(car);
        ParkingLot parkingLotActual = ticket.getParkingLot();
        //then
        Assertions.assertSame(parkingLot, parkingLotActual);
    }

    @Test
    public void should_return_car_from_larger_available_position_rate_lot() {
        //given
        ParkingLot parkingLot2 = new ParkingLot(3);
        superSmartParkingBoy.addParkingLot(parkingLot);
        superSmartParkingBoy.addParkingLot(parkingLot2);
        //when
        Car car = new Car("car","no1");
        Ticket ticket = superSmartParkingBoy.parkingCar(car);
        Car fetchCar = superSmartParkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }



    @Test
    public void should_park_and_fetch_car_when_manage_specify_parkingBoy() {

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        smartParkingBoy.addParkingLot(parkingLot);
        parkingLotManager.addParkingBoy(smartParkingBoy);

        Car car = new Car("car", "no1");
        Ticket ticket = parkingLotManager.parkingCar(car);
        Car fetchCar = smartParkingBoy.fetchCar(ticket);

        Assertions.assertSame(car, fetchCar);
    }

    @Test
    public void should_park_and_fetch_car_when_no_parking_boy() {
        //given
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        Car car = new Car("car", "no1");
        Ticket ticket = parkingLotManager.parkingCar(car);
        //when
        Car fetchCar = parkingLotManager.fetchCar(ticket);
        //then
        Assertions.assertSame(car, fetchCar);
    }

//    @Test
//    public void should_return_null_when_manage_fetch_car_given_wrong_ticket() {
//        //given
//        ParkingLotManager parkingLotManager = new ParkingLotManager();
//        parkingLotManager.addParkingBoy(smartParkingBoy);
//        smartParkingBoy.addParkingLot(parkingLot);
//        List<Boy> parkingBoys = parkingLotManager.getParkingBoyList();
//        Ticket fakeTicket = null;
//        //when
//        Car fetchCar = null;
//        String message = null;
//        for (Boy boy : parkingBoys) {
//            fetchCar = boy.fetchCar(fakeTicket);
//            message = boy.showMessage();
//        }
//        //then
//        Assertions.assertSame(null, fetchCar);
//        Assertions.assertSame("Please provide your parking ticket.", message);
//    }
//
//    @Test
//    public void should_return_null_when_manage_fetch_car_given_used_tickets() {
//        //given
//        ParkingLotManager parkingLotManager = new ParkingLotManager();
//        parkingLotManager.addParkingBoy(smartParkingBoy);
//        smartParkingBoy.addParkingLot(parkingLot);
//        List<Boy> parkingBoys = parkingLotManager.getParkingBoyList();
//        Car car = new Car("BMW", "123456");
//        SmartParkingBoy parkingBoy = (SmartParkingBoy) parkingBoys.get(0);
//        Ticket ticket = parkingBoy.parkingCar(car);
//        //when
//        Car fetchCar = parkingBoy.fetchCar(ticket);
//        Car fetchCarAgain = parkingBoy.fetchCar(ticket);
//        String message = parkingBoy.showMessage();
//        //then
//        Assertions.assertSame(null, fetchCarAgain);
//        Assertions.assertSame("Unrecognized parking ticket.", message);
//    }
}
