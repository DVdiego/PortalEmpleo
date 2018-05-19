/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.jaas;

import com.pse.portalempleog6.entities.UserGroups;
import com.pse.portalempleog6.entities.Users;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Home
 */
@Stateless
public class UserEJB {
    
    @PersistenceContext
    private EntityManager em;
    String email;
    Users user;
    
    public Users createUser(Users user, String groupName) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserGroups group = new UserGroups();
        group.setEmail(user.getEmail());
        group.setGroupname(groupName);
        em.persist(user);
        em.persist(group);
        return user;
    }
    
    
    public Users findByEmail(String email) {
        TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
        query.setParameter("email", email);
        Users user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
        }
        return user;
    }

    public String getEmail() {
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
 
    
    
}
