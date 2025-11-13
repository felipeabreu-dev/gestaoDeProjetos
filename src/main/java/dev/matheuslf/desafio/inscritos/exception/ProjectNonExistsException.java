package dev.matheuslf.desafio.inscritos.exception;

public class ProjectNonExistsException extends RuntimeException {
  public ProjectNonExistsException(String message) {
    super(message);
  }
}
