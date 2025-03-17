package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Vendedores")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendedoresService {

    @EJB
    private IServicioVendedoresMockLocal vendedoresEjb;

    @GET
    @Path("vendedores/")
    public List<Vendedor> getTodosLosVendedores() {
        return vendedoresEjb.getVendedores();
    }

    @POST
    @Path("agregar/")
    public void agregarVendedor(Vendedor vendedor) {
        vendedoresEjb.agregarVendedor(vendedor);
    }
    
    @DELETE
    @Path("eliminar/{id}")
    public void eliminarVendedor(@PathParam("id") long id) {
        vendedoresEjb.eliminarVendedor(id);
    }
    
    @PUT
    @Path("actualizar/")
    public void actualizarVendedor(Vendedor vendedor) {
        vendedoresEjb.actualizarVendedor(vendedor);
    }

}
