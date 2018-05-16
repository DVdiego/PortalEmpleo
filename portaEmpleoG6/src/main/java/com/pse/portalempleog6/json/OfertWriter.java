/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.json;

import com.pse.portalempleog6.entities.Oferta;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author home
 */
@Provider
@Produces(MediaType.APPLICATION_JSON) 
public class OfertWriter implements MessageBodyWriter<Oferta> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Oferta.class.isAssignableFrom(type); 
    }

    @Override
    public long getSize(Oferta t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1; 
    }

    @Override
    public void writeTo(Oferta t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(entityStream);
            gen.writeStartObject()
                    .write("id_oferta", t.getIdOferta())
                    .write("email", t.getEmail())
                    .write("nombre_oferta", t.getNombreOferta())
                    .write("descripcion", t.getDescripcion())
                    .write("fecha_incorporacion", t.getFechaIncorporacion().toString())
                    .write("puesto_trabajo", t.getPuestoTrabajo())
                    .write("descripcion", t.getRequisitosMinimos())
            .writeEnd();
            gen.flush();
    }
    
}
