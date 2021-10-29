package nolan;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppProducto {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(DbConfig.class);

		ProductoDAO dao = appContext.getBean(ProductoDAO.class);
		/* edo horrela:
		 * @Autowired
		 * PeliculaDao peliDao;
		 */	

		//Pelikulen taulako datuak berreskuratu 

		List<Producto> products = dao.getProducts(); 
		List<Categoria> categories=dao.getCategories();
		List<Partner> partners=dao.getPartners();
		List<User> users = dao.getUsers();
		List<Employee> employees=dao.getEmployees();
		List<Order> orders= dao.getOrders();
		List<OrderLine> orderlines=dao.getOrderlines();
		
		ApplicationContext appContext2 = new AnnotationConfigApplicationContext(ExportConfig.class);
		ProductoDAO dout = appContext2.getBean(ProductoDAO.class);


		for(Categoria c:categories) { dout.create(c); }
		for (Producto p:products) { dout.create(p); }
		for(Partner p:partners) {dout.create(p);}
		for (User u:users) { dout.create(u); }
		for ( Employee e: employees) {dout.create(e);}
		for(Order o:orders) { dout.create(o);}
		for(OrderLine ol:orderlines) {dout.create(ol);}

		((AnnotationConfigApplicationContext) appContext).close();
		((AnnotationConfigApplicationContext) appContext2).close();
	}

}
