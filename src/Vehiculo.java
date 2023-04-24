public class Vehiculo {
    private String patente;
    private String nombreVehiculo;
    private int modelo;
    private int precio;

    public Vehiculo(){

    }
    public Vehiculo(String patente, String nombreVehiculo, int modelo,int precio){
        this.patente = patente;
        this.nombreVehiculo = nombreVehiculo;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getPatente() {
        return patente;
    }
    public String setPatante(){
        return patente;
    }
    public String getNombreVehiculo(){
        return nombreVehiculo;
    }
    public String setNombreVehiculo(){
        return nombreVehiculo;
    }
    public int getModelo(){
        return modelo;
    }
    public int setModelo(){return modelo;}
    public int getPrecio(){return precio;}
    public int setPrecio(){return precio;}



}
