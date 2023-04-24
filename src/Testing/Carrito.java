/*

package Testing;

import java.sql.*;

public class Carrito {
    public static void main(String[] args) {
        insertInto(); //este logra insertar un dato
        SelectAll(); //muestra en consola los datos que tenemos guardados

    }

    /*Estamos conectando como también mostrando todo lo de la tabla*
    public static void SelectAll(){
        //variables para poder conectarme
        String url = "jdbc:mysql://localhost:3306/qatar22";
        String username = "root";
        String password = "123456";

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            Statement statement = conection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM departamento");
            //next(): devuelve true mientras existan registros
            while (resultSet.next()){
                System.out.println(resultSet.getString("idDepartamento") +" - "+ resultSet.getString("nombreDepartamento") +" "+
                        resultSet.getString("prespuesto"));
            }
            conection.close();
            statement.close();
            resultSet.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void insertInto(){
        String url = "jdbc:mysql://localhost:3306/qatar22";
        String username = "root";
        String password = "123456";
        PreparedStatement pInsert;

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            PreparedStatement peInsert = conection.prepareStatement("INSERT INTO departamento(nombreDepartamento, prespuesto)" +
                    "VALUES (?,?)");

            peInsert.setString(1, "a");
            peInsert.setString(2, "30");

            peInsert.executeUpdate();


            conection.close();
            peInsert.close();


        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    

}
*/