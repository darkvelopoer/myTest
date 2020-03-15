package com.yyh.practice;

import java.util.Optional;

import com.myapps.examples.dto.UserObj;

public class OptionalTest {

	public static void main(String[] args){
		Optional<UserObj> opt = getUserObj();
		opt.ifPresent(user -> {
			System.out.println("User is " + user.getName());
		});
		UserObj userObj = opt.get();
		System.out.println(userObj);
		
		Optional<UserObj> opt2 = getEmptyUserObj();
		opt.ifPresent(user -> {
			System.out.println("User is " + user.getName());
		});
		
		Optional<UserObj> opt3 = getNullableUserObj();
		opt.ifPresent(user -> {
			System.out.println("User null is " + user.getName());
		});
		
		getOrElseUserObj();
		
/*		opt.filter(user -> user.getName().equals("some")).ifPresent(() -> {
			System.out.println();
		});
		*/

		opt.map(UserObj::getName).filter(name -> name.equalsIgnoreCase("Nomad")).ifPresent(x -> {
		 System.out.println("Employee belongs to USA " + x);
		});
	}
	
	private static Optional<UserObj> getUserObj() {
		UserObj userObj = new UserObj();
		userObj.setName("Nomad");
		userObj.setAge(46);
		userObj.setName2("Pak");
		Optional <UserObj> optional = Optional.of(userObj);
		return optional;
	}
	
	private static Optional<UserObj> getEmptyUserObj() {
		Optional <UserObj> userObj = Optional.empty();
		return userObj;
	}
	
	private static Optional<UserObj> getNullableUserObj() {
		UserObj userObj = null;
		Optional <UserObj> optional = Optional.ofNullable(userObj);
		return optional;
	}
	
	private static Optional<UserObj> getOrElseUserObj(){
		UserObj userObj = new UserObj();
		userObj.setName("Nomad");
		userObj.setAge(46);
		userObj.setName2("Pak");
		Optional <UserObj> optional = Optional.of(new UserObj());
		UserObj finalUser = optional.orElse(userObj);
		System.out.println(finalUser);
		return optional;
	}
}
