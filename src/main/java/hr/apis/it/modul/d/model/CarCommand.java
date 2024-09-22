package hr.apis.it.modul.d.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCommand {

  @NotBlank(message = "Car name must not be empty")
  private String name;

  @NotNull(message = "Price name must not be empty")
  @PositiveOrZero(message = "Price must be entered as a positive integer")
  private BigDecimal price;

}
