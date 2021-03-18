package com.floow.controller;

import com.floow.model.Driver;
import com.floow.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/driver/create")
    public void createDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        List<Driver> driverList = null;
        try {
            driverList = driverService.fetchDrivers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driverList;
    }

    @GetMapping("/drivers/byDate")
    public List<Driver> getDriversByDate(@RequestParam(name = "date") String dateParam) {
        List<Driver> driverList = null;
        try {
            driverList = driverService.fetchDriversByDate(dateParam);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driverList;
    }
}
