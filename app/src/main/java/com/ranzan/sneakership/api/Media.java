package com.ranzan.sneakership.api;

import com.google.gson.annotations.SerializedName;

public class Media{

	@SerializedName("imageUrl")
	private String imageUrl;

	public String getImageUrl(){
		return imageUrl;
	}
}