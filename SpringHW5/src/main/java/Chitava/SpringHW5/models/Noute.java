package Chitava.SpringHW5.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@Table(name = "notes")
public class Noute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String annotation;
    @Enumerated (EnumType.STRING)
    Status status = Status.NOT_STARTED;
    LocalDateTime time = LocalDateTime.now();


}
