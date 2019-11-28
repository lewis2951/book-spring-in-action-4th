package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import spittr.service.SpitterService;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"spittr.*"})
public class BurlapConfig {

    @Bean
    public BurlapServiceExporter burlapExporterSpitterService(SpitterService service) {
        BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

    @Bean
    public HandlerMapping burlapMapping() {
        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spitter.service", "burlapExportSpitterService");
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }

}
