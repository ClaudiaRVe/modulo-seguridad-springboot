package pe.isil.seguridad;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion =
                DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EP1DESA1",
                "root",
                "ignale10"
        );


        //CREAR REGISTRO:
        Statement stCreate = conexion.createStatement();
        int filasAfectadas=
                stCreate.executeUpdate("INSERT INTO USERS VALUES (4,'Rosario','DNI994755896','DNI','994755896',1)");

        System.out.println("Filas afectadas:" + filasAfectadas);

        PreparedStatement preparedStatement =
                conexion.prepareStatement("select * from Users where id=?");

        preparedStatement.setString(1, String.valueOf(1));

        ResultSet resultSet2 = preparedStatement.executeQuery();

        while (resultSet2.next()){
        System.out.println(resultSet2.getString("id") + "\n"+
             resultSet2.getString("nombre") + "\n"+
             resultSet2.getString("usuario") + "\n"+
             resultSet2.getString("tipDoc")+ "\n"+
             resultSet2.getString("nroDoc"));




        //ACTUALIZAR REGISTROS:

            Statement stCreate = conexion.createStatement();
            int filasAfectadas=stCreate.executeUpdate("UPDATE USERS SET NOMBRE='Sandra' WHERE ID=1");
            System.out.println("Filas afectadas: " + filasAfectadas);
            PreparedStatement preparedStatement =
                   conexion.prepareStatement("select * from Users where id=?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            while(resultSet2.next()){
               System.out.println(resultSet2.getString("nombre") + "\n"+
                      resultSet2.getString("usuario") + "\n"+
                      resultSet2.getString("tipDoc") + "\n"+
                      resultSet2.getString("nroDoc"));
            }
            conexion.close();



        //LISTAR REGISTROS:

        CallableStatement callSp = conexion.prepareCall("{call listarAllUsers()}");
        ResultSet resultSetSP = callSp.executeQuery();

       while (resultSetSP.next())
        {
              System.out.println(resultSetSP.getString("nombre"));
        }
        }




    }
}






