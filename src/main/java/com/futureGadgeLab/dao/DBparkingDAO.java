package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;
import java.sql.*;
import java.util.Properties;

public class DBparkingDAO implements ParkingDAO {
    private PreparedStatement saveTicket;
    private PreparedStatement loadTicket;

    public DBparkingDAO(String url, Properties info) throws SQLException {
        Connection connect = DriverManager.getConnection(url, info);


        saveTicket = connect.prepareStatement("INSERT INTO parking (ticketNumber, entryTime, exitTime, fee)" + "VALUES (?, ?, ?, ?)");
        loadTicket = connect.prepareStatement("SELECT ticketNumber, entryTime, exitTime, fee FROM parking " + "WHERE ticketNumber  = ?");
    }

    public Parking loadParking(int ticketNumber) {
        Parking parking = new Parking();
        try {
            loadTicket.setInt(1, ticketNumber);

        ResultSet result = loadTicket.executeQuery();
        if(!result.next()) return null;

        parking.setTicketNumber(result.getInt("ticketNumber"));
        parking.setEntryTime(result.getTimestamp("entryTime"));
        parking.setExitTime(result.getTimestamp("exitTime"));
        parking.setFee(result.getFloat("fee")); }

        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
        e.printStackTrace();
    }
        return parking;
    }

    public void saveParking(Parking parking) throws SQLException {
        saveTicket.setInt(1, parking.getTicketNumber());
        saveTicket.setTimestamp(2, (Timestamp) parking.getEntryTime());
        saveTicket.setTimestamp(3, (Timestamp) parking.getExitTime());
        saveTicket.setFloat(4, parking.getFee());
    }

}