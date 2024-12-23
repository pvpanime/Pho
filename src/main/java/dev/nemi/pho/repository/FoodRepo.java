package dev.nemi.pho.repository;

import dev.nemi.pho.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long>, FoodSearch {
}
