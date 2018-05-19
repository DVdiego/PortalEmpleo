/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.client;

import com.pse.portalempleog6.entities.Candidaturas;
import com.pse.portalempleog6.entities.Oferta;
import com.pse.portalempleog6.entities.Users;
import com.pse.portalempleog6.jaas.UserEJB;
import com.pse.portalempleog6.json.CandidacyWriter;
import com.pse.portalempleog6.json.OfertReader;
import com.pse.portalempleog6.json.OfertWriter;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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
public class OfertClientBean {
    
    Client client;
    WebTarget target;
    @Inject OfertBackingBean bean;
    @Inject UserEJB ejb;


    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/portaEmpleoG6/webresources/com.pse.portalempleog6.entities.oferta");
   
    }
    @PreDestroy
    public void destroy() {
        client.close();
    }
    
    //la clase entidad se llama Oferta pero usamos variables Ofert hay que tener cuidado con eso.
    public Oferta[] getOferts() {
        return target.request().get(Oferta[].class);
    }
    
  
    public Oferta getOfert() {
        /*Oferta m = target
                .path("{ofertaId}")
                .resolveTemplate("ofertaId", bean.getOfertaId()).request()
                .get(Oferta.class);
        return m;
       */
        return target.register(OfertReader.class).path("{ofertaId}").resolveTemplate("ofertaId", bean.getOfertaId()) .request(MediaType.APPLICATION_JSON) .get(Oferta.class);
    
    }
      
      
    public void deleteOfert() {
      target.path("{ofertaId}").resolveTemplate("ofertaId", bean.getOfertaId()).request().delete();
    }
    
    public void addOfert() {

        Oferta o = new Oferta();       
        o.setNombreOferta(bean.getOfertName());
        o.setDescripcion(bean.getDescription());
        o.setFechaIncorporacion(bean.getRegistrationDate());
        o.setPuestoTrabajo(bean.getJobVacancies());
        o.setRequisitosMinimos(bean.getMinimumRequirements());
        o.setEmail(bean.getEmail());
        o.setIdOferta(bean.getOfertaId());
        target.register(OfertWriter.class)
                .request()
                .post(Entity.entity(o, MediaType.APPLICATION_JSON));
        
    }
    
    
    
       public void editOfert() {
        Oferta o = new Oferta();
        
        o.setNombreOferta(bean.getOfertName());
        o.setDescripcion(bean.getDescription());
        o.setFechaIncorporacion(bean.getRegistrationDate());
        o.setPuestoTrabajo(bean.getJobVacancies());
        o.setRequisitosMinimos(bean.getMinimumRequirements());
        o.setEmail(bean.getEmail());
        o.setIdOferta(bean.getOfertaId());
        target.register(OfertWriter.class)
                .path("{ofertaId}")
                .resolveTemplate("ofertaId", bean.getOfertaId())
                .request()
                .put(Entity.entity(o, MediaType.APPLICATION_JSON));
    }
       
    public void subscribeOfert() {
    Candidaturas c = new Candidaturas();
        c.setIdCandidatura(bean.ofertaId);
        c.setIdOferta(bean.ofertaId);
        c.setEmail(bean.getEmail());
        target.register(CandidacyWriter.class)
                .request()
                .post(Entity.entity(c, MediaType.APPLICATION_JSON));
    }
    
       public Users getSessionUser(){
        Users user = ejb.findByEmail(ejb.getEmail());
    
        return user;
      
    }
       
       
      
}
