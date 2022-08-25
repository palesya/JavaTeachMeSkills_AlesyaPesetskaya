package com.tms.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private boolean isActive;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean isDeleted = false;

    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
    @Version
    private long version;


    public User(String login, String password, boolean isActive, Date birthday) {
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.birthday = birthday;
    }
}
