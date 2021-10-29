package nolan;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DataApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(ImportConfig.class);

		ManagementDAO dao = appContext.getBean(ManagementDAO.class);
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
		ManagementDAO dout = appContext2.getBean(ManagementDAO.class);


		for(Categoria c:categories) { dout.update(c); }
		for (Producto p:products) { dout.update(p); }
		for(Partner p:partners) {dout.update(p);}
		for (User u:users) { dout.update(u); }
		for ( Employee e: employees) {dout.update(e);}
		for(Order o:orders) { dout.update(o);}
		for(OrderLine ol:orderlines) {dout.update(ol);}

		((AnnotationConfigApplicationContext) appContext).close();
		((AnnotationConfigApplicationContext) appContext2).close();
	}

}
