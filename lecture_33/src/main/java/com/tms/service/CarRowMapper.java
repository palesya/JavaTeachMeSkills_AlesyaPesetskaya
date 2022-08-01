package com.tms.service;

import com.tms.object.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getObject("id",Integer.class);
        String name = rs.getString("name");
        Integer age = rs.getObject("age",Integer.class);
        return new Car(id,name,age);
    }
}
