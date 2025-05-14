/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 *
 * @author JUAN JOSE
 */
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        MultivaluedMap<String, Object> headers= crc1.getHeaders();
        //permitir operaciones desde cualquier maquina
        headers.add("Access-Control-Allow-Origin","*");
        //permitir operaciones http
        headers.add("Access-Control-Allow-Methods","POST, GET, DELETE, PUT, UPDATE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.add("Access-Control-Max-Age", "600");
        headers.add("Access-Control-Allow-Credentials", "true");
        
        
    }
    
}
