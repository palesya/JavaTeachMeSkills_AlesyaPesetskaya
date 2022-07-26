package com.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/car")
public class CarController {

    @GetMapping(path = "/{type}/{color}")
    public ModelAndView car(
            @PathVariable(name = "type") String carType,
            @PathVariable(name = "color") String color,
            @CookieValue(value = "JSESSIONID",required = false) String sessionID,
            @RequestParam(value = "id",required = false) String id,
            ModelAndView modelAndView){
        modelAndView.setViewName("car");
        modelAndView.addObject("name","AUDI");
        return modelAndView;
    }
}
