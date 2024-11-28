package example.bookrenting.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLogger {

    @AfterThrowing(pointcut = "execution(* example.bookrenting.service..*(..))", throwing = "ex")
    public void logError(Exception ex) {
        System.err.println("An error occurred: " + ex.getMessage());
    }
}
