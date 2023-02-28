package org.geon.study.common.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LogAdvice {

    @Before(value = "execution(* org.geon.study..*.*Service*.*(..))")
    public void logBefore() {
        log.info("-------------AOP---------------");
    }
}
