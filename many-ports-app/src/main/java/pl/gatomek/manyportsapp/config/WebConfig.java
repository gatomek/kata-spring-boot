package pl.gatomek.manyportsapp.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setPort(5555);
        connector.setScheme("http");
        factory.addAdditionalTomcatConnectors(connector);
    }
}
