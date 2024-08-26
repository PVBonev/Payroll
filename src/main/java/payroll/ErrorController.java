package payroll;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex, Model model) {
        model.addAttribute("employeeId", ex.getMessage().split(" ")[4]); // Extracting the ID from the message
        return "error";
    }
}
