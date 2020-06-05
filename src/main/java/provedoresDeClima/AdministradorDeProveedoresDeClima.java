package provedoresDeClima;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AdministradorDeProveedoresDeClima {
    List<ProveedorDeClima> proveedores;
    ProveedorDeClima proveedor;


    void seleccionarProveedorAleatorio(){
        Random rand = new Random();
        proveedor =  proveedores.get(rand.nextInt(proveedores.size()));
    }

    void seleccionarProveedorEconomico(){
        proveedor = proveedores.stream().min(Comparator.comparingDouble(ProveedorDeClima::getComisionDeServicio)).get();
    }


    public ProveedorDeClima getProveedorUtilizado() {
        return proveedor;
    }
}
