package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaCliente {

	public static void main(String[] args) {
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Clientes.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			
			try {
				//int id = 1;
				session.beginTransaction();
				//Clientes cliente = session.get(Clientes.class, id);
				//cliente.setNombre("Cristian Camilo");
				//session.createQuery("update Clientes set apellidos='Moreno' where apellidos LIKE 'C%'")
				//	.executeUpdate();
				session.createQuery("delete Clientes  where direccion = 'Calle 19'")
					.executeUpdate();
				session.getTransaction().commit();
				System.out.println("Registro actulizado correctamente en BBDD");
				session.close();
			}finally {
				factory.close();
			}

	}

}
