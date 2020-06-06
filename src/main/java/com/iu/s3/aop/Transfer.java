package com.iu.s3.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void bus() {
		System.out.println("Bus 이용");
		
	}
	
	public void subway() {
		System.out.println("SubWay 이용");
	}

}
