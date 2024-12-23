package dev.nemi.pho;

import dev.nemi.pho.repository.FoodRepo;
import dev.nemi.pho.service.FoodIndexViewDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Log4j2
@SpringBootTest
class PhoApplicationTests {

  @Autowired
  private FoodRepo foodRepo;


  @Test
  public void foodSearchTest() {
    log.info("\n\n\n\n****************\nSearching for foods with no filtering");
    Page<FoodIndexViewDTO> foods = foodRepo.getFoods(PageRequest.of(0, 16, Sort.by("id")), null, null, null, null, null);
    for (FoodIndexViewDTO food : foods) {
      log.info(food);
    }

    log.info("\n\n\n\n****************\nSearching for foods with \"밥\"");
    foods = foodRepo.getFoods(PageRequest.of(0, 16, Sort.by("id")), "밥", null, null, null, null);
    for (FoodIndexViewDTO food : foods) {
      log.info(food);
    }

    log.info("\n\n\n\n****************\nSearching for foods with E and higher than 10000");
    foods = foodRepo.getFoods(PageRequest.of(0, 16, Sort.by("id")), "E", 10000L, null, null, null);
    for (FoodIndexViewDTO food : foods) {
      log.info(food);
    }
  }
}
