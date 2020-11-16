package ru.sergei.komarov.med.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/checkHealth")
    public void checkHealth() {
    }
}
