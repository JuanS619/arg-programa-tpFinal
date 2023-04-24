import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variable para poder digitar opcion de mi switch and if
        Scanner mi_opcion = new Scanner(System.in);

        //lo que buscamos es un menu en donde este por una parte el menu para ver autos, compras
        //por otro lado tener empleados, ventas
        System.out.println("Digite una opción para acceder al menú: \n1. Compra\n2. Acceso a administración");
        int opcionMenu = mi_opcion.nextInt();
        if(opcionMenu == 1){
            System.out.println("Digite una opción del menú: \n1. Ver vehiculos disponibles.\n2.Agregar compra\n");
            int opcion = mi_opcion.nextInt();
            switch (opcion){
                case 1:
                    SelectAll_vehiculos();
                    break;
                case 2:
                    InsertInto_buy();
                    break;
                default:
                    break;
            }
        }
        else if (opcionMenu == 2) {
            System.out.println("Digite una opción del menú: \n1. Staf de vendedores.\n2.Agregar nuevo empleado\n3. Agregar nuevo vehiculo\n" +
                    "4. Ver ventas");
            int opcion = mi_opcion.nextInt();
            switch (opcion){
                case 1:
                    SelectAll_employee();
                    break;
                case 2:
                    InsertInto_Newmployee();
                    break;
                case 3:
                    InsertInto_NewCar();
                    break;
                case 4:
                    System.out.println("dni client, name client, cod car, price car, cod employee");
                    SelectAll_Sales();
                default:
                    break;
            }
        }
        else{
            System.out.println("Opcion digitada fuera del rango");
        }


    }
    //CONEXION A SQL PARA VER VEHICULOS, AGREGAR NEW COMPRA
    public static void SelectAll_vehiculos(){
        //variables para poder conectarme
        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            Statement statement = conection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehiculos");
            //next(): devuelve true mientras existan registros
            while (resultSet.next()){
                System.out.println(resultSet.getString("patente_vehiculo") +" - "+ resultSet.getString("marca_vehiculo") +" - "+
                        resultSet.getString("modelo_vehiculo") +" - "+
                        resultSet.getString("precio_vehiculo"));
            }
            conection.close();
            statement.close();
            resultSet.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void InsertInto_buy(){
        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";
        PreparedStatement pInsert;
        //SCANNER
        Scanner dniIn = new Scanner(System.in);
        Scanner nombreIn = new Scanner(System.in);
        Scanner vehiculoIn = new Scanner(System.in);
        Scanner precioIn = new Scanner(System.in);
        Scanner empleadoIn = new Scanner(System.in);
        //OBJETOS
        Cliente obj_cliente = new Cliente();
        int dni = obj_cliente.GetDni();
        String nombre = obj_cliente.GetDatosCliente();
        int vehiculo = obj_cliente.Getvehiculo();
        int precio = obj_cliente.Getprecio();
        int empleado = obj_cliente.Getempleado_id();

        System.out.println("DNI Cliente: ");
        dni = dniIn.nextInt();
        System.out.println("Nombre cliente: ");
        nombre = nombreIn.next();
        System.out.println("Codigo vehiculo: ");
        vehiculo = vehiculoIn.nextInt();
        System.out.println("Precio vehiculo: ");
        precio = precioIn.nextInt();
        System.out.println("ID Empleado: ");
        empleado = empleadoIn.nextInt();

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            PreparedStatement peInsert = conection.prepareStatement(
                    "INSERT INTO compra(dni_comprador, nombre_comprador, id_vehiculoFK, valor, id_empleadoFK)" +
                    "VALUES (?,?,?,?,?)");

            peInsert.setInt(1, dni);
            peInsert.setString(2, nombre);
            peInsert.setInt(3, vehiculo);
            peInsert.setInt(4, precio);
            peInsert.setInt(5, empleado);

            peInsert.executeUpdate();


            conection.close();
            peInsert.close();


        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //CONEXION A SQL PARA VER VER_EMPLEADO, AGREGAR NUEVO EMPLEADO, AGREGAR NUEVO VEHICULO
    public static void SelectAll_Sales(){
        //variables para poder conectarme
        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            Statement statement = conection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM compra");
            //next(): devuelve true mientras existan registros
            while (resultSet.next()){
                System.out.println(resultSet.getString("dni_comprador") +" - "+
                        resultSet.getString("nombre_comprador") +" - "+
                        resultSet.getString("id_vehiculoFK") +" - "+
                        resultSet.getString("valor") +" - "+
                        resultSet.getString("id_empleadoFK"));
            }
            conection.close();
            statement.close();
            resultSet.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void SelectAll_employee(){
        //variables para poder conectarme
        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            Statement statement = conection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM vendedores");
            //next(): devuelve true mientras existan registros
            while (resultSet.next()){
                System.out.println(resultSet.getString("document_vendedor") +" - "+
                            resultSet.getString("nombre_vendedor") +" - "+
                            resultSet.getString("apellido_vendedor") +" - "+
                            resultSet.getString("telefono"));
            }
            conection.close();
            statement.close();
            resultSet.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void InsertInto_Newmployee(){

        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";
        PreparedStatement pInsert;
        //SCANNERS PARA PODER DIGITAR VALORES
        Scanner dniIn = new Scanner(System.in);
        Scanner nombreEmpIn = new Scanner(System.in);
        Scanner apellidoIn = new Scanner(System.in);
        Scanner telefonoIn = new Scanner(System.in);

        //INSTANCIAMSO OBJETOS
        Vendedor obj_vendedor = new Vendedor();
        int dni = obj_vendedor.GetDni();
        String nombreEmp = obj_vendedor.GetDatosVendedor();
        String apellidoEmp = obj_vendedor.GetApellido();
        int telefono = obj_vendedor.GetTEL();

        System.out.println("Ingresar DNI de empleado: ");
        dni = dniIn.nextInt();
        System.out.println("Ingrese nombre de empleado: ");
        nombreEmp = nombreEmpIn.next();
        System.out.println("Ingrese apellido de empleado: ");
        apellidoEmp = apellidoIn.next();
        System.out.println("Ingrese telefono: ");
        telefono = telefonoIn.nextInt();



        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            PreparedStatement peInsert = conection.prepareStatement(
                    "INSERT INTO vendedores(document_vendedor, nombre_vendedor, apellido_vendedor, telefono )" +
                    "VALUES (?,?,?,?)");

            peInsert.setInt(1, dni);
            peInsert.setString(2, nombreEmp);
            peInsert.setString(3, apellidoEmp);
            peInsert.setInt(4, telefono);

            peInsert.executeUpdate();

            conection.close();
            peInsert.close();


        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void InsertInto_NewCar(){
        String url = "jdbc:mysql://localhost:3306/concesionaria_pepito";
        String username = "root";
        String password = "123456";
        PreparedStatement pInsert;
        //SCANNER
        Scanner patenteIn = new Scanner(System.in);
        Scanner marcaIn = new Scanner(System.in);
        Scanner modeloIn = new Scanner(System.in);
        Scanner precioIn = new Scanner(System.in);

        //INSTANCIAMOS EL OBJ DEL MAL
        Vehiculo obj_vehiculo = new Vehiculo();
        String patente = obj_vehiculo.getPatente();
        String marca = obj_vehiculo.getNombreVehiculo();
        int modelo = obj_vehiculo.getModelo();
        int precio = obj_vehiculo.getPrecio();

        System.out.println("Digite patente vehiculo: ");
        patente = patenteIn.next();
        System.out.println("Digite marca vehiculo: ");
        marca = marcaIn.next();
        System.out.println("Digite modelo vehiculo: ");
        modelo = modeloIn.nextInt();
        System.out.println("Digite precio vehiculo: ");
        precio = precioIn.nextInt();

        try {
            Connection conection = DriverManager.getConnection(url, username,password);
            //statement usa la variable conection para poder conectar a bd
            PreparedStatement peInsert = conection.prepareStatement(
                    "INSERT INTO vehiculos(patente_vehiculo, marca_vehiculo, modelo_vehiculo, precio_vehiculo )" +
                    "VALUES (?,?,?,?)");

            peInsert.setString(1, patente);
            peInsert.setString(2, marca);
            peInsert.setInt(3, modelo);
            peInsert.setInt(4, precio);

            peInsert.executeUpdate();

            conection.close();
            peInsert.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
