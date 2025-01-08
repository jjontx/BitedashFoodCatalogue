package com.bitedash.foodcatalogue.mapper;


import com.bitedash.foodcatalogue.dto.FoodItemDTO;
import com.bitedash.foodcatalogue.entity.FoodItem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);


}
