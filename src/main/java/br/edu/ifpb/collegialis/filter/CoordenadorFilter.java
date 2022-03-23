package br.edu.ifpb.collegialis.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.collegialis.bean.UsuarioBean;

@WebFilter(filterName = "CoordenadorFilter")
public class CoordenadorFilter implements Filter {

    @Inject
    private UsuarioBean usuarioBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (this.usuarioBean.getUsuario().isCoordenador() == false) {
            ((HttpServletResponse) response).sendRedirect("pretty:dashboard");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}