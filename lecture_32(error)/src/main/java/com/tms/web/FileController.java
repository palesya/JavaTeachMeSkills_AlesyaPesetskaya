package com.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {

    @PostMapping
    public String get(@RequestParam("file")MultipartFile file, Model model) throws IOException {
        byte[] bytes = file.getInputStream().readAllBytes();
        model.addAttribute("file",bytes);
       return "redirect:/user";
    }
}
