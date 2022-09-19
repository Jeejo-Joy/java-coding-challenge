package com.crewmeister.cmcodingchallenge.loader;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cubes")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cubes {
	
	@XmlElement(name = "Cubet")
	private List<Cubet> cubet;
	
	public List<Cubet> getCubet() {
		return cubet;
	}
	public void setCubet(List<Cubet> cubet) {
		this.cubet = cubet;
	}

}
