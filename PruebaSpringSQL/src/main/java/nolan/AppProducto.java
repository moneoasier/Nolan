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
		  
		  for (Producto p:products) { System.out.println(p); }
		 
		 
		  for(Categoria c:categories) {
			  System.out.println(c);
		  }

		((AnnotationConfigApplicationContext) appContext).close();

	}

}
