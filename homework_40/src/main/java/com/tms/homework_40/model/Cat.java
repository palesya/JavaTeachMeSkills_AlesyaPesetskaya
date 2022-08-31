package com.tms.homework_40.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private Integer age;

    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
    @Version
    private long version;

    public Cat(String name, String breed, Integer age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
}
