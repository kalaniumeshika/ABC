package com.example.Lab;


import org.springframework.data.annotation.Id;

public class Appointment {
    @Id
    private Integer id;
    private String patientname;
    private String labtest;
    private String Date;
    private String payment;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getLabtest() {
        return labtest;
    }

    public void setLabtest(String labtest) {
        this.labtest = labtest;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
