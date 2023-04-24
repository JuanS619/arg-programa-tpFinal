public class Vendedor {
    private int dni;
    private String datosVendedor;
    private String apellidoVendedor;
    private int telefono;
    public Vendedor(){

    }
    public Vendedor(int dni, String datosVendedor){
        this.dni = dni;
        this.datosVendedor = datosVendedor;
    }
    public int GetDni(){
        return dni;
    }
    public int SetDni(){
        return dni;
    }
    public String GetDatosVendedor(){
        return datosVendedor;
    }
    public String SetDatosVendedor(){
        return datosVendedor;
    }
    public String GetApellido(){
        return apellidoVendedor;
    }
    public String SetApellido(){
        return apellidoVendedor;
    }
    public int GetTEL(){
        return telefono;
    }
    public int SetTEL(){return telefono;}

}
