package dev.matheuslf.desafio.inscritos.exception;

public class UserExistsException extends RuntimeException {
  public UserExistsException(String message) {
    super(message);
  }
}
