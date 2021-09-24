package com.ranzan.sneakership.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseItem implements Parcelable {

	@SerializedName("sizes")
	private List<SizesItem> sizes;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("year")
	private int year;

	@SerializedName("styleId")
	private String styleId;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("media")
	private Media media;

	@SerializedName("brand")
	private String brand;

	@SerializedName("retailPrice")
	private int retailPrice;

	@SerializedName("shoe")
	private String shoe;

	@SerializedName("colours")
	private List<ColoursItem> colours;

	public List<SizesItem> getSizes(){
		return sizes;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public int getYear(){
		return year;
	}

	public String getStyleId(){
		return styleId;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public Media getMedia(){
		return media;
	}

	public String getBrand(){
		return brand;
	}

	public int getRetailPrice(){
		return retailPrice;
	}

	public String getShoe(){
		return shoe;
	}

	public List<ColoursItem> getColours(){
		return colours;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
}