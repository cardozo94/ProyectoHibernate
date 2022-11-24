package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaCliente {

	public static void main(String[] args) {
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Clientes.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			
			try {
				Clientes cliente1 = new Clientes("Franciso", "Cardozo", "Calle 19");
				session.beginTransaction();
				session.save(cliente1);	
				session.getTransaction().commit();
				System.out.println("Registro insertado correctamente en BBDD");
				
				//lectura de registro
				session.beginTransaction();
				System.out.println("Lectura del registro con Id: "+cliente1.getId());
				Clientes clienteInsertado = session.get(Clientes.class, cliente1.getId());
				System.out.println("Registro: "+clienteInsertado.toString());
				session.getTransaction().commit();
				System.out.println("Terminado!");
				session.close();
			}finally {
				factory.close();
			}

	}

}
