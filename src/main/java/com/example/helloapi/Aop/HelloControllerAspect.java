package com.example.helloapi.Aop;

//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloControllerAspect {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(HelloControllerAspect.class);

     // ✅ Custom Annotation Pointcut
    @Pointcut("@annotation(com.example.helloapi.LogExecution)")
    public void logExecutionMethods() {}

    @Before("logExecutionMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method after adding custom annotation : " + joinPoint.getSignature().getName());
    }

     @Before("execution(* com.example.helloapi.controller.HelloController.*(..))")
     public void logBeforeU(JoinPoint joinPoint) {
         logger.info("AOP: Before method execution");
         logger.info("\uD83D\uDD0D [Before] Method: {}", joinPoint.getSignature().getName());
     }

     // Use Case 2: Measure execution time
    // @Around("execution(* com.example.helloapi.controller.HelloController.*(..))")
    // public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
    //     long start = System.currentTimeMillis();
    //     Object result = joinPoint.proceed(); // Proceed with the method call
    //     long end = System.currentTimeMillis();
    //     System.out.println("⏱️ [Around] Time taken by " + joinPoint.getSignature().getName() + ": " + (end - start) + "ms");
    //     return result;
    // }

    // @AfterThrowing(pointcut = "execution(* com.example.helloapi.controller.HelloController.*(..))", throwing = "ex")
    // public void logException(Exception ex) {
    //     System.out.println("❌ [Exception] " + ex.getMessage());
    // }

    //  // Use Case 4: Simulate Security Check
    // @Before("execution(* com.example.helloapi.controller.HelloController.sayHello(..))")
    // public void simulateSecurityCheck() {
    //     System.out.println("🔐 [Security] Checking user permissions for sayHello()");
    //     // Simulate logic: throw exception if needed
    //     // throw new RuntimeException("Unauthorized");
    // }

    // // Use Case 5: Log Method Arguments
    // @Around("execution(* com.example.helloapi.controller.HelloController.greet(..))")
    // public Object logMethodArguments(ProceedingJoinPoint joinPoint) throws Throwable {
    //     long start = System.currentTimeMillis();
    //     Object result = joinPoint.proceed();
    //     long end = System.currentTimeMillis();
    //     long timetaken= end - start;
    //     System.out.println("[AOP Around ]" + joinPoint.getSignature() +" executed in " +timetaken + "ms");
    //     return result;// Proceed with the method call
    // }

    // @Before("execution(* com.example.helloapi.controller..*(..))")
    // public void logMethodInputs(JoinPoint joinPoint) {
    //     System.out.println("📥 [AOP Before] Method: " + joinPoint.getSignature().getName());

    //     Object[] args = joinPoint.getArgs();
    //     if (args.length > 0) {
    //         for (Object arg : args) {
    //             System.out.println("📌 Argument: " + arg);
    //         }
    //     }
    // }

}
