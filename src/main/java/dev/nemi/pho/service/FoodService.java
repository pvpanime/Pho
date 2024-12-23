package dev.nemi.pho.service;

import dev.nemi.pho.FoodPageRequestDTO;

public interface FoodService {
  PageResponseDTO<FoodIndexViewDTO> getFoods(FoodPageRequestDTO requestDTO);
}
