package com.ranzan.sneakership.api;

import com.google.gson.annotations.SerializedName;

public class SizesItem{

	@SerializedName("size")
	private int size;

	@SerializedName("id")
	private int id;

	public int getSize(){
		return size;
	}

	public int getId(){
		return id;
	}
}