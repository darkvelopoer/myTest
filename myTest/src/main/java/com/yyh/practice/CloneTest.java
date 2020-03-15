package com.yyh.practice;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.myapps.examples.dto.UserObj;

public class CloneTest {
	public static void main(String args[]) {
		
		UserObj user = new UserObj();
		user.setName("Kop");
		user.setName2("jao");
		user.setAge(38);
		try {
			UserObj obj = (UserObj)BeanUtils.cloneBean(user);
			System.out.println(obj.getName());
			System.out.println(obj.getName2());
			
			UserObj userNew = new UserObj();
			BeanUtils.copyProperties(userNew, user);
			System.out.println(userNew.getName());
			System.out.println(userNew.getName2());
			
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
