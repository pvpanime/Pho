package dev.nemi.pho.service;

import dev.nemi.pho.domain.Food;
import dev.nemi.pho.repository.FoodRepo;
import dev.nemi.pho.repository.FoodReviewRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

  private final FoodRepo foodRepo;
  private final FoodReviewRepo foodReviewRepo;
  private final ModelMapper modelMapper;

  @Override
  public PageResponseDTO<FoodViewDTO> getFoods(FoodPageRequestDTO requestDTO) {
    Page<FoodViewDTO> foods = foodRepo.getFoods(
      requestDTO.getPageable("id"),
      requestDTO.getSearchName(),
      requestDTO.getMinPrice(),
      requestDTO.getMaxPrice(),
      requestDTO.getMinRate(),
      requestDTO.getUntil()
    );

    return PageResponseDTO.<FoodViewDTO>withAll()
      .pageRequestDTO(requestDTO)
      .dtoList(foods.getContent())
      .total(foods.getTotalElements())
      .build();
  }

  @Override
  public FoodViewDTO getOne(long id) {
    Food food = foodRepo.findById(id).orElseThrow();
    FoodRatingGroupProjection r = foodReviewRepo.getRating(id);
    FoodViewDTO foodViewDTO = modelMapper.map(food, FoodViewDTO.class);
    foodViewDTO.setAvgRate(r.getAvgRate());
    foodViewDTO.setReviewCount(r.getReviewCount());
    return foodViewDTO;
  }

  @Override
  public void register(FoodRegisterDTO dto) {
    if (dto.getRegistrar() == null) dto.setRegistrar("hina");
    Food food = modelMapper.map(dto, Food.class);
    foodRepo.save(food);
  }

  @Override
  public void edit(FoodEditDTO dto) {
    Food food = foodRepo.findById(dto.getId()).orElseThrow();
    food.edit(
      dto.getName(),
      dto.getDescription(),
      dto.getPrice(),
      dto.getStock(),
      dto.getOpened(),
      dto.getClose()
    );
    foodRepo.save(food);
  }
}
