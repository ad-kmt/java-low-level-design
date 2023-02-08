package org.kmt.design_problems.parkinglot.model.vehicle;

import org.kmt.design_problems.parkinglot.model.parkinglot.ParkingSpotType;

public class Car extends Vehicle{
    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.LMV;
    }
}
