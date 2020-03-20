package fiap.scj.restf.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fiap.scj.restf.spring.beans.Message;

public class Client {

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Message>> response = restTemplate.exchange(
				"http://localhost:8080/messages/",
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Message>>() { });
		List<Message> messages = response.getBody();
		System.out.println(messages.toString());
	}
}
