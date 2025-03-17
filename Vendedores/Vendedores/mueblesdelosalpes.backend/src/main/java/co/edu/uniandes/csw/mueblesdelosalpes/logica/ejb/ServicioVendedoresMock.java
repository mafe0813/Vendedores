/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioVendedoresMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockRemote;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de administración de un vendedor en el
 * sistema
 *
 * @author Juan Sebastián Urrego
 */
@Stateless
public class ServicioVendedoresMock implements IServicioVendedoresMockLocal, IServicioVendedoresMockRemote {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase sin argumentos
     */
    public ServicioVendedoresMock() {
        persistencia = new ServicioPersistenciaMock();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un vendedor al sistema
     *
     * @param vendedor Nuevo vendedor
     * @throws OperacionInvalidaException Excepción lanzada en caso de error
     */
    @Override
    public void agregarVendedor(Vendedor vendedor) {
        try {
            persistencia.create(vendedor);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioVendedoresMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina un vendedor del sistema dado su ID
     *
     * @param id Identificador único del vendedor
     * @throws OperacionInvalidaException Excepción lanzada en caso de error
     */
    @Override
    public void eliminarVendedor(long id) {
        Vendedor v = (Vendedor) persistencia.findById(Vendedor.class, id);
        try {
            persistencia.delete(v);
        } catch (OperacionInvalidaException ex) {
        }
    }

    /**
     * Devuelve todos los vendedores del sistema
     *
     * @return vendedores Vendedores del sistema
     */
    @Override
    public List<Vendedor> getVendedores() {
        return persistencia.findAll(Vendedor.class);
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        try {
            Vendedor vendedorExistente = (Vendedor) persistencia.findById(Vendedor.class, vendedor.getIdentificacion());

            if (vendedorExistente != null) {
                vendedorExistente.setNombres(vendedor.getNombres());
                vendedorExistente.setApellidos(vendedor.getApellidos());
                vendedorExistente.setExperiencia(vendedor.getExperiencia());
                vendedorExistente.setSalario(vendedor.getSalario());
                vendedorExistente.setComisionVentas(vendedor.getComisionVentas());
                vendedorExistente.setPerfil(vendedor.getPerfil());
                vendedorExistente.setFoto(vendedor.getFoto());

                persistencia.update(vendedorExistente);
            } else {
                throw new OperacionInvalidaException("El vendedor con ID " + vendedor.getIdentificacion() + " no existe.");
            }
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioVendedoresMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
