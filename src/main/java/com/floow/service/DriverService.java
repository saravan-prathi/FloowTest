package com.floow.service;

import com.floow.model.Driver;
import org.springframework.stereotype.Service;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    public void saveDriver(Driver driver) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("drivers.txt", true));
            writer.append(new Driver(driver.getFirstName(), driver.getLastName(), driver.getDateOfBirth()).toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public List<Driver> fetchDrivers() throws IOException {
        List<Driver> driverList = new ArrayList<>();
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("drivers.txt"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                driverList.add(new Driver(Integer.parseInt(values[0]), values[1], values[2], LocalDate.parse(values[3], formatter), LocalDate.parse(values[4], formatter)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return driverList;
    }

    public List<Driver> fetchDriversByDate(String dateParam) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromDate = LocalDate.parse(dateParam, formatter);
        List<Driver> driverListFromDate = fetchDrivers().stream().filter(driver -> driver.getCreationDate().compareTo(fromDate) >= 0).collect(Collectors.toList());
        return driverListFromDate;
    }
}
