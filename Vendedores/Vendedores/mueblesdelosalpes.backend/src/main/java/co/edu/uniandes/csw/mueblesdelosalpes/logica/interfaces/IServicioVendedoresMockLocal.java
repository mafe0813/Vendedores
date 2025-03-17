/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioVendedoresMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import java.util.List;
import javax.ejb.Local;

/**
 * Contrato funcional de los servicios de administración de los vendedores del
 * sistema
 *
 * @author Juan Sebastián Urrego
 */
@Local
public interface IServicioVendedoresMockLocal {

    /**
     * Agrega un vendedor al sistema
     *
     * @param vendedor Nuevo vendedor
     * 
     */
    public void agregarVendedor(Vendedor vendedor);

    /**
     * Elimina un vendedor del sistema
     *
     * @param id Número de identificación único del cliente
     * 
     */
    public void eliminarVendedor(long id);

    /**
     * Devuelve todos los vendedores del sistema
     *
     * @return vendedores Vendedores del sistema
     */
    public List<Vendedor> getVendedores();

    public void actualizarVendedor(Vendedor vendedor);
}
