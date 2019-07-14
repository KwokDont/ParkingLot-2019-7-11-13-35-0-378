package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotMainTest {

    private ParkingLot parkingLot = new ParkingLot();

    @Test
    public void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkingCar(parkingLot,car);
        //when
        Car fetchCar = parkingBoy.fetchCar(parkingLot,ticket);
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
        Ticket ticket1 = parkingBoy.parkingCar(parkingLot, car);
        Ticket ticket2 = parkingBoy.parkingCar(parkingLot, benz);
        Ticket ticket3 = parkingBoy.parkingCar(parkingLot, honda);
        //when
        Car fetchCar1 = parkingBoy.fetchCar(parkingLot, ticket1);
        Car fetchCar2 = parkingBoy.fetchCar(parkingLot, ticket2);
        Car fetchCar3 = parkingBoy.fetchCar(parkingLot, ticket3);
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
        Ticket fakeTicket = new Ticket();
        //when
        Car fetchCar = parkingBoy.fetchCar(parkingLot, fakeTicket);
        //then
        Assertions.assertSame(null, fetchCar);
    }

    @Test
    public void should_return_no_car_when_fetch_car_given_tickets_used() {
        //given
        Car benz = new Car("benz","no1");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkingCar(parkingLot, benz);
        //when
        Car fetchCar1 = parkingBoy.fetchCar(parkingLot, ticket);
        Car fetchCar2 = parkingBoy.fetchCar(parkingLot, ticket);
        //then
        Assertions.assertSame(benz, fetchCar1);
        Assertions.assertSame(null, fetchCar2);
    }

    @Test
    public void should_return_null_when_no_position_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car honda = new Car("honda", "no2");
        parkingBoy.parkingCar(parkingLot, honda);
        //when
        Car benz = new Car("benz", "no1");
        Ticket ticket = parkingBoy.parkingCar(parkingLot, benz);
        //then
        Assertions.assertSame(null, ticket);
    }
}
