package fiap.scj.restf.spring.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.scj.restf.spring.beans.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/messages")
@Api(value = "/messages")
public class MessageController {

	@GetMapping("/teste")
	@ApiOperation(value = "Obtém uma mensagem padrão",
		    response = Message.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID"),
		    @ApiResponse(code = 404, message = "Message not found") })
	public Message getMessage(
			@ApiParam(value = "Valor da mensagem", required = true) @RequestParam(value="message", defaultValue="World") String message) {
		return new Message(message);
	}
	
	@GetMapping("/")
	public List<Message> getMessageList() {
		return Arrays.asList(new Message("Item1"), new Message("Item2"));
	}
	
}