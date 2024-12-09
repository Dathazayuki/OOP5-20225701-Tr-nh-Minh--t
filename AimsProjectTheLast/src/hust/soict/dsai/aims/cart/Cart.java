package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private Runnable changeListener;

    public Cart() {
    }
    public void addMedia(Media media) {
        if (media != null) {
            itemsOrdered.add(media);
            notifyChangeListener();
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("Cannot add a null item.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            notifyChangeListener();
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
	                media.play();  // Assuming play() is a method in the Media class
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
	 // Setter và getter cho Change Listener
	    public void setChangeListener(Runnable listener) {
	        this.changeListener = listener;
	    }

	    public Runnable getChangeListener() {
	        return changeListener;
	    }

	    private void notifyChangeListener() {
	        if (changeListener != null) {
	            changeListener.run();
	        }
	    }
    
}

