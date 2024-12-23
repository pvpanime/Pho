package dev.nemi.pho.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FoodReviewEditDTO {
  private Long id;
  private String comment;
  private Integer rating;
}
