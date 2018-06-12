package service;

import java.util.Set;
import javax.ws.rs.core.Application;


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
        resources.add(filters.LogingFilter.class);
        resources.add(filters.MyResponseFilter.class);
        resources.add(filters.SecurityFilter.class);
        resources.add(service.HelloWorldService.class);
        resources.add(service.MessageService.class);
        resources.add(service.ShopService.class);
    }
    
}
