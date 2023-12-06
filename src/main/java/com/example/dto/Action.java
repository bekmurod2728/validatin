package com.example.dto;

import com.example.exsaption.AllValid;
import com.example.exsaption.SaveValid;
import com.example.exsaption.UpdateValid;
import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @NotNull(message = "id null bolishi kere emas", groups = {UpdateValid.class,SaveValid.class})
    @Positive(message = "id musbatson bolishi kerak", groups = {UpdateValid.class,SaveValid.class})
    Long id;
    @NotBlank(message = "name bo'sh bolishi kere emas", groups = {UpdateValid.class})
    String name;
    @PastOrPresent(message = "sana otgan bolishi kerak",groups = SaveValid.class)
    Date date;
    @Valid
    @NotEmpty(message = "Roles Listi bosh bolishi kere emas",groups = SaveValid.class)
    List<Role> roles;
}
