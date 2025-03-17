/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioVendedoresMockRemote.java
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
import javax.ejb.Remote;

/**
 * Contrato funcional de los servicios de administración de los vendedores del sistema
 * @author Juan Sebastián Urrego
 */
@Remote
public interface IServicioVendedoresMockRemote
{
    /**
     * Agrega un vendedor al sistema
     * @param vendedor Nuevo vendedor
     * @throws OperacionInvalidaException Excepción lanzada en caso de error operacional
     */
    public void agregarVendedor(Vendedor vendedor);

    /**
     * Elimina un vendedor del sistema
     * @param id Número de identificación único del cliente
     * @throws OperacionInvalidaException Excepción lanzada en caso de error operacional
     */
    public void eliminarVendedor(long id);

    /**
     * Devuelve todos los vendedores del sistema
     * @return vendedores Vendedores del sistema
     */
    public List<Vendedor> getVendedores();
    
    public void actualizarVendedor(Vendedor vendedor);
}
