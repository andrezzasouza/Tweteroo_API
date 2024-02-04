package com.tweteroo.api.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
  @NotNull(message = "O id do usuário não pode estar em branco.")
  @Positive(message = "O id do usuário deve ser um número positivo maior que zero.")
  @Digits(fraction = 0, integer = 19, message = "O id do usuário deve ser um número inteiro menor que 9.223.372.036.854.775.807.")
  private Long userId;

  @NotBlank(message = "O tweet não pode estar em branco.")
  @Size(max = 280, message = "O tweet não pode ter mais de 280 caracteres")
  private String text;
}
