package com.example.dto;

import com.example.exsaption.AllValid;
import com.example.exsaption.SaveValid;
import com.example.exsaption.UpdateValid;
import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @NotNull(message = "id null bolishi kere emas",groups = {UpdateValid.class, SaveValid.class})
    @Positive(message = "id musbatson bolishi kerak",groups = SaveValid.class)
    Long id;
    @NotBlank(message = "name bo'sh bolishi kere emas"
            ,groups = {UpdateValid.class, SaveValid.class})
    String name;
    @Min(value = 0,groups = SaveValid.class)
    @Max(value = 130,groups = SaveValid.class)
    @NotNull(message = "age null bolishi kerak emas"
            ,groups = SaveValid.class)
    Integer age;
    @Email(message = "emailda xato",groups = SaveValid.class)
    String email;

    @NotEmpty(message = "Role Listi bosh bolishi kere emas",groups = SaveValid.class)
    List<Role> roles;

}
