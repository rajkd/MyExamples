package com.example;

import static org.junit.Assert.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.controller.Domain;

public class TestRest {

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() {
		RestTemplate template = getRestTemplate();
		try {
			Domain obj = template.getForObject("http://localhost:8080/SpringMVC/json", Domain.class);
			System.out.println("##########" + obj);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAuth() {
		RestTemplate template = getRestTemplate();
		System.out.println("##########");
		
		try {
			Domain obj = template.exchange
			 ("http://localhost:8080/SpringMVC/json", HttpMethod.GET, new HttpEntity(createHeaders("bill", "abc123w")), Domain.class).getBody();			
			System.out.println("##########" + obj);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}

	private RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(createXmlHttpMessageConverter());
		template.setMessageConverters(converters);
		return template;
	}	

	
	private HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}
	
    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
 
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
    }		
}
