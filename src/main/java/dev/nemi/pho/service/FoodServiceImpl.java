package dev.nemi.pho.service;

import dev.nemi.pho.FoodPageRequestDTO;
import dev.nemi.pho.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

  private final FoodRepo foodRepo;

  @Override
  public PageResponseDTO<FoodIndexViewDTO> getFoods(FoodPageRequestDTO requestDTO) {
    Page<FoodIndexViewDTO> foods = foodRepo.getFoods(
      requestDTO.getPageable("id"),
      requestDTO.getSearchName(),
      requestDTO.getMinPrice(),
      requestDTO.getMaxPrice(),
      requestDTO.getMinRate(),
      requestDTO.getUntil()
    );

    return PageResponseDTO.<FoodIndexViewDTO>withAll()
      .pageRequestDTO(requestDTO)
      .dtoList(foods.getContent())
      .total(foods.getTotalElements())
      .build();
  }
}
