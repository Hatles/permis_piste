package com.polytech.permis_piste.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("menu")
    public String menu() {
        return "includes/navigation/navigation";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
