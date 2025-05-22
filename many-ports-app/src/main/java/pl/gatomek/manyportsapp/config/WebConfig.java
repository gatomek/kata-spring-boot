package pl.gatomek.manyportsapp.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
class WebConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    public static final String HTTP = "http";
    private final CustomConfig customConfig;

    public WebConfig(CustomConfig customConfig) {
        super();
        this.customConfig = customConfig;
    }

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setPort(customConfig.getPort());
        connector.setScheme(HTTP);
        factory.addAdditionalTomcatConnectors(connector);
    }
}
