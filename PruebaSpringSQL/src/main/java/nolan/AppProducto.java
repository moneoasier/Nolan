package nolan;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import clases.Categoria;
import clases.Producto;

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
		  
		  ApplicationContext appContext2 = new AnnotationConfigApplicationContext(ExportConfig.class);
		  ProductoDAO dout = appContext2.getBean(ProductoDAO.class);
		  
		  
		  for(Categoria c:categories) {
		  dout.create(c);
		  }
		 
		  for (Producto p:products) { 
			  dout.create(p);
		  }

		  
		  ((AnnotationConfigApplicationContext) appContext).close();
		  ((AnnotationConfigApplicationContext) appContext2).close();
	}

}
