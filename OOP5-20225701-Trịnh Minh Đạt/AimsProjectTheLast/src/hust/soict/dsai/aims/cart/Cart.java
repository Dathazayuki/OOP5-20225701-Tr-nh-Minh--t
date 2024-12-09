package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {
    }
    public void addMedia(Media media) {
    	
    	final int MAX_NUMBERS_ORDERED = 9; // Giới hạn số lượng media

        if (media != null) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("Added: " + media.getTitle());
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "ERROR: The number of media has reached its limit.", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Cannot add a null item.", 
                "Warning", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found: " + (media != null ? media.getTitle() : "null"));
        }
    }
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    public void printCart() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index++ + ". " + media.getTitle());
            totalCost += media.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for title: \"" + title + "\"");
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: \"" + title + "\".");
        }
    }
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }


	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	public boolean contains(Media media) {
        for (Media item : itemsOrdered) {
            if (item.equals(media)) { // Sử dụng equals đã override trong Media
                return true;
            }
        }
        return false;
    }
	  public void displayCartByTitleCost() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	        System.out.println("Cart sorted by Title then Cost:");
	        for (Media media : itemsOrdered) {
	            System.out.println(media.toString());
	        }
	    }

	    public void displayCartByCostTitle() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	        System.out.println("Cart sorted by Cost then Title:");
	        for (Media media : itemsOrdered) {
	            System.out.println(media.toString());
	        }
	    }
	    public void filterCartbyTitle(String titleFilter1 ) { 
	                for (Media media : itemsOrdered) {
	                	
	                    if (media.getTitle().equalsIgnoreCase(titleFilter1)) {
	                        System.out.println(media.getTitle());
	                    }
	                }
	    }
	    public void filterCartbyId(String IdFilter1 ) {
            for (Media media : itemsOrdered) {
            	 try {
            	        int idFilter = Integer.parseInt(IdFilter1); // Chuyển chuỗi sang số nguyên
            	       
            	       List<Media> filterList = itemsOrdered.stream()
            	        	    .filter(item -> item.getId() == idFilter) // Đổi tên tham số từ 'media' thành 'item'
            	        	    .collect(Collectors.toList());
            	        System.out.println(media.getTitle()); // Hiển thị danh sách được lọc
            	    } catch (NumberFormatException e) {
            	        System.out.println("Invalid ID format. Please enter a valid numeric ID.");
            	    }
            }
}

	    // Sắp xếp giỏ hàng (có thể sắp xếp theo tiêu đề hoặc giá)
	    public void sortCartbyTitle() {
	       
	                Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	                System.out.println("Cart sorted by title.");
	    }
	    public void sortCartbyCost() {
		       
            Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
            System.out.println("Cart sorted by cost.");
}
	           
	      

	    // Phát media từ giỏ hàng theo tiêu đề
	    public void playMedia(String title) {
	        for (Media media : itemsOrdered) {
	            if (media.getTitle().equalsIgnoreCase(title)) {
	                try {
						media.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  // Assuming play() is a method in the Media class
	                return;
	            }
	        }
	        System.out.println("Media not found in cart.");
	    }

	    // Xóa tất cả media trong giỏ hàng
	    public void clear() {
	        itemsOrdered.clear();
	    }

	    // Xóa media theo tiêu đề
	    public void removeMediaByTitle(String title) {
	        for (Media media : itemsOrdered) {
	            if (media.getTitle().equalsIgnoreCase(title)) {
	                itemsOrdered.remove(media);
	                System.out.println("Media removed from cart.");
	                return;
	            }
	        }
	        System.out.println("Media not found in cart.");
	    }
		public void emptyCart() {
			// TODO Auto-generated method stub
			
		}
	 
    
}

