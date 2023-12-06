package com.example.exsaption;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class,UpdateValid.class, SaveValid.class})
public interface AllValid {
}
