package dev.matheuslf.desafio.inscritos.exception;

public class TaskNonExistsException extends RuntimeException {
  public TaskNonExistsException(String message) {
    super(message);
  }
}
