package com.pvv.app.services;

import com.pvv.app.services.vo.OperationValuesRequest;

public interface OperationService {
	/**
	 * Sum two values
	 * @param request
	 * @return
	 */
	Double getASum(OperationValuesRequest request);
	/**
	 * Product of value *2
	 * @param request
	 * @return
	 */
	Double getAProduct(OperationValuesRequest request);
	/**
	 * Pow of value to 2
	 * @param request
	 * @return
	 */
	Double getAPower(OperationValuesRequest request);

}
