package example.bookrenting.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitorLogger {

    @Before("execution(* example.bookrenting.service..*(..))")
    public void logVisitorCount(JoinPoint joinPoint) {
        System.out.println("Visitor accessed: " + joinPoint.getSignature().getName());
    }
}
