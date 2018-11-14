package com.futureGadgeLab.app;
import java.math.BigDecimal;
import java.util.Date;

public class Parking {
    private int ticketNumber;
    private Date entryTime, exitTime;
    private BigDecimal fee;

    /**
     * Used to establish attributes within a row in the Parking table
     */

    public Parking() {
    }

    public Parking(int ticketNumber, Date entryTime, Date exitTime, BigDecimal fee){
        this.ticketNumber = ticketNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public int getTicketNumber(){
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNumber){
        this.ticketNumber = ticketNumber;
    }

    public Date getEntryTime(){
        return entryTime;
    }
    public void setEntryTime(Date entryTime){
        this.entryTime = entryTime;
    }

    public Date getExitTime(){
        return exitTime;
    }
    public void setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }

    public BigDecimal getFee(){
        return fee;
    }
    public void setFee(BigDecimal fee){
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("Parking" + "\nTicketNumber: " + ticketNumber + "\nEntry Time:" + entryTime + "\nExit Time: " + exitTime + "\nFee" + fee);
    }
}
