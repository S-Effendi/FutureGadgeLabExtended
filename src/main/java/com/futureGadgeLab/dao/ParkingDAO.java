package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;

import java.sql.SQLException;

public interface ParkingDAO {

    public void saveParking(Parking parking) throws SQLException;
    public Parking loadParking(int ticketNumber);
}
