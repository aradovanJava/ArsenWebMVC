package hr.apis.it.modul.d.controller;

import hr.apis.it.modul.d.model.Car;
import hr.apis.it.modul.d.model.CarCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mvc")
public class StartController {

  @GetMapping("/home")
  public String getHomePage(Model model) {

    Car firstCar = new Car("Mercedes", new BigDecimal(10000));
    Car secondCar = new Car("Audi", new BigDecimal(9000));

    List<Car> carList = new ArrayList<>();
    carList.add(firstCar);
    carList.add(secondCar);

    model.addAttribute("carList", carList);

    return "home";
  }

  @GetMapping("/car")
  public String getAddNewCarScreen(Model model) {
    model.addAttribute("carCommand", new CarCommand());
    return "newCar";
  }

  @PostMapping("/car")
  public String addCar(Model model,
      @Valid @ModelAttribute CarCommand carCommand, BindingResult result) {
    if(result.hasErrors()) {
      System.out.println("Errors!");
      return "newCar";
    }

    System.out.println(carCommand.getName());
    System.out.println(carCommand.getPrice());

    return "redirect:/mvc/car";
  }
}
