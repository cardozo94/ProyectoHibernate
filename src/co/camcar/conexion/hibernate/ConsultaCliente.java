package co.camcar.conexion.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaCliente {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session session= sessionFactory.openSession();
		try {
			//comenzar sesión
			session.beginTransaction();
			//consulta de clientes
			List<Clientes> clientes;
			query(session, "from Clientes");
			//consulta con criterio
			query(session, "from Clientes c where c.nombre='Camilo'");
			//	
			query(session, "from Clientes c where c.nombre='Camilo' or c.direccion='Calle 19'");
			//commit
			session.getTransaction().commit();
			//cerrar sesión
			session.close();
		}finally {
			sessionFactory.close();
		}

	}

	private static void query(Session session, String query) {
		List<Clientes> clientes = session.createQuery(query).getResultList();
		//mostrar los clientes
		for(Clientes cliente: clientes) {
			System.out.println(cliente);
		}
	}

}
