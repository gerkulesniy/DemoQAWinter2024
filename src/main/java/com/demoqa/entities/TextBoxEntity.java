package com.demoqa.entities;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class TextBoxEntity {
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;


}
