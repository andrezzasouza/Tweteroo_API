package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
  @NotBlank(message = "O nome de usuário é obrigatório.")
  @Size(max = 100)
  private String username;

  @NotBlank(message = "O avatar é obrigatório.")
  @URL(message = "URL inválida.")
  @Pattern(regexp = ".*\\.(jpg|jpeg|png|webm|gif)$", message = "A URL deve ser de uma imagem.")
  private String avatar;
}
