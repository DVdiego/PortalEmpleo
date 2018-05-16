/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.client;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author home
 */
 @Named
 @SessionScoped
public class OfertBackingBean implements Serializable{
    
    int ofertaId;
    String ofertName;
    String description;
    Date registrationDate;
    String jobVacancies;
    String minimumRequirements;
    String email;

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getOfertName() {
        return ofertName;
    }

    public void setOfertName(String ofertName) {
        this.ofertName = ofertName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    

    public String getJobVacancies() {
        return jobVacancies;
    }

    public void setJobVacancies(String jobVacancies) {
        this.jobVacancies = jobVacancies;
    }

    public String getMinimumRequirements() {
        return minimumRequirements;
    }

    public void setMinimumRequirements(String minimumRequirements) {
        this.minimumRequirements = minimumRequirements;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
