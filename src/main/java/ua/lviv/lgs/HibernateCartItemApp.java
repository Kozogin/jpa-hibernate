package ua.lviv.lgs;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateCartItemApp {

	public static void main(String[] args) {		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
//-----------------------------------------------------------------------------------------
		//filling DB
		Cart cart1 = new Cart(12_258.05, "home");
		Cart cart2 = new Cart(85_854.5, "job");
		Cart cart3 = new Cart(21_581.35, "different");
		
		double [] arrTotalItem = {528.32, 105.4, 52.8, 1580.5, 3358.0, 75.85, 328.72};		
		for (int i = 0; i < arrTotalItem.length; i++) {			
			session.persist(new Item(arrTotalItem[i]));
		}
		
		session.persist(cart1);
		session.persist(cart2);
		session.persist(cart3);
//-----------------------------------------------------------------------------------------
		
//-----------------------------------------------------------------------------------------	
		//cart select items
//		Cart cartSelect = (Cart)session.get(Cart.class, 2);
//		Item item1 = (Item)session.get(Item.class, 1);
//		Item item2 = (Item)session.get(Item.class, 2);
//		Item item3 = (Item)session.get(Item.class, 4);
//		Item item4 = (Item)session.get(Item.class, 7);
//		
//		cartSelect.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
//-----------------------------------------------------------------------------------------
		
		transaction.commit();		
		
		session.close();

	}

}

