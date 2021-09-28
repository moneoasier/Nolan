package eus.uni.dam;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConexionApplication {

	public static void main(String[] args) throws Exception, IOException, SQLException {
		GafaTXT cargar=new GafaTXT();
		
		cargar.init();
		cargar.destroy();
		
	}

}
