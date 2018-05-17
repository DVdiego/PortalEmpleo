/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.jaas;

import com.pse.portalempleog6.entities.Users;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;

/**
 *
 * @author Home
 */
@SessionScoped
@ManagedBean
public class RegisterView implements Serializable{
    
    private String name;
    private String lastName;
    private String birthDate;
    private String cardNumber;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;

private static Logger log = Logger.getLogger(RegisterView.class.getName());

@Inject
    private UserEJB userEJB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        RegisterView.log = log;
    }

    public UserEJB getUserEJB() {
        return userEJB;
    }

    public void setUserEJB(UserEJB userEJB) {
        this.userEJB = userEJB;
    }

    
    
    public void validatePassword(ComponentSystemEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent();
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
        String password = uiInputPassword.getLocalValue() == null ? "" : uiInputPassword.getLocalValue().toString();
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmpassword");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();
        // Que required="true" se encargue de esto.
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }
        if (!password.equals(confirmPassword)) {
            FacesMessage msg = new FacesMessage("Las contraseñas no coinciden");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(uiInputPassword.getClientId(), msg);
            facesContext.renderResponse();
        }

        UIInput uiInputEmail = (UIInput) components.findComponent("email");
        String email = uiInputEmail.getLocalValue() == null ? "" : uiInputEmail.getLocalValue().toString();

        if (userEJB.findByEmail(email) != null) {
            FacesMessage msg = new FacesMessage("Ya existe un usuario con ese email");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(uiInputPassword.getClientId(), msg);
            facesContext.renderResponse();
        }
    }
    
        public String register() {
            
            Date fecha = null;
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            
            try{
                fecha = ft.parse(birthDate);
            } catch (ParseException ex){
                
            }
           
        Users user = new Users(email, password, name, lastName, fecha, cardNumber, phoneNumber);
        userEJB.createUser(user);
        log.info("Nuevo usuario creado con e-mail: " + email + " y nombre: " + name);
        return "newTemplateClient";
    }



}
