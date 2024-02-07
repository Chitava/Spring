package Chitava.SpringHW5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class TaskLogerAspect {

    private Logger logger = Logger.getLogger(TaskLogerAspect.class.getName());

    @Around("execution(* Chitava.SpringHW5.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Метод " + methodName +
                " с параметрами " + Arrays.asList(arguments) +
                " выполнен");
    }

}
