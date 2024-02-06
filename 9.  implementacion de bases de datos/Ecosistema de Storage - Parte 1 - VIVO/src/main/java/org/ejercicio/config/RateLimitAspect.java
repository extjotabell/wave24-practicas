package org.ejercicio.config;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RateLimitAspect {

    @AfterThrowing(
            pointcut = "execution(* org.ejercicio.KVS.UserKVSRepository.*(..))",
            throwing = "ex"
    )
    public void logRateLimitExceeded(Exception ex) {
        // Lógica para registrar el error de rate limit en el log
    }
}
