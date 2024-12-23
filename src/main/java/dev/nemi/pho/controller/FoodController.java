package dev.nemi.pho.controller;

import dev.nemi.pho.service.FoodPageRequestDTO;
import dev.nemi.pho.service.FoodViewDTO;
import dev.nemi.pho.service.FoodService;
import dev.nemi.pho.service.PageResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

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
    log.info(requestDTO);
    PageResponseDTO<FoodViewDTO> responseDTO = foodService.getFoods(requestDTO);
    model.addAttribute("requestDTO", requestDTO);
    model.addAttribute("responseDTO", responseDTO);
    return "food/index";
  }

  @GetMapping("/food/view/{id}")
  public String view(@PathVariable long id, Model model) {
    FoodViewDTO food = foodService.getOne(id);
    model.addAttribute("food", food);
    return "food/view";
  }

  @GetMapping("/food/register")
  public String register(
    @Valid @ModelAttribute("requestDTO") FoodPageRequestDTO requestDTO,
    BindingResult requestBR,
    Model model
  ) {
    if (requestBR.hasErrors()) return "redirect:/food/register";
    model.addAttribute("pageAttr", Map.of("title", "Register", "action", "/food/register"));
    return "food/edit";
  }

  @GetMapping("/food/edit/{id}")
  public String edit(
    @Valid @ModelAttribute("requestDTO") FoodPageRequestDTO requestDTO,
    BindingResult requestBR,
    @PathVariable long id, Model model
  ) {
    if (requestBR.hasErrors()) return "redirect:/food/edit/"+id;
    FoodViewDTO food = foodService.getOne(id);
    model.addAttribute("food", food);
    model.addAttribute("pageAttr", Map.of("title", "Edit", "action", "/food/edit"));
    return "food/edit";
  }
}
