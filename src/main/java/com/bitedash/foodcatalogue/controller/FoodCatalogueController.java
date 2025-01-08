package com.bitedash.foodcatalogue.controller;


import com.bitedash.foodcatalogue.dto.FoodCataloguePage;
import com.bitedash.foodcatalogue.dto.FoodItemDTO;
import com.bitedash.foodcatalogue.service.FoodCatalogueService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }
    
    @GetMapping("/fetchAllFoodCatalogue")
    public ResponseEntity<List<FoodItemDTO>> fetchAllFoodCatalogue(){
    	List<FoodItemDTO> allfoodCatalogue = foodCatalogueService.findAllFoodCatalogue();
      return new ResponseEntity<>(allfoodCatalogue, HttpStatus.OK);
    }
    
    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

    }

}
