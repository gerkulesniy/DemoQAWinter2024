package com.demoqa.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Employee {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private long salary;
    private String department;
}
