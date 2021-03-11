package com.pvv.app.rest.impl;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvv.app.services.OperationService;
import com.pvv.app.services.vo.OperationValuesRequest;




@RestController
@RequestMapping("/operation")
public class OperationRestImpl  {
	
	@Autowired
	private OperationService operationService;


	@CrossOrigin
	@RequestMapping(path = "/getASum", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody

	public Double getASum(@RequestBody @Valid OperationValuesRequest request) {

		return operationService.getASum(request);
	}
	@CrossOrigin
	@RequestMapping(path = "/getAProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public Double getAProduct(@RequestBody @Valid OperationValuesRequest request) {
		return operationService.getAProduct(request);
	}
	@CrossOrigin
	@RequestMapping(path = "/getAPower", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public Double getAPower(@RequestBody @Valid OperationValuesRequest request) {
		return operationService.getAPower(request);
	}
	
	
	
	
	
}
