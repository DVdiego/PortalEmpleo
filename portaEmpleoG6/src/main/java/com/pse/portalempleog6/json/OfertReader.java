/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portalempleog6.json;

import com.pse.portalempleog6.entities.Oferta;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;


/**
 *
 * @author home
 */
@Provider 
@Consumes(MediaType.APPLICATION_JSON) 
public class OfertReader implements MessageBodyReader<Oferta>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
         return Oferta.class.isAssignableFrom(type); 
    }

    @Override
    public Oferta readFrom(Class<Oferta> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        
        Oferta oferta = new Oferta();
        JsonParser parser = Json.createParser(entityStream);
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
       
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "id_oferta":
                            oferta.setIdOferta(parser.getInt());
      
                            break;
                        case "email":
                            oferta.setEmail(parser.getString());
               
                            break;
                        case "nombre_oferta":
                            oferta.setNombreOferta(parser.getString());
                            break;
                        case "descripcion":
                            oferta.setDescripcion(parser.getString());
                            break;
                        case "fecha_incorporacion": //ojo metemos un string
                             Date date = new Date();
                            oferta.setFechaIncorporacion(date);
                            break;
                        case "puesto_trabajo":
                            oferta.setDescripcion(parser.getString());
                            break;
                        case "requisitos_minimos":
                            oferta.setDescripcion(parser.getString());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return oferta;
    }
    
}
