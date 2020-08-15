package com.example.demo.obj;

public final class TheModel {
	private TheInterface theInterface = TheEnum.TEST;
	
	public TheInterface getTheInterface() {
		return theInterface;
	}
	
	public void setTheInterface(TheInterface theInterface) {
		this.theInterface = theInterface;
	}
}
