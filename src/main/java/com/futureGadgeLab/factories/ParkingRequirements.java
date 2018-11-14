package com.futureGadgeLab.factories;

import com.futureGadgeLab.app.Parking;

import java.math.BigDecimal;

public class ParkingRequirements {
    Parking parking;

    public int getTicketId() {
        return parking.getTicketNumber();
    }

    public BigDecimal getFee() {
        return parking.getFee();
    }

}
