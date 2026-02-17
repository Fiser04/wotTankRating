package com.fiser.wottankrating.Controller;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            CannotCreateTransactionException.class,
            DataAccessResourceFailureException.class,
            java.net.ConnectException.class
    })
    public ModelAndView handleDatabaseDown(Exception ex) {
        System.out.println("LOG: Database is offline - Redirecting to error page.");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("db-error");
        return mav;
    }
}
