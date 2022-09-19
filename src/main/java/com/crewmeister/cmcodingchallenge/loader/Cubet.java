package com.crewmeister.cmcodingchallenge.loader;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "Cubet")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cubet {

	@XmlAttribute(name = "time")
	private String time;  
	
	@XmlElement(name = "Cube")
	private List<Cube> cube;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Cube> getCube() {
		return cube;
	}

	public void setCube(List<Cube> cube) {
		this.cube = cube;
	}

}
