package com.example.dto;

import com.example.exsaption.SaveValid;
import com.example.exsaption.UpdateValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {


    @NotNull(message = "id null bolishi kere emas", groups = {UpdateValid.class, SaveValid.class})
    @Positive(message = "id musbatson bolishi kerak", groups = {UpdateValid.class, SaveValid.class})
    Long id;
    @NotBlank(message = "name bo'sh bolishi kere emas", groups = {UpdateValid.class, SaveValid.class})
    String name;

    @NotEmpty(message = "Action Listi bosh bolishi kere emas", groups = SaveValid.class)
    List<Action> actions;
    @NotEmpty(message = "User Listi bosh bolishi kere emas", groups = SaveValid.class)
    List<User> users;
}
