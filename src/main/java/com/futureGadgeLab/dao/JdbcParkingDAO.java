package com.futureGadgeLab.dao;

import com.futureGadgeLab.app.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sql.error.codes.SqlErrorCodeTranslator;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * An implementation of crud methods which connect the database, with the use of a Spring JdbcTemplate.
 * Dependency Injection has been used to establish a connection between the database and the data access object.
 * Used to store and retrieve data from the database
 */

public abstract class JdbcParkingDAO implements ParkingDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        SqlErrorCodeTranslator translator = new SqlErrorCodeTranslator();
        translator.setDataSource(dataSource);
        this.jdbcTemplate.setExceptionTranslator(translator);
    }

    @Override
    public void executeStatement() {
        this.jdbcTemplate.execute("CREATE table Parking(ticketNumber integer)");
    }

    @Override
    public void createParking(int ticketNumber) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO Parking(ticketNumber, entryTime, exitTime, fee) VALUES (?, ?)", new Object[]{});
    }

    @Override
    public Parking readParking(Integer ticketNumber) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject("SELECT ticketNumber, entryTime, exitTime, fee FROM Parking WHERE ticketNumber = ?",
                new Object[]{ticketNumber}, new ParkingMapper());
    }

    @Override
    public List<Parking> readAllParkings(){
        JdbcTemplate selectAll = new JdbcTemplate(dataSource);
        return selectAll.query("SELECT ticketNumber, entryTime, exitTime, fee FROM Parking",
                new ParkingMapper());
    }

    @Override
    public int saveParking(Parking parking){
        JdbcTemplate save = new JdbcTemplate(dataSource);
        return save.update("INSERT INTO Parking WHERE ticketNumber = ?", new Object[]{});
    }

    @Override
    public int updateParking(Integer ticketNumber) {
        JdbcTemplate updated = new JdbcTemplate(dataSource);
        return updated.update("UPDATE from parking WHERE ticketNumber = ?", new Object[]{});
    }

    @Override
    public int deleteParking(Integer ticketNumber) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        return delete.update("DELETE from parking WHERE ticketNumber = ?", new Object[]{});
    }

    @Override
    public void deleteAllParking() {
        JdbcTemplate deleteAll = new JdbcTemplate(dataSource);
        deleteAll.update("DELETE from Parking");

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * An inner-class which has been used to map variables in accordance with ParkingDAO methods
     * ParkingMapper maps the resultSet to a domain object per row
     */

    public class ParkingMapper implements RowMapper<Parking> {

        public Parking mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Parking result = new Parking();
            result.setTicketNumber(resultSet.getInt("ticketNumber"));
            result.setEntryTime(resultSet.getTimestamp("entryTime"));
            result.setExitTime(resultSet.getTimestamp("exitTime"));
            result.setFee(resultSet.getBigDecimal("fee"));

            return result;
        }
    }
}