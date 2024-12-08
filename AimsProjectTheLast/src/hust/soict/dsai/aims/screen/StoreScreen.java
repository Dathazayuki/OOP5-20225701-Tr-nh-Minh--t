package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;


public class StoreScreen extends JFrame {
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Store store;
	
	  public StoreScreen(Store store) {
		  store = new Store();
		  

		    // Example media added to the store
		    DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
		    DigitalVideoDisc dvd2 = new DigitalVideoDisc( "Tranformers", "action", "Micheal Bay", 198, 39.99f);
		    Book book1 = new Book( "conan", "anime", 15.99f, new ArrayList<>());
		    Book book2 = new Book( "doraemon", "anime", 12.45f, new ArrayList<>());
		    Book book3 = new Book( "Effective Java", "Programming", 45.99f, new ArrayList<>());
		    CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music","Godfather" ,134, 14.99f,"J-97");
		    CompactDisc cd2 = new CompactDisc("Don't stop me now", "Music","Mamaday" ,167, 22.99f,"hololive");
		    
		    store.addMedia(dvd1);
		    store.addMedia(dvd2);
		    store.addMedia(book1);
		    store.addMedia(book2);
		    store.addMedia(book3);
		    store.addMedia(cd1);
		    store.addMedia(cd2);
		    
  	    StoreScreen.store = store;
  	    Container cp = getContentPane();
  	    cp.setLayout(new BorderLayout());

  	    cp.add(createNorth(), BorderLayout.NORTH);
  	    cp.add(createCenter(), BorderLayout.CENTER);

  	    setVisible(true);
  	    setTitle("Store");
  	    setSize(1024, 768);
  	}
      JPanel createNorth() {
    	    JPanel north = new JPanel();
    	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
    	    north.add(createMenuBar());
    	    north.add(createHeader());
    	    return north;
    	}
      
      JMenuBar createMenuBar() {
    	    JMenu menu = new JMenu("Options");
    	    JMenu smUpdateStore = new JMenu("Update Store");
    	    smUpdateStore.add(new JMenuItem("Add Book"));
    	    smUpdateStore.add(new JMenuItem("Add CD"));
    	    smUpdateStore.add(new JMenuItem("Add DVD"));
    	    menu.add(smUpdateStore);
    	    menu.add(new JMenuItem("View store"));
    	    menu.add(new JMenuItem("View Cart"));
    	    JMenuBar menuBar = new JMenuBar();
    	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    	    menuBar.add(menu);
    	    return menuBar;
    	}
      JPanel createHeader() {
    	    JPanel header = new JPanel();
    	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
    	    JLabel title = new JLabel("AIMS");
    	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
    	    title.setForeground(Color.CYAN);
    	    JButton cart = new JButton("View cart");
    	    cart.setPreferredSize(new Dimension(100, 50));
    	    cart.setMaximumSize(new Dimension(100, 50));
    	    header.add(Box.createRigidArea(new Dimension(10, 0)));
    	    header.add(title);
    	    header.add(Box.createHorizontalGlue());
    	    header.add(cart);
    	    return header;
    	}
      JPanel createCenter() {
    	    JPanel center = new JPanel();
    	    center.setLayout(new GridLayout(3, 3, 2, 2));
    	    ArrayList<Media> itemsInStore = store.getItems();  // Lấy danh sách media từ store
    	    if (itemsInStore != null && !itemsInStore.isEmpty()) {
    	        for (int i = 0; i < Math.min(9, itemsInStore.size()); i++) {
    	            Media mediaItem = itemsInStore.get(i);
    	            Cart cart = new Cart();
    	            MediaStore cell = new MediaStore(mediaItem, cart);  // Tạo đối tượng MediaStore
    	            center.add(cell);  // Thêm vào center panel
    	        }
    	    }
    	    return center;
    	}
    
      public static void main(String[] args) {
         new StoreScreen(store); 
         
      }
}
