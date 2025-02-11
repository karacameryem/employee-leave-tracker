package com.company.employeetracker.controller;

import com.company.employeetracker.model.Employee;
import com.company.employeetracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Çalışan Ekleme (POST)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Çalışanları Listeleme (GET)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
 // Çalışanın izin günlerini azaltma (POST /leave)
    @PostMapping("/leave")
    public String requestLeave(@RequestParam Long employeeId, @RequestParam int days) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        
        if (employee == null) {
            return "Çalışan bulunamadı!";
        }

        if (employee.getLeaveDays() < days) {
            return "Yetersiz izin günü!";
        }

        employee.setLeaveDays(employee.getLeaveDays() - days);
        employeeRepository.save(employee);
        
        return "İzin başarıyla güncellendi! Kalan izin günleri: " + employee.getLeaveDays();
    }

}

