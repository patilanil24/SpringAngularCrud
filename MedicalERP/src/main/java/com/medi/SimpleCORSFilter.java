package com.medi;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
public class SimpleCORSFilter implements Filter {



public SimpleCORSFilter() {
   
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	response.addHeader("Access-Control-Allow-Headers", "Authorization,Content-Type,Accept, X-Requested-With");// get token
	response.addHeader("Access-Control-Expose-Headers", "Authorization,Content-Type");
	response.addHeader("Access-Control-Max-Age", "600");
    chain.doFilter(req, res);
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
}
}