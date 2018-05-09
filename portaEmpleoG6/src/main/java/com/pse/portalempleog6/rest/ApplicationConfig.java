/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.rest;

import java.util.Set;
import javax.inject.Named;
import javax.ws.rs.core.Application;

/**
 *
 * @author Home
 */
@Named
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.pse.portalempleog6.rest.AdminFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.CandidatoFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.CandidaturasFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.EmpresaFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.OfertaFacadeREST.class);
    }
    
}
