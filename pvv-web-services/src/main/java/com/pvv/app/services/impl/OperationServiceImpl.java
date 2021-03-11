package com.pvv.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvv.app.rep.ResultRepository;
import com.pvv.app.services.OperationService;
import com.pvv.app.services.vo.OperationValuesRequest;
import com.pvv.app.model.ResultsDO;


/**
 * CustoermService Example
 * 
 * @author vn04d25
 */
@Service
public class OperationServiceImpl implements OperationService {
	

	private static final double CONST_FACTOR = 2.0;
	@Autowired
	private ResultRepository resultRep;


	@Override
	public Double getASum(OperationValuesRequest request) {
		
		Double response=request.getA()+request.getB();
		ResultsDO resultDO=getResultDO(request.getA(),
				request.getB(),
				"SUM",
				response
				);
		resultRep.saveAndFlush(resultDO);
		
		return response;
	}

	@Override
	public Double getAProduct(OperationValuesRequest request) {
		Double response=request.getA()*CONST_FACTOR;
		ResultsDO resultDO=getResultDO(request.getA(),CONST_FACTOR,"SUM",response);
		resultRep.saveAndFlush(resultDO);
		return response;
	}

	@Override
	public Double getAPower(OperationValuesRequest request) {
		Double response=Math.pow(request.getA(), CONST_FACTOR);
		ResultsDO resultDO=getResultDO(request.getA(),CONST_FACTOR,"SUM",response);
		resultRep.saveAndFlush(resultDO);
		return response;
	}


/**
 * get and Fill resultDO
 * @param val1
 * @param val2
 * @param operation
 * @param result
 * @return
 */
	private ResultsDO getResultDO(Double val1,Double val2,String operation, Double result) {
		ResultsDO resultDO=new ResultsDO();
		resultDO.setOperation("SUM");
		resultDO.setVal1(val1);
		resultDO.setVal2(val2);
		resultDO.setResult(result);
		return resultDO;
	}
	
	
	

}
