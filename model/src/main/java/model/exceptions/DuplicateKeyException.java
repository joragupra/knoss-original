package model.exceptions;

public class DuplicateKeyException extends CreateException 
{

  public DuplicateKeyException(String mensaje)
  {
    super(mensaje);
  }
  
}