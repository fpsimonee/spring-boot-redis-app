package br.com.spring.cache.demo.exception;

public class PostNotFoundException extends Exception{
    public PostNotFoundException(String message) {
        super(message);
    }
}
