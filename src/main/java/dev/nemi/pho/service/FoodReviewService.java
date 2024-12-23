package dev.nemi.pho.service;

import dev.nemi.pho.PageRequestDTO;

public interface FoodReviewService {
  PageResponseDTO<FoodReviewDTO> getReviews(PageRequestDTO requestDTO, Long foodId);

  FoodReviewDTO getOne(Long reviewId);

  Long addReview(FoodReviewRegisterDTO dto);

  void updateReview(FoodReviewEditDTO dto);

  void deleteReview(long id);
}
