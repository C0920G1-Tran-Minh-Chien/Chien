package com.codegym.muon_sach;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.muon_sach.service.BookService(..))",
            throwing = "ex")
    public void error(Exception ex) {
        System.err.println("lỗi");
    }
}
