package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("items")
@PropertySource(value = {"com/nt/commons/input.properties"})
public class ItemsInfo {

	@Value("${dosa.price}")
	private float dosaPrice;
	@Value("${idly.price}")
	private float idlyPrice;
	@Value("${poha.price}")
	private float pohaPrice;
	public float getDosaPrice() {
		return dosaPrice;
	}
	public void setDosaPrice(float dosaPrice) {
		this.dosaPrice = dosaPrice;
	}
	public float getIdlyPrice() {
		return idlyPrice;
	}
	public void setIdlyPrice(float idlyPrice) {
		this.idlyPrice = idlyPrice;
	}
	public float getPohaPrice() {
		return pohaPrice;
	}
	public void setPohaPrice(float pohaPrice) {
		this.pohaPrice = pohaPrice;
	}
	
}
