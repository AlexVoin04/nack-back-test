package com.natk.test_natk_admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/status")
    public String status() {
        return "Admin service is running";
    }
}
