/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapclient;

import com.ws.rpc.Movie;
import com.ws.rpc.MovieCategories;
import com.ws.rpc.ObjectFactory;
import com.ws.rpc.RpcService;
import com.ws.rpc.SoapServiceRPC;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Rodrigo
 */
public class Main {
    public static void main(String[] args) {
        RpcService service = new RpcService();
        SoapServiceRPC port = service.getRpcPort();
        Movie movie = new ObjectFactory().createMovie();
        movie.setName("");
        short rate = (short) 8;
        movie.setRate(rate);
        
        movie.setCategory(MovieCategories.HORROR);
        
        GregorianCalendar today = new GregorianCalendar();
        XMLGregorianCalendar release;
        try {
            release = DatatypeFactory.newInstance().newXMLGregorianCalendar(today);
            movie.setReleaseDate(release);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Movie result = port.addMovie(movie);
        System.out.println("Result id = "+result.getId());
        System.out.println("Result release = "+result.getReleaseDate());
    }
}
