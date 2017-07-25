package com.svocloud.plcmedge;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		File current = new File(".").getCanonicalFile();
		System.out.println(current.getName());
		
		//App.class.getPackage().getName();
		System.out.println(App.class.getPackage().getName());
	}
}
