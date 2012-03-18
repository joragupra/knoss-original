package model.exceptions;

public class ObjectNotFoundException extends FinderException 
{

  public ObjectNotFoundException(String mensaje)
  {
    super(mensaje);
  }
  
}