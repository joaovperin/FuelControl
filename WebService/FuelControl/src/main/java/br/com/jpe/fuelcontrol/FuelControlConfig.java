/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol;

import br.com.jpe.fuelcontrol.interceptors.AuthHandlerMapping;
import br.com.jpe.fuelcontrol.interceptors.CORSHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration for the WebService
 */
@Configuration
public class FuelControlConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CORSHandlerMapping corsInterceptor;
    @Autowired
    private AuthHandlerMapping authInterceptor;

    /**
     * Add the interceptors to the registry
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
        registry.addInterceptor(authInterceptor);
    }

}
