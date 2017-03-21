package javamarathon10km.domain;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class Hotel {
	private int id;
	private int price;
	private String areaName;
	private String hotelName;
	private String nearestStation;
	private String address;
	private String parking;
}
