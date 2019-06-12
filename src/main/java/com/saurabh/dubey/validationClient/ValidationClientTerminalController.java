package com.saurabh.dubey.validationClient;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.saurabh.dubey.validationClient.client.TerminalClient;
import com.saurabh.dubey.validationClient.model.MessagePayload;

@RestController
public class ValidationClientTerminalController {

	@Autowired
	TerminalClient client;
	
	@RequestMapping(value = "/testTerminalServer" ,method = RequestMethod.GET)
	public int testTerminalServer() throws JsonParseException, JsonMappingException, IOException {
		MessagePayload payload = client.getTerminal();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.releaseTerminal(payload.getId());
		return 0;
	}
	
}
