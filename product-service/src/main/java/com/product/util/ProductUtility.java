package com.product.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductUtility {
	
	public static String convertObjectToJson(Object product) {
		 ObjectMapper Obj = new ObjectMapper();  
		 String jsonStr=null;
		 try {  
             // Converting the Java object into a JSON string  
             jsonStr = Obj.writeValueAsString(product);  
             // Displaying Java object into a JSON string  
             System.out.println(jsonStr);  
         }catch (Exception e) {
        	 e.printStackTrace();
		} 
		 return jsonStr;
	}
	
}
