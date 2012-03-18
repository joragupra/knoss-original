package model.exceptions;

public class NoSuchEntityException extends RuntimeException 
{

  public NoSuchEntityException(String mensaje)
  {
    super(mensaje);
  }
  
}