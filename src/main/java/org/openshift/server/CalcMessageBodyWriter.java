package org.openshift.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.openshift.calculations.Calculation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
@Produces ("application/json")
public class CalcMessageBodyWriter implements MessageBodyWriter<Calculation>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Calculation.class == type;
	}

	@Override
	public long getSize(Calculation t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(Calculation t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		PrintWriter printWriter = new PrintWriter(entityStream); 
		Gson gson = new GsonBuilder().create(); 
		try {
			String json ;
			json = gson.toJson(t);  
			printWriter.write(json);
			printWriter.flush(); 
		} finally {
			printWriter.close(); 
		}
	}

}
