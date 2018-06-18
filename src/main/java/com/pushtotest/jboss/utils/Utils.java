package com.pushtotest.jboss.utils;

import java.util.Random;

public class Utils {
	public static int randomBalance(){
		Random r = new Random();
    	int Low = 175;
    	int High = 285;
    	return r.nextInt(High-Low) + Low;
	}
}
