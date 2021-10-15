package eus.uni.dam;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConexionApplication {

	public static void main(String[] args) throws Exception, IOException, SQLException {
		ApplicationContext appContext=new AnnotationConfigApplicationContext(AppConfig.class);
		
		GafaDAO gafaDao=appContext.getBean(GafaTXT.class);
		
		((AnnotationConfigApplicationContext) appContext).close();
		
	}

}
