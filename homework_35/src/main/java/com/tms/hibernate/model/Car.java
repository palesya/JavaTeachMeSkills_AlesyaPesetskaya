package com.tms.hibernate.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @Enumerated(EnumType.STRING)
    private BRAND brand;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_produced")
    private Date dateProduced;
    @CreationTimestamp
    @Column(updatable = false)
    private Date created;
    @UpdateTimestamp
    private Date updated;
    private boolean available;
    @Version
    private int version;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Client client;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Region> regions;

    public Car() {
    }

    public Car(String number, BRAND brand, Date dateProduced, boolean available) {
        this.number = number;
        this.brand = brand;
        this.dateProduced = dateProduced;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BRAND getBrand() {
        return brand;
    }

    public void setBrand(BRAND brand) {
        this.brand = brand;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", brand=" + brand +
                ", dateProduced=" + dateProduced +
                ", available=" + available +
                ", regions=" + regions +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, brand, dateProduced, created, updated, available, version);
    }
}
