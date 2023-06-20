package lian.sample.productapi.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Map;
import java.util.UUID;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class CommonLogHandler {
    @Pointcut("@annotation(lian.sample.productapi.exception.CustomErrorLog)")
    public void customErrorLog(){}

    @Pointcut("within(lian.sample.productapi.controller.*)") // 패키지 범위 설정
    public void controller() {}

    @Before("controller() || customErrorLog()")
    public void validationAdvice(JoinPoint joinPoint) {
        MDC.put("trace_id", UUID.randomUUID().toString());
        log.info("REQUEST TRACING_ID -> {}", MDC.get("trace_id"));

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
//                    throw new ValidException(
//                            errors.getFieldErrors().get(0).getField(),
//                            errors.getFieldErrors().get(0).getDefaultMessage()
//                    );
                }
            }
        }
    }

    @AfterReturning(pointcut = "controller() || customErrorLog()", returning = "returnValue")
    public void requestLogging(JoinPoint joinPoint, Map returnValue) {
        //log.info("RESPONSE -> {}", joinPoint.getTarget());
        log.info("RESPONSE TRACING_ID -> {} / RESULT -> {}", MDC.get("trace_id"), returnValue.get("body"));
        // MDC Clear
        MDC.clear();
    }
}
