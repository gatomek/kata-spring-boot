package pl.gatomek.manyportsapp.filter;

import jakarta.servlet.*;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;

import java.io.IOException;

public class InternalApiFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestFacade reqFacade = (RequestFacade) servletRequest;
        boolean isInternalEndpoint = reqFacade.getRequestURI().equals("/api/random");
        boolean isInternalPort = reqFacade.getServerPort() == 5555;

        if (isInternalEndpoint && !isInternalPort) {
            ResponseFacade response = (ResponseFacade) servletResponse;
            response.sendError(404);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
