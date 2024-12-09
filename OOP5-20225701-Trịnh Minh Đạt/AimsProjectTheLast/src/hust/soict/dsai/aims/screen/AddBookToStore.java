package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AddBookToStore extends AddMediaToStoreScreen{
	protected JTextField tfAuthors; 

	// Constructor
	public AddBookToStore(Store store, Cart cart) {
	    super(store, cart, "Add Book to store", "ADD BOOK TO STORE");
	}

	JPanel createCenter() {
	    JPanel center = new JPanel();
	    tfAuthors = new JTextField(10); // TextField cho danh sách các tác giả
	    center.setLayout(new GridLayout(4, 2, 2, 2));
	    
	    addInputRow(center, "Title", tfTitle);
	    addInputRow(center, "Category", tfCategory);
	    addInputRow(center, "Cost", tfCost);
	    addInputRow(center, "Authors (comma-separated)", tfAuthors); // Nhắc nhập danh sách tác giả
	    return center;
	}

	public Media createMedia() {
	    // Tách danh sách các tác giả từ tfAuthors
	    List<String> authors = Arrays.asList(tfAuthors.getText().split(",")); 

	    // Tạo đối tượng Book
	    return new Book(
	        tfTitle.getText(),                              // Title
	        tfCategory.getText(),                          // Category
	        Float.parseFloat(tfCost.getText()),            // Cost
	        authors                                        // Authors list
	    );
	}
	}

