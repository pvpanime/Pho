package dev.nemi.pho.repository;

import dev.nemi.pho.domain.FoodReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodReviewRepo extends JpaRepository<FoodReview, Long>, FoodSearch {

  @Query("select f from FoodReview f where f.food.id = :foodId")
  Page<FoodReview> getReviewsOf(Pageable pageable, long foodId);
}
