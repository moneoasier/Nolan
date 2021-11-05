package nolan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional  //Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan, transakzioa bukatu 
public class ManagementDAO {

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
    public void update(Producto prod) {
    	entityManager.merge(prod);
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
    
    public void update(Categoria cat) {
    	entityManager.merge(cat);
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
    public void update(Employee emp) {
    	entityManager.merge(emp);
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
    public void update(User usr) {
        entityManager.merge(usr);
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
    public void update(Partner par) {
        entityManager.merge(par);
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
    public void update(Order ord) {
        entityManager.merge(ord);
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
    
    public void update(OrderLine ordln) {
        entityManager.merge(ordln);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<AppUser> getAppUsers() {
        return entityManager.createQuery("from AppUser").getResultList();
    }
    public AppUser getAppUsers(String email) {
        return entityManager.find(AppUser.class, email);
    }
    public void create(AppUser appu) {
        entityManager.persist(appu);
        return;
    }
    
    public void update(AppUser appu) {
        entityManager.merge(appu);
        return;
    }
    
}
