package com.mycompany.chesspuzzles;

import Controllers.*;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
     @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes= new HashSet();
        classes.add(CorsFilter.class);
        classes.add(PartidaControllers.class);
        classes.add(PerfilController.class);
        classes.add(PuzzleControllers.class);
         classes.add(RatingController.class); 
         classes.add(UsuarioController.class);
         
        return classes;
    }    
    
    
}
