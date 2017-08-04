package com.svocloud.plcmedge;

import com.svocloud.plcmedge.utils.PropertiesUtils;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws Exception {
		
		String property = PropertiesUtils.getProperty("DMA_HOST");
		System.out.println(property);
	}
}
