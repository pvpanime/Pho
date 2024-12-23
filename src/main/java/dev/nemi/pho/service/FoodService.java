package dev.nemi.pho.service;

public interface FoodService {
  PageResponseDTO<FoodViewDTO> getFoods(FoodPageRequestDTO requestDTO);

  FoodViewDTO getOne(long id);

  void register(FoodRegisterDTO dto);

  void edit(FoodEditDTO dto);
}
