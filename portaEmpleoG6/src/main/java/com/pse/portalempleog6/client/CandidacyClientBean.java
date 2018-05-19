/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.client;

import com.pse.portalempleog6.entities.Candidaturas;
import com.pse.portalempleog6.json.CandidacyWriter;
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
public class CandidacyClientBean {
    
    
    Client client;
    WebTarget target;
    @Inject CandidacyBackingBean bean;
    
    FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    OfertBackingBean nB =(OfertBackingBean) session.getAttribute("ofertBackingBean");

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/portaEmpleoG6/webresources/com.pse.portalempleog6.entities.candidaturas");
   
    }
    @PreDestroy
    public void destroy() {
        client.close();
    }
    
    public void unsubscribeOfert() {
    target.path("{candidacyId}").resolveTemplate("candidacyId", bean.getOfertaId()).request().delete();
    }
    
    
    public void subscribeOfert() {
    Candidaturas c = new Candidaturas();
              
        c.setIdOferta(nB.getOfertaId());
        c.setEmail(nB.getEmail());
        target.register(CandidacyWriter.class)
                .request()
                .post(Entity.entity(c, MediaType.APPLICATION_JSON));
    }
    
}
