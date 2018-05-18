/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.subscribe;

//import com.pse.cines.entities.Movie;
//import com.pse.cines.entities.ShowTiming;
//import static com.pse.cines.entities.ShowTiming_.movieId;
import com.pse.portalempleog6.entities.Oferta;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Home
 */
@Named
@FlowScoped("subscribe")
public class Subscribe implements Serializable{

    
    int ofertaId;
    
    @PersistenceContext
    EntityManager em;

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    } 
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    public String getOfertaName() {
        try {
            return em.createNamedQuery("Oferta.findByIdOferta", Oferta.class).setParameter("idOferta", ofertaId).getSingleResult().getNombreOferta();
        } catch (NoResultException e) {
            return "";
        }
    }
    
    
}
