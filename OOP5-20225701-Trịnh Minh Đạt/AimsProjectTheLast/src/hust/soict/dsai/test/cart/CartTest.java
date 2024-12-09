package hust.soict.dsai.test.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;


public class CartTest {
	public static void main(String[] args) {
		  Cart cart = new Cart();

	        // Tạo các đối tượng Media
		    DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Tranformers", "action", "Micheal Bay", 198, 39.99f);
		    DigitalVideoDisc dvd2 = new DigitalVideoDisc( "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
		    DigitalVideoDisc dvd3 = new DigitalVideoDisc( "Ruler", "anime", "Mihazaki", 121, 11.67f);
	        Book book1 = new Book( "Effective Java", "Programming", 45.99f, new ArrayList<>());
	        Book book2 = new Book( "Golden Shining ", "Art ", 15.45f, new ArrayList<>());
	        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music","Godfather" ,134, 14.99f,"J-97");
	        CompactDisc cd2 = new CompactDisc("Don't stop me now", "Music","Mamaday" ,167, 22.99f,"hololive");
	        CompactDisc cd3 = new CompactDisc("God is a Girl", "Music","taylor" ,67, 20.9f,"live");
	    

	        cart.addMedia(dvd1);
	        cart.addMedia(dvd2);
	        cart.addMedia(dvd3);
	        cart.addMedia(book1);
	        cart.addMedia(book2);
	        cart.addMedia(cd1);
	        cart.addMedia(cd2);
	        cart.addMedia(cd3);
	        
	        
	        cart.printCart();
	        cart.displayCartByTitleCost();
	        System.out.println("\n -------------------------------------\n");
	        cart.displayCartByCostTitle();
	      
			
	    }
}

