package edu.mum.cs425.HEARairticket.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;

@Entity
public class Schuedule {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  long id;

    public Schuedule() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivaleaDate(LocalDate arrivaleaDate) {
        this.arrivaleaDate = arrivaleaDate;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivaleTime(Time arrivaleTime) {
        this.arrivaleTime = arrivaleTime;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArriavaleAirport(String arriavaleAirport) {
        this.arriavaleAirport = arriavaleAirport;
    }

    private LocalDate departureDate;

    public long getId() {
        return id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivaleaDate() {
        return arrivaleaDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivaleTime() {
        return arrivaleTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArriavaleAirport() {
        return arriavaleAirport;
    }

    private LocalDate arrivaleaDate;
    private Time departureTime;
    private Time arrivaleTime;
    private   String  departureAirport;

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    private  String  arriavaleAirport;
    private  float  price;

    public Schuedule(LocalDate departureDate, LocalDate arrivaleaDate, Time departureTime, Time arrivaleTime, String departureAirport, String arriavaleAirport, float price) {
        this.departureDate = departureDate;
        this.arrivaleaDate = arrivaleaDate;
        this.departureTime = departureTime;
        this.arrivaleTime = arrivaleTime;
        this.departureAirport = departureAirport;
        this.arriavaleAirport = arriavaleAirport;
        this.price = price;
    }


}
