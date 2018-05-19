/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.client;

import com.pse.portalempleog6.entities.Candidaturas;
import com.pse.portalempleog6.entities.Oferta;
import com.pse.portalempleog6.entities.Users;
import com.pse.portalempleog6.jaas.LoginView;
import com.pse.portalempleog6.jaas.UserEJB;
import com.pse.portalempleog6.json.CandidacyWriter;
import com.pse.portalempleog6.json.OfertReader;
import com.pse.portalempleog6.json.OfertWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author home
 */
@Named
@RequestScoped
public class UserClientBean {
    
    Client client;
    WebTarget target;
    @Inject UserBackingBean bean;
    @Inject LoginView session;
    @Inject UserEJB ejb;
    
    
    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/portaEmpleoG6/webresources/com.pse.portalempleog6.entities.users");
   
    }
    
    @PreDestroy
    public void destroy() {
        client.close();
    }
    
    //la clase entidad se llama Oferta pero usamos variables Ofert hay que tener cuidado con eso.
    public Users[] getUsers() {
        return target.request().get(Users[].class);
    }
    
    public Users getUser() {
        Users m = target
                .path("{email}")
                .resolveTemplate("email", bean.getEmail()).request()
                .get(Users.class);
        return m;
       
//        return target.register(UserReader.class).path("{email}").resolveTemplate("email", bean.getEmail()).request(MediaType.APPLICATION_JSON).get(Users.class);
    
    }
  
      
      
    public void deleteUser() {
      target.path("{email}").resolveTemplate("email", bean.getEmail()).request().delete();
    }
    
    
    public Users getSessionUser(){
        Users user = ejb.findByEmail(ejb.getEmail());
    
        return user;
      
    }

    
    
    
    public void editUser() {
        Users o = ejb.findByEmail(ejb.getEmail());
        
        System.out.println("USUARIO"+o.toString());
        o.setApellido(bean.getApellido());
        o.setEmail(bean.getEmail());
        o.setNombre(bean.getNombre());
        o.setNumeroTarjeta(bean.getNumero_tarjeta());
        o.setNumeroTelefono(bean.numero_telefono);
        target.register(OfertWriter.class)
                .path("{email}")
                .resolveTemplate("ofertaId", bean.getEmail())
                .request()
                .put(Entity.entity(o, MediaType.APPLICATION_JSON));
    }
       
    
}
