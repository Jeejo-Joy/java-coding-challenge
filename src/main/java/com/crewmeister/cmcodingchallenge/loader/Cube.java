package com.crewmeister.cmcodingchallenge.loader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;  
  
@XmlRootElement(name = "Cube")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cube {

	@XmlAttribute(name = "currency")
	private String currency;  
	
	@XmlAttribute(name = "rate")
	private double rate;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double d) {
		this.rate = d;
	}  
	
	
	
}
