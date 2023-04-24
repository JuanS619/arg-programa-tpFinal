public class Cliente {
    private int dni;
    private String datosCliente;
    private int vehiculo;
    private int precio;
    private int empleado_id;


    public Cliente(){

    }

    public Cliente(int dni, String datosClientes){
        this.dni = dni;
        this.datosCliente = datosClientes;
    }

    public int GetDni(){
        return dni;
    }
    public int SetDni(){
        return dni;
    }
    public String GetDatosCliente(){
        return datosCliente;
    }
    public String SetDatosCliente(){
        return datosCliente;
    }
    public int Getvehiculo(){
        return vehiculo;
    }
    public int Getprecio(){
        return precio;
    }
    public int Getempleado_id(){
        return empleado_id;
    }




}
