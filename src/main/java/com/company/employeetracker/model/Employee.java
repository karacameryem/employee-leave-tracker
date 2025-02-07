package com.company.employeetracker.model;

import jakarta.persistence.*;

@Entity // Bu sınıfı veritabanı tablosu olarak belirtiyoruz
@Table(name = "employees") // Veritabanındaki tablo adı
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int leaveDays = 15; // Varsayılan 15 izin günü

    // Getter ve Setter metotları
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getLeaveDays() { return leaveDays; }
    public void setLeaveDays(int leaveDays) { this.leaveDays = leaveDays; }
}