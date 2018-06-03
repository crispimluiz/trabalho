package br.com.iftm.trabalho.facade.rs;


import java.io.IOException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;


@ApplicationPath("rs")
@Provider
public class RestApplication extends Application{
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext cres) throws IOException {
		cres.getHeaders().add("Access-Control-Allow-Origin","*");
		cres.getHeaders().add("Access-Control-Allow-Headers","origin,content-type,accept,authorization");
		cres.getHeaders().add("Access-Control-Allow-Credentials","true");
		cres.getHeaders().add("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS,HEAD");
		cres.getHeaders().add("Access-Control-Max-Age","1209600");
	}
}