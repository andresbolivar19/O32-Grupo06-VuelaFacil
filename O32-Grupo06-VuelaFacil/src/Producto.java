import java.sql.*;

public class Producto {
    // Variables de conexion a la base de datos
    Connection c = null;
    Statement stmt = null;

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
     c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vuelafacil","root","");
  
       stmt = c.createStatement();
            
      String sql = "select * from productos where id=" + id;
        ResultSet rs  = stmt.executeQuery(sql);
       while (rs.next()){
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setTemperatura(rs.getDouble("temperatura"));
        p.setValorBase(rs.getDouble("valorBase"));
       
       } 
        stmt.close();
        c.close();  
    }catch (Exception e){
    System.err.println(e.getClass().getName() + ": " + e.getMessage() );
    }   
}
