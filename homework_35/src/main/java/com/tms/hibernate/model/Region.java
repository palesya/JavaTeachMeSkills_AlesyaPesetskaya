package com.tms.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private REGION_NAME name;
    @ManyToMany(mappedBy = "regions")
    private List<Car> cars;

    public Region(REGION_NAME name) {
        this.name = name;
    }

    public Region() {

    }

    public REGION_NAME getName() {
        return name;
    }

    public void setName(REGION_NAME name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name=" + name +
                '}';
    }
}
