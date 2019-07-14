package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void should_return_no_car_when_fetch_car_given_wrong_ticket() {
        //given
        Car benz = new Car("benz","no2");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket fakeTicket = new Ticket();
        //when
        Car fetchCar = parkingBoy.fetchCar(fakeTicket);
        //then
        Assertions.assertSame(null, fetchCar);
    }

    @Test
    public void should_return_no_car_when_fetch_car_given_tickets_used() {
        //given
        Car benz = new Car("benz","no1");
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Ticket ticket = parkingBoy.parkingCar(benz);
        //when
        Car fetchCar1 = parkingBoy.fetchCar(ticket);
        Car fetchCar2 = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(benz, fetchCar1);
        Assertions.assertSame(null, fetchCar2);
    }

    @Test
    public void should_return_null_when_no_position_given_car() {
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
    public void should_parking_car_to_next_parkingLot_when_first_parkingLot_no_position_given_car() {
        //given
        StupidBoy parkingBoy = new StupidBoy();
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);

        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        Ticket ticket2 = parkingBoy.parkingCar(benz);
        Ticket ticket3 = parkingBoy.parkingCar(honda);

        Car fetchCar = parkingBoy.fetchCar(ticket2);
        //then
        Assertions.assertSame(null, ticket3);
        Assertions.assertSame(benz, fetchCar);
    }

    @Test
    public void should_return_ticket_when_stupidparkingBoy_given_car() {
        //given
        StupidBoy parkingBoy = new StupidBoy();
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);

        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        Car fetchCar = parkingBoy.fetchCar(ticket);
        Ticket ticket2 = parkingBoy.parkingCar(benz);
        Ticket ticket3 = parkingBoy.parkingCar(honda);

        Car fetchCar2 = parkingBoy.fetchCar(ticket2);
        Car fetchCar3 = parkingBoy.fetchCar(ticket3);
        //then
        Assertions.assertSame(benz, fetchCar2);
        Assertions.assertSame(honda, fetchCar3);
    }

    @Test
    public void should_return_ticket_when_super_smart_parkingBoy_given_car() {
        //given
        StupidBoy parkingBoy = new StupidBoy();
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);

        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        Car fetchCar = parkingBoy.fetchCar(ticket);
        Ticket ticket2 = parkingBoy.parkingCar(benz);
        Ticket ticket3 = parkingBoy.parkingCar(honda);

        Car fetchCar2 = parkingBoy.fetchCar(ticket2);
        Car fetchCar3 = parkingBoy.fetchCar(ticket3);
        //then
        Assertions.assertSame(benz, fetchCar2);
        Assertions.assertSame(honda, fetchCar3);
    }

    @Test
    public void should_park_to_multiple_lot_when_smart_parkingBoy_given_car() {
        //given
        ParkingLot parkingLot2 = new ParkingLot(2);
        smartParkingBoy.addParkingLot(parkingLot);
        smartParkingBoy.addParkingLot(parkingLot2);
        //when
        Car car = new Car("car","no1");
        Ticket ticket = smartParkingBoy.parkingCar(car);
        ParkingLot parkingLotActual = ticket.getParkingLot();
        //then
        Assertions.assertSame(parkingLot2, parkingLotActual);
    }

    @Test
    public void should_park_to_larger_available_position_rate_when_smart_parkingBoy_given_car() {
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
}
