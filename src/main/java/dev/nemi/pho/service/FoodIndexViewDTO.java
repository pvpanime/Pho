package dev.nemi.pho.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FoodIndexViewDTO {
  private Long id;
  private String name;
  private String description;
  private Long price;
  private Long stock;
  private LocalDateTime close;
  private Long reviewCount;
  private Double avgRate;
}
