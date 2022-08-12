package com.tms.hibernate.web;

import com.tms.hibernate.model.Car;
import com.tms.hibernate.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping
    public String get(Model model) {
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("cars", allCars);
        List<Integer> allIds = carService.getAllIds();
        model.addAttribute("ids", allIds);
        return "car";
    }

    @PostMapping
    public String changeAvailability(
            @RequestParam(name = "selected_id") int id,
            Model model) {
        List<Integer> allIds = carService.getAllIds();
        model.addAttribute("ids", allIds);
        if (id > 0) {
            carService.changeAvailability(id);
        }
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("cars", allCars);
        return "car";
    }

    @PostMapping("/delete")
    public String deleteCar(
            @RequestParam(name = "selected_id") int id,
            Model model) {
        List<Integer> allIds = carService.getAllIds();
        model.addAttribute("ids", allIds);
        if (id > 0) {
            carService.remove(id);
        }
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("cars", allCars);
        List<Integer> allIds1 = carService.getAllIds();
        model.addAttribute("ids", allIds1);
        return "car";
    }

}
