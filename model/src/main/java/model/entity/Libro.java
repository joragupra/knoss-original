package model.entity;

/**
 * <b>Descripci&oacute;n</b>: modela un libro almacenado en el sistema que 
 * puede ser adquirido a trav&eacute;s del portal web.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class Libro 
{

  private int idLibro;
  
  private String titulo;
  
  private int idAutor;
  
  private String idEditorial;
  
  private String idCategoria;
  
  private String isbn;
  
  private String encuadernacion;
  
  private int paginas;
  
  private String idioma;
  
  private String resumen;
  
  private String autor;
  
  private String editorial;
  
  private float precio;
  
  public Libro()
  {
  }

  public void setIdLibro(int idLibro)
  {
    this.idLibro = idLibro;
  }

  public int getIdLibro()
  {
    return idLibro;
  }

  public void setTitulo(String titulo)
  {
    this.titulo = titulo;
  }

  public String getTitulo()
  {
    return titulo;
  }

  public void setIdAutor(int idAutor)
  {
    this.idAutor = idAutor;
  }

  public int getIdAutor()
  {
    return idAutor;
  }

  public void setIdEditorial(String idEditorial)
  {
    this.idEditorial = idEditorial;
  }

  public String getIdEditorial()
  {
    return idEditorial;
  }

  public void setIdCategoria(String idCategoria)
  {
    this.idCategoria = idCategoria;
  }

  public String getIdCategoria()
  {
    return idCategoria;
  }

  public void setIsbn(String isbn)
  {
    this.isbn = isbn;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public void setEncuadernacion(String encuadernacion)
  {
    this.encuadernacion = encuadernacion;
  }

  public String getEncuadernacion()
  {
    return encuadernacion;
  }

  public void setPaginas(int paginas)
  {
    this.paginas = paginas;
  }

  public int getPaginas()
  {
    return paginas;
  }

  public void setIdioma(String idioma)
  {
    this.idioma = idioma;
  }

  public String getIdioma()
  {
    return idioma;
  }

  public void setResumen(String resumen)
  {
    this.resumen = resumen;
  }

  public String getResumen()
  {
    return resumen;
  }

  public void setAutor(String autor)
  {
    this.autor = autor;
  }

  public String getAutor()
  {
    return autor;
  }

  public void setEditorial(String editorial)
  {
    this.editorial = editorial;
  }

  public String getEditorial()
  {
    return editorial;
  }

  public void setPrecio(float precio)
  {
    this.precio = precio;
  }

  public float getPrecio()
  {
    return precio;
  }
  
}