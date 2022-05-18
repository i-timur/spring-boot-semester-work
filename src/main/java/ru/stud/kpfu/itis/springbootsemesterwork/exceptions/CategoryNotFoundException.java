package ru.stud.kpfu.itis.springbootsemesterwork.exceptions;

public class CategoryNotFoundException extends RuntimeException  {

  public CategoryNotFoundException(String message) {
    super(message);
  }
}
