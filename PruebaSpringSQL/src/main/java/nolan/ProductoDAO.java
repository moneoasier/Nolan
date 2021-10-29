package nolan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
        return entityManager.createQuery("from Employee").getResultList();
    }
    public Employee getEmpById(long id) {
        return entityManager.find(Employee.class, id);
    }
    public void create(Employee emp) {
        entityManager.persist(emp);
        return;
    }
    
    
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
    public User getUsrById(long id) {
        return entityManager.find(User.class, id);
    }
    public void create(User usr) {
        entityManager.persist(usr);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Partner> getPartners() {
        return entityManager.createQuery("from Partner").getResultList();
    }
    public Partner getParById(long id) {
        return entityManager.find(Partner.class, id);
    }
    public void create(Partner par) {
        entityManager.persist(par);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Order> getOrders() {
        return entityManager.createQuery("from Order").getResultList();
    }
    public Order getOrdById(long id) {
        return entityManager.find(Order.class, id);
    }
    public void create(Order ord) {
        entityManager.persist(ord);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderlines() {
        return entityManager.createQuery("from OrderLine").getResultList();
    }
    public OrderLine getOrlndById(long id) {
        return entityManager.find(OrderLine.class, id);
    }
    public void create(OrderLine ordln) {
        entityManager.persist(ordln);
        return;
    }
    
}
