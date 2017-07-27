package com.svocloud.plcmedge.utils;

public class FieldCheckUtils {

	/***
	 * 
	 * @param obj
	 * @param field
	 * @param maxValue 默认0，则说明该字段最大长度为Integer.MAX_VALUE
	 * @return
	 */
	public static String setField(Object obj,String field,int maxValue) {
		if(maxValue==0)maxValue=Integer.MAX_VALUE;
		if(StringUtils.isEmpty(field)) 
			throw new RuntimeException(obj.getClass().getSimpleName()+"对象中："+field+"属性不能设置为空值");
		if(maxValue<1) 
			throw new RuntimeException(obj.getClass().getSimpleName()+"对象中："+field+"属性最大长度不能<1");
		else
			if(field.length()<0||field.length()>maxValue)
				throw new RuntimeException(obj.getClass().getSimpleName()+"对象中："+field+"属性长度不符合规范");
		return field;
	}
}
