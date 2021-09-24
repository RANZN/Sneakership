package com.ranzan.sneakership.api;

import com.google.gson.annotations.SerializedName;

public class ColoursItem{

	@SerializedName("color")
	private String color;

	@SerializedName("id")
	private int id;

	public String getColor(){
		return color;
	}

	public int getId(){
		return id;
	}
}