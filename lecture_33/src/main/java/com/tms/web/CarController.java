package com.tms.web;


import com.tms.object.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final JdbcTemplate template;
    private final RowMapper<Car> mapper;

    @GetMapping
    public String create(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "age",required = false) Integer age, Model model) {
        //template.update("insert into cars (name, age) values(?,?)", name, age);
        List<Car> cars = template.query("select * from cars", mapper);
        //List<Car> cars = template.query("select * from cars where name=?", mapper,name);
        template.queryForList("select * from cars");
        model.addAttribute("cars",cars);
        return "cars";
    }
}
