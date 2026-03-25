import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="RIBERA";
        String password="ribera";


        try (Connection conn = DriverManager.getConnection(url,user,password)){
            String sql="UPDATE empleado2 SET salario=? WHERE nombre=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, 4000.0);
            preparedStatement.setString(2, "Antonio");
            int filas = preparedStatement.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}