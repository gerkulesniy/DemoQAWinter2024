package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends BasePage{

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstnameInput;

    @FindBy(id = "lastName")
    public WebElement lastnameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement mailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @Step("Adding new employee {0}")
    public WebTablePage addNewEmployee(Employee employee){

        // Получаем всех сотрудников из таблицы
        List<Employee> existingEmployees = getEmployeesFromTable();
// Перебираем каждого сотрудника через цикл
        for (Employee item : existingEmployees) {
            // Если находим сотрудника с таким же email, выводим сообщение и выходим из метода
            if (item.getEmail().equals(employee.getEmail())) {
                System.out.println("Employee with email " + employee.getEmail() + " already exists.");
                return this;
            }
        }

        webElementActions.click(addNewBtn)
                .sendKeys(firstnameInput,employee.getFirstname())
                .sendKeys(lastnameInput,employee.getLastname())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(mailInput,employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput,employee.getDepartment())
                .click(submitButton);
        return this;
    }

    public ArrayList<Employee> getEmployeesFromTable(){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]","");
            String mail = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]","");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty()
                    || mail.isEmpty() || salaryText.isEmpty() || department.isEmpty()){
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName,lastName,age,mail,salary,department));
        }
        return employees;
    }

    public WebTablePage editEmployeeData(String email, Employee newEmployeeData) throws InterruptedException {
// Получаем всех сотрудников из таблицы
        List<Employee> existingEmployees = getEmployeesFromTable();

// Флаг для определения, был ли найден сотрудник с заданным email
        boolean emailFound = false;
// Перебираем каждого сотрудника через цикл for с использованием индекса,чтобы найти сотрудника с задан.email
        for (int i = 0; i < existingEmployees.size(); i++) {
            // Если email сотрудника совпадает с переданным значением
            if (existingEmployees.get(i).getEmail().equals(email)) {
                // Находим кнопку редактирования для строки с соответствующим индексом
                WebElement editBtn = DriverManager.getDriver().findElement(By.cssSelector("#edit-record-" + i));
                webElementActions.click(editBtn);
                // Устанавливаем флаг, что сотрудник был найден
                emailFound = true;

                // Заполняем форму новыми данными из объекта newEmployeeData, если поле не null
                if (newEmployeeData.getFirstname() != null) {
                    webElementActions.clearAndSendKeys(firstnameInput, newEmployeeData.getFirstname());
                }
                if (newEmployeeData.getLastname() != null) {
                    webElementActions.clearAndSendKeys(lastnameInput, newEmployeeData.getLastname());
                }
                if (newEmployeeData.getAge() != 0) {
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newEmployeeData.getAge()));
                }
                if (newEmployeeData.getEmail() != null) {
                    webElementActions.clearAndSendKeys(mailInput, newEmployeeData.getEmail());
                }
                if (newEmployeeData.getSalary() != 0) {
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newEmployeeData.getSalary()));
                }
                if (newEmployeeData.getDepartment() != null) {
                    webElementActions.clearAndSendKeys(departmentInput, newEmployeeData.getDepartment());
                }
                webElementActions.click(submitButton); // Нажимаем кнопку отправки, чтобы сохранить изменения
                break;  // Прерываем цикл после нахождения и редактирования нужного сотрудника
            }
        }
        // Если сотрудник с заданным email не найден, то выбрасывае исключение
        if (!emailFound){
            throw new IllegalArgumentException("Сотрудник с email " + email + " не найден.");
        }
        return this; // Возвращаем текущий объект WebTablesPage для цепочки вызовов методов
    }


    // МЕТОД ДЛЯ УДАЛЕНИЯ сотрудника
    public WebTablePage deleteEmployee(String email) {
        List<Employee> existingEmployees = getEmployeesFromTable();

        // Флаг для определения найден ли сотрудник с заданным email
        boolean emailFound = false;

        // Перебираем каждого сотрудника через цикл for с использованием индекса,чтобы найти сотрудника с задан.email
        for (int i = 0; i < existingEmployees.size(); i++) {
            // Если email сотрудника совпадает с переданным значением
            if (existingEmployees.get(i).getEmail().equals(email)) {
                // Находим кнопку редактирования для строки с соответствующим индексом
                WebElement deleteBtn = DriverManager.getDriver().findElement(By.xpath("//span[@id='delete-record-" + i + "']"));
                webElementActions.click(deleteBtn);
                emailFound = true;
                break;
            }
        }
        // Если сотрудник с заданным email не найден, то выбрасывае исключение
        if (!emailFound) {
            throw new IllegalArgumentException("Сотрудник с email " + email + " не найден.");
        }
        return this; // Возвращаем текущий объект WebTablesPage для цепочки вызовов методов
    }
}
