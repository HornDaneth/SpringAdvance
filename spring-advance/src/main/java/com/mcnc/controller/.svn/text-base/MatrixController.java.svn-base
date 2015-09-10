package com.mcnc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/matrix")
public class MatrixController {
	/**
	 * <mvc:annotation-driven enableMatrixVariables="true"/>
	 * url: http://localhost:8080/advance/matrix/one/params;trxId=1
	 * @param trxId
	 * @return
	 */
	@RequestMapping("/one/{matrixvars}")
	public @ResponseBody String showYourParam(
			@MatrixVariable(pathVar = "matrixvars", value="trxId", required=true) 
			String trxId){

		return trxId;
	}
	

	/**
	 * http://localhost:8080/advance/matrix/many/params;trxId=1;trxDay=3;trxTest=4
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/many/{matrixvars}", produces="application/json")
	public @ResponseBody Map<String, String> showYourParams(
			@MatrixVariable(pathVar = "matrixvars") 
			Map<String, String> params){
		return params;
	}
	
	
	/**
	 * url: http://localhost:8080/advance/matrix/path/1
	 * @param var
	 * @return
	 */
	@RequestMapping("/path/{var}")
	public @ResponseBody String showYourPath(
			@PathVariable String var){

		return var;
	}
}