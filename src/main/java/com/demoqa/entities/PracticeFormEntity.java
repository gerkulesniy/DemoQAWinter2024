package com.demoqa.entities;

import lombok.*;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PracticeFormEntity {
    private String name;
    private String lastName;
    private String email;
    private WebElement gender;
    private String mobile;
    private String subjects;
    private String currAddress;
    private String state;
    private String city;
}
