package com.tms.bootdatajpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@NamedQuery(query = "select u from User u where u.isActive=true",name = "User.getOnlyActive")
public class User {

    @Id
    private Long id;

    private String login;
    private String password;
    boolean isActive;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Builder.Default
    private boolean isDeleted = false;

    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
    @Version
    private long version;


}
