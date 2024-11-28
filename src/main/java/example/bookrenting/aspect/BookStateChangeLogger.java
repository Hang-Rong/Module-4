package example.bookrenting.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookStateChangeLogger {

    @After("execution(* example.bookrenting.service.BookService.returnBook(..)) || execution(* example.bookrenting.service.BookService.borrowBook(..))")
    public void logBookStateChange(JoinPoint joinPoint) {
        System.out.println("Book state changed: " + joinPoint.getSignature().getName());
    }
}