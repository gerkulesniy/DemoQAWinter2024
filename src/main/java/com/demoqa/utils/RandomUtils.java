package com.demoqa.utils;
import java.util.Random;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

public class RandomUtils {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setName(faker.name().name());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setMobile(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setSubjects("Maths");
        practiceFormEntity.setCurrAddress(faker.address().fullAddress());
        practiceFormEntity.setState("NCR");
        practiceFormEntity.setCity("Gurgaon");

        return practiceFormEntity;
    }

    public Employee createMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstname(faker.name().firstName());
        employee.setLastname(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100));
      //  employee.setEmail("kierra@example.com"); // Специально прошу ввести уже существующий email,
        // чтобы проверить работу метода addNewEmployee
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(1000000l,200000000l));
        employee.setDepartment(faker.job().position());

        return employee;
    }



}
