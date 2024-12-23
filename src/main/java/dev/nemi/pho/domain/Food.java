package dev.nemi.pho.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Food extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 128, nullable = false)
  private String name;

  @Column(length = 2048, nullable = false)
  private String description;

  @Column(nullable = false)
  private Long price;

  @Column(nullable = false)
  private Long stock;

  @Column(nullable = false)
  private LocalDateTime opened;

  @Column(nullable = false)
  private LocalDateTime close;

  @Column(length = 32, nullable = false)
  private String registrar;
}
