package com.crewmeister.cmcodingchallenge.loader;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;  
  
@XmlRootElement(name = "Envelope", namespace = "http://www.gesmes.org/xml/2002-08-01")
@XmlAccessorType (XmlAccessType.FIELD)
public class Envelope {

	@XmlElement(name = "Subject")
	private String subject;  
	
	@XmlElement(name = "Cubes")
	private Cubes cubes;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Cubes getCubes() {
		return cubes;
	}
	public void setCubes(Cubes cubes) {
		this.cubes = cubes;
	}
	
	
}
