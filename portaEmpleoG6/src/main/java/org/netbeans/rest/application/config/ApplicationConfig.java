/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author home
 */
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
        resources.add(com.pse.portalempleog6.json.OfertReader.class);
        resources.add(com.pse.portalempleog6.json.OfertWriter.class);
        resources.add(com.pse.portalempleog6.rest.CandidaturasFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.OfertaFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.UserGroupsFacadeREST.class);
        resources.add(com.pse.portalempleog6.rest.UsersFacadeREST.class);
    }
    
}
