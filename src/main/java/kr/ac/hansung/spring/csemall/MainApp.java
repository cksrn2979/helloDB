package kr.ac.hansung.spring.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"kr/ac/hansung/spring/csemall/beans/beans.xml");

		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");
		System.out.println("The Row Count : " + offerDAO.getRowCount());

		List<Offer> offerList = offerDAO.getOffers();

		for (Offer offer : offerList) {
			System.out.println(offer);
		}

		Offer offer= new Offer("changoo", "cksrn2979@naver.com", "Hello World!");
		if(offerDAO.insert(offer))
			System.out.println("Object is inserted succefully");
		else
			System.out.println("Object insertion failed");
		
		offer = offerDAO.getOffer("changoo");
		System.out.println(offer);
		
		offer.setName("changoo Lee");
		if(offerDAO.update(offer))
			System.out.println("update with Object : " + offer);
		else
			System.out.println("Cannot update an object");
		
		if(offerDAO.delete(offer.getId()))
			System.out.println("Object id deleted");
		else
			System.out.println("Cannot delete");
		
		context.close();
	}

}
