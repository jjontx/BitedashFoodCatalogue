package com.bitedash.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.bitedash.foodcatalogue.entity.FoodItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
	public List<FoodItem> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItem> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public FoodCataloguePage(List<FoodItem> foodItemsList, Restaurant restaurant) {
		super();
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
	}
    
    public FoodCataloguePage() {
    	
    }
	@Override
	public String toString() {
		return "FoodCataloguePage [foodItemsList=" + foodItemsList + ", restaurant=" + restaurant + "]";
	}
    
    
}
