package ru.chitava.webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Long id;
    String name;
    String groupe;
    Double averageScore;
}
