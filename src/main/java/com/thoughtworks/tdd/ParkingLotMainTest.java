package com.thoughtworks.tdd;

public class ParkingLotMainTest {
    @Test
    public void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car car = parkingBoy.fetchCar(ticket);
        //then
        Assertions.assertSame(car, car);
    }
}
