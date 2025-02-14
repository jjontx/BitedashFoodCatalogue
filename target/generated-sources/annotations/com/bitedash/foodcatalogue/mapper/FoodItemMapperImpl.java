package com.bitedash.foodcatalogue.mapper;

import com.bitedash.foodcatalogue.dto.FoodItemDTO;
import com.bitedash.foodcatalogue.entity.FoodItem;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T13:57:45-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class FoodItemMapperImpl implements FoodItemMapper {

    @Override
    public FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO) {
        if ( foodItemDTO == null ) {
            return null;
        }

        FoodItem foodItem = new FoodItem();

        foodItem.setId( foodItemDTO.getId() );
        foodItem.setItemName( foodItemDTO.getItemName() );
        foodItem.setItemDescription( foodItemDTO.getItemDescription() );
        foodItem.setVeg( foodItemDTO.isVeg() );
        foodItem.setPrice( foodItemDTO.getPrice() );
        foodItem.setRestaurantId( foodItemDTO.getRestaurantId() );
        foodItem.setQuantity( foodItemDTO.getQuantity() );

        return foodItem;
    }

    @Override
    public FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem) {
        if ( foodItem == null ) {
            return null;
        }

        FoodItemDTO foodItemDTO = new FoodItemDTO();

        foodItemDTO.setId( foodItem.getId() );
        foodItemDTO.setItemName( foodItem.getItemName() );
        foodItemDTO.setItemDescription( foodItem.getItemDescription() );
        foodItemDTO.setVeg( foodItem.isVeg() );
        foodItemDTO.setPrice( foodItem.getPrice() );
        foodItemDTO.setRestaurantId( foodItem.getRestaurantId() );
        foodItemDTO.setQuantity( foodItem.getQuantity() );

        return foodItemDTO;
    }
}
