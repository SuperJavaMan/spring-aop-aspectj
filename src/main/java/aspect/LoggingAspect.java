package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Before("execution( * service.Worker.doWork0(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.printf("Log: method %s() will be invoked!", joinPoint.getSignature().getName());
    }

    @After("execution( * service.Worker.doWork0(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.printf("Log: method %s() is invoked!", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution( * service.Worker.doWork1(..))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.printf("Log: method %s() returns result = %s", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "execution( * service.Worker.doWork2(..))",
            throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.printf("Log: method %s() throws = %s", joinPoint.getSignature().getName(), error);
    }

    @Around("execution( * service.Worker.doWork3(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("Log: method %s() will be invoked with args = %s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        System.out.printf("Start method %s()", joinPoint.getSignature().getName());
        joinPoint.proceed();
        System.out.printf("Finish method %s()", joinPoint.getSignature().getName());
    }
}
