package dev.nemi.pho.controller;

import dev.nemi.pho.FoodPageRequestDTO;
import dev.nemi.pho.service.FoodIndexViewDTO;
import dev.nemi.pho.service.FoodService;
import dev.nemi.pho.service.PageResponseDTO;
import groovy.util.logging.Log4j2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
@RequiredArgsConstructor
public class FoodController {

  private final FoodService foodService;

  @GetMapping("/food")
  public String index(
    @Valid @ModelAttribute("requestDTO") FoodPageRequestDTO requestDTO,
    BindingResult requestBR,
    Model model
    ) {
    if (requestBR.hasErrors()) return "redirect:/food";
    PageResponseDTO<FoodIndexViewDTO> responseDTO = foodService.getFoods(requestDTO);
    model.addAttribute("responseDTO", responseDTO);
    return "food/index";
  }

  @GetMapping("/food/view/{id}")
  public String view(@PathVariable long id, Model model) {
    return "food/view";
  }
}
