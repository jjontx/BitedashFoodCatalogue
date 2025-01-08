package com.bitedash.foodcatalogue.service;

import com.bitedash.foodcatalogue.dto.FoodCataloguePage;
import com.bitedash.foodcatalogue.dto.FoodItemDTO;
import com.bitedash.foodcatalogue.dto.Restaurant;
import com.bitedash.foodcatalogue.entity.FoodItem;
import com.bitedash.foodcatalogue.mapper.FoodItemMapper;
import com.bitedash.foodcatalogue.repo.FoodItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSavedInDB);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }

	public List<FoodItemDTO> findAllFoodCatalogue() {
		List<FoodItem> catalogues = foodItemRepo.findAll();		
		List<FoodItemDTO> restaurantDTOList = catalogues.stream().map(catalogue -> FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(catalogue))
        		.collect(Collectors.toList());
		return restaurantDTOList;

	}
}
