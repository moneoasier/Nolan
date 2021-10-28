package nolan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import clases.Categoria;
import clases.Producto;

@Repository
@Transactional  //Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan, transakzioa bukatu 
public class ProductoDAO {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los productos de la base de datos
     */
    @SuppressWarnings("unchecked")
    public List<Producto> getProducts() {
        return entityManager.createQuery("from Producto").getResultList();
    }

    /**
     * Devuelve un producto en base a su Id
     */
    public Producto getProdById(long id) {
        return entityManager.find(Producto.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Categoria> getCategories() {
    	return entityManager.createQuery("from Categoria").getResultList();
    }

    public Categoria getCatById(long id) {
        return entityManager.find(Categoria.class, id);
    }
    
    public void create(Categoria cat) {
        entityManager.persist(cat);
        return;
    }
    
    public void create(Producto prod) {
        entityManager.persist(prod);
        return;
    }
}
