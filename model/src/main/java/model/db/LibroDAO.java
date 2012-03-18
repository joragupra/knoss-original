package model.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.entity.Libro;

/**
 * <b>Descripci&oacute;n</b>: clase que controla los accesos a la base de datos 
 * que tengan relaci&oacute;n con los libros almacenados en el sistema.
 * @author Jorge Agudo Praena
 * @version 1.2
 */
public class LibroDAO 
{

  private Connection con;
  
  public LibroDAO(Connection con)
  {
    this.con = con;
  }
  
  public Collection buscaPorClavePrimaria(int idLibro)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS l, JORAGUPRA_AUTORES a, JORAGUPRA_EDITORIALES e " + 
                      "WHERE l.id_autor = a.id_autor AND " +
                      "l.id_editorial = e.id_editorial AND " +
                      "l.id_libro = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setInt(1, idLibro);
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Libro l = new Libro();
        l.setIdLibro(rs.getInt(1));
        l.setTitulo(rs.getString(2));
        l.setIdAutor(rs.getInt(3));
        l.setIdEditorial(rs.getString(4));
        l.setIdCategoria(rs.getString(5));
        l.setIsbn(rs.getString(6));
        l.setEncuadernacion(rs.getString(7));
        l.setPaginas(rs.getInt(8));
        l.setIdioma(rs.getString(9));
        l.setPrecio(rs.getFloat(10));
        l.setResumen(rs.getString(11));
        String nombre = rs.getString(13);
        String apellido1 = rs.getString(14);
        String apellido2 = "";
        if(rs.getString(15)!=null){
          apellido2 = " " + rs.getString(15);
        }
        String autor = apellido1 + apellido2 + ", " + nombre;
        l.setAutor(autor);
        l.setEditorial(rs.getString(20));
        
        result.add(l);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
  public Collection buscaPorAutor(String autor)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS l, JORAGUPRA_AUTORES a, JORAGUPRA_EDITORIALES e " + 
                      "WHERE l.id_autor = a.id_autor AND " +
                      "l.id_editorial = e.id_editorial AND " +
                      "(((a.nombre || ' ' || a.apellido1) = ?) OR " +
                      "(a.apellido1 = ?) OR " +
                      "(a.apellido2 = ?)) ORDER BY titulo";

    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, autor);
      ps.setString(2, autor);
      ps.setString(3, autor);
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Libro l = new Libro();
        l.setIdLibro(rs.getInt(1));
        l.setTitulo(rs.getString(2));
        l.setIdAutor(rs.getInt(3));
        l.setIdEditorial(rs.getString(4));
        l.setIdCategoria(rs.getString(5));
        l.setIsbn(rs.getString(6));
        l.setEncuadernacion(rs.getString(7));
        l.setPaginas(rs.getInt(8));
        l.setIdioma(rs.getString(9));
        l.setPrecio(rs.getFloat(10));
        l.setResumen(rs.getString(11));
        String nombre = rs.getString(13);
        String apellido1 = rs.getString(14);
        String apellido2 = "";
        if(rs.getString(15)!=null){
          apellido2 = " " + rs.getString(15);
        }
        String nombreAutor = apellido1 + apellido2 + ", " + nombre;
        l.setAutor(nombreAutor);
        l.setEditorial(rs.getString(20));

        result.add(l);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
  public Collection buscaPorIsbn(String isbn)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS l, JORAGUPRA_AUTORES a, JORAGUPRA_EDITORIALES e, JORAGUPRA_CATEGORIAS c " + 
                    "WHERE l.id_autor = a.id_autor AND " +
                    "l.id_editorial = e.id_editorial AND " +
                    "l.id_categoria = c.id_categoria AND " + 
                    "l.isbn = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, isbn);
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Libro l = new Libro();
        l.setIdLibro(rs.getInt(1));
        l.setTitulo(rs.getString(2));
        l.setIdAutor(rs.getInt(3));
        l.setIdEditorial(rs.getString(4));
        l.setIdCategoria(rs.getString(5));
        l.setIsbn(rs.getString(6));
        l.setEncuadernacion(rs.getString(7));
        l.setPaginas(rs.getInt(8));
        l.setIdioma(rs.getString(9));
        l.setPrecio(rs.getFloat(10));
        l.setResumen(rs.getString(11));
        String nombreAutor = rs.getString(13);
        String apellido1 = rs.getString(14);
        String apellido2 = "";
        if(rs.getString(15)!=null){
          apellido2 = " " + rs.getString(15);
        }
        String autor = apellido1 + apellido2 + ", " + nombreAutor;
        l.setAutor(autor);
        l.setEditorial(rs.getString(20));
        
        result.add(l);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
  public Collection buscaPorTitulo(String titulo)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS l, JORAGUPRA_AUTORES a, JORAGUPRA_EDITORIALES e, JORAGUPRA_CATEGORIAS c " + 
                    "WHERE l.id_autor = a.id_autor AND " +
                    "l.id_editorial = e.id_editorial AND " +
                    "l.id_categoria = c.id_categoria AND " + 
                    "l.titulo = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, titulo);
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Libro l = new Libro();
        l.setIdLibro(rs.getInt(1));
        l.setTitulo(rs.getString(2));
        l.setIdAutor(rs.getInt(3));
        l.setIdEditorial(rs.getString(4));
        l.setIdCategoria(rs.getString(5));
        l.setIsbn(rs.getString(6));
        l.setEncuadernacion(rs.getString(7));
        l.setPaginas(rs.getInt(8));
        l.setIdioma(rs.getString(9));
        l.setPrecio(rs.getFloat(10));
        l.setResumen(rs.getString(11));
        String nombreAutor = rs.getString(13);
        String apellido1 = rs.getString(14);
        String apellido2 = "";
        if(rs.getString(15)!=null){
          apellido2 = " " + rs.getString(15);
        }
        String autor = apellido1 + apellido2 + ", " + nombreAutor;
        l.setAutor(autor);
        l.setEditorial(rs.getString(20));
        
        result.add(l);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
  public Collection buscaPorCategoria(String nombre)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS l, JORAGUPRA_AUTORES a, JORAGUPRA_EDITORIALES e, JORAGUPRA_CATEGORIAS c " + 
                    "WHERE l.id_autor = a.id_autor AND " +
                    "l.id_editorial = e.id_editorial AND " +
                    "l.id_categoria = c.id_categoria AND " + 
                    "c.nombre = ? ORDER BY titulo";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, nombre);
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Libro l = new Libro();
        l.setIdLibro(rs.getInt(1));
        l.setTitulo(rs.getString(2));
        l.setIdAutor(rs.getInt(3));
        l.setIdEditorial(rs.getString(4));
        l.setIdCategoria(rs.getString(5));
        l.setIsbn(rs.getString(6));
        l.setEncuadernacion(rs.getString(7));
        l.setPaginas(rs.getInt(8));
        l.setIdioma(rs.getString(9));
        l.setPrecio(rs.getFloat(10));
        l.setResumen(rs.getString(11));
        String nombreAutor = rs.getString(13);
        String apellido1 = rs.getString(14);
        String apellido2 = "";
        if(rs.getString(15)!=null){
          apellido2 = " " + rs.getString(15);
        }
        String autor = apellido1 + apellido2 + ", " + nombreAutor;
        l.setAutor(autor);
        l.setEditorial(rs.getString(20));
        
        result.add(l);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
}