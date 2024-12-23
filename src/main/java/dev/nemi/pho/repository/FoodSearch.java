package dev.nemi.pho.repository;

import dev.nemi.pho.service.FoodIndexViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface FoodSearch {
  Page<FoodIndexViewDTO> getFoods(Pageable pageable, String searchName, Long minPrice, Long maxPrice, Integer minRate, LocalDateTime until);
}
