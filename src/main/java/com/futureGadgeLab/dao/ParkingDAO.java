package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;

import java.util.List;

/**
 * This defines the methods which be used to interact with the database access objectsS
 */

public interface ParkingDAO {

    public void executeStatement();
    public void createParking(int ticketNumber);
    public Parking readParking(Integer ticketNumber);
    public List<Parking> readAllParkings();
    public int saveParking(Parking parking);
    public int updateParking(Integer ticketNumber);
    public int deleteParking(Integer ticketNumber);
    public void deleteAllParking();
}
