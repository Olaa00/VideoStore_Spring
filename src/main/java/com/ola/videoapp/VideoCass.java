package com.ola.videoapp;

import java.time.LocalDate;

public class VideoCass {
    private Long id;
    private String tittle;
    private LocalDate productionDate;

    public VideoCass() {
    }

    public VideoCass(Long id, String tittle, LocalDate productionYear) {
        this.id = id;
        this.tittle = tittle;
        this.productionDate = productionYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
}
