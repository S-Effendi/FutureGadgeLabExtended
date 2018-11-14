package com.futureGadgeLab;
import com.futureGadgeLab.app.Parking;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Parking parking = (Parking) context.getBean("parking");
        parking.toString();
    }
}
