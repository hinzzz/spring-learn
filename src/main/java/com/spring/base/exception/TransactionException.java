package com.spring.base.exception;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/16 10:57
 */
public class TransactionException extends RuntimeException{
    public TransactionException(String message) {
        super(message);
    }
}
