package pl.gatomek.manyportsapp.config;

import jakarta.servlet.*;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InternalApiFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestFacade reqFacade = (RequestFacade) servletRequest;
        boolean isInternalEndpoint = reqFacade.getRequestURI().equals("/api/rand");
        boolean isInternalPort = reqFacade.getServerPort() == 5555;

        if (isInternalEndpoint && !isInternalPort) {
            ResponseFacade response = (ResponseFacade) servletResponse;
            response.sendError(404);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
