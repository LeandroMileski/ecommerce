package dev.leandro.ecommerce.exception;

public class CreateOrderException extends RuntimeException{

    public CreateOrderException(String message) {
        super(message);
    }
}
