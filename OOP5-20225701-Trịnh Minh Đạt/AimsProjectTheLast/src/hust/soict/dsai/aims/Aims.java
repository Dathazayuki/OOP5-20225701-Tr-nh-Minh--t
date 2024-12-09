package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Locale;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws PlayerException {
        Store store = new Store();
        Cart cart = new Cart();

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
        
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            switch (choice) {
                case 1:
                    viewStore(store, cart);
                    break;
                case 2:
                    updateStore(store);
                    break;
                case 3:
                    viewCart(cart);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-------------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void viewStore(Store store, Cart cart) throws PlayerException {
        int choice;
        do {
            System.out.println("\nStore contents:");
            System.out.println(store);
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart);
                    break;
                case 2:
                    addMediaToCart(store, cart);
                    break;
                case 3:
                    playMedia(store);
                    break;
                case 4:
                    viewCart(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails(Store store, Cart cart) throws PlayerException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void addMediaToCart(Store store, Cart cart) {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia(Store store) throws PlayerException {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or was not found.");
        }
    }

    private static void updateStore(Store store) {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline
        if (choice == 1) {
        	System.out.println("Choose the type of media:");
        	System.out.println("1. Book");
            System.out.println("2. Digital Video Disc");
            System.out.println("3. Compact Disc");
            System.out.print("Enter your choice: ");
            int mediaType = scanner.nextInt();
            scanner.nextLine();
            if (mediaType == 1) {
            System.out.print("Enter title of new Book: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Enter cost:");
            scanner.useLocale(Locale.US);
            float cost = scanner.nextFloat();
            System.out.print("Enter authors (separated by commas): ");
            String authorsInput = scanner.nextLine();
            ArrayList<String> authors = new ArrayList<>();

            // Tách chuỗi thành danh sách các tác giả
            if (!authorsInput.isEmpty()) {
                String[] authorsArray = authorsInput.split(","); // Tách theo dấu phẩy
                for (String author : authorsArray) {
                    authors.add(author.trim()); // Xóa khoảng trắng thừa
                }
            }
            scanner.nextLine(); 
            Book media =new Book(title, category, cost ,authors );
            store.addMedia(media);
            System.out.print("Media added to store.");
            } else if (mediaType ==2 ) {
            	System.out.print("Enter title of new DVD: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter Director: ");
                String Director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter cost: ");
                scanner.useLocale(Locale.US);
                float cost = scanner.nextFloat();
                scanner.nextLine(); 
                DigitalVideoDisc media = new DigitalVideoDisc(title, category, Director, length , cost);
                store.addMedia(media);
                System.out.print("Media added to store.");
            	
            } else if(mediaType == 3) {
            	System.out.print("Enter title of new CD: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter Director: ");
                String Director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter cost: ");
                scanner.useLocale(Locale.US);
                float cost = scanner.nextFloat();
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                scanner.nextLine(); 
                CompactDisc media = new CompactDisc(title, category, Director, length , cost, artist);
                store.addMedia(media);
                System.out.print("Media added to store.");
            } else {
                System.out.println("Invalid choice.");
            }
        } else if (choice == 2) {
            System.out.print("Enter title of media to remove: ");
            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media != null) {
                store.removeMedia(media);
                System.out.println("Media removed from store.");
            } else {
                System.out.println("Media not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void viewCart(Cart cart) {
        int choice;
        do {
            System.out.println("\nCurrent cart contents:");
            cart.printCart();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            switch (choice) {
                case 1:
                	System.out.println("Filter options:");
          	        System.out.println("1. Filter by title");
          	        System.out.println("2. Filter by id");
          	      System.out.println("Choose options:");

          	        int choice1 = scanner.nextInt();
          	        scanner.nextLine(); // Clear newline
          	        if (choice1 ==1) {
          	        	 System.out.print("Enter title to filter by: ");
     	                String titleFilter1 = scanner.nextLine();
                    cart.filterCartbyTitle(titleFilter1);
                    break;
          	        } else if (choice1 ==2) {
          	        	System.out.print("Enter Id to filter by: ");
     	                String IdFilter1 = scanner.nextLine();
                        cart.filterCartbyId(IdFilter1);
                        break;
          	        } else {
          	        	System.out.println("Invalid choice.");
          	        }
                case 2:
                	System.out.println("Sort options:");
          	        System.out.println("1. Sort by title");
          	        System.out.println("2. Sort by Cost");
          	      System.out.println("Choose options:");

          	        int choice2 = scanner.nextInt();
          	        scanner.nextLine(); // Clear newline
          	        if (choice2 ==1) {
                    cart.sortCartbyTitle();
                    break;
          	        } else if (choice2 ==2) {
                        cart.sortCartbyCost();
                        break;
          	        } else {
          	        	System.out.println("Invalid choice.");
          	        }
                case 3:
                    System.out.print("Enter title of media to remove: ");
                    String title = scanner.nextLine();
                    cart.removeMediaByTitle(title);
                    break;
                case 4:
                    System.out.print("Enter title of media to play: ");
                    String playTitle = scanner.nextLine();
                    cart.playMedia(playTitle);
                    break;
                case 5:
                    System.out.println("Order placed! Cart is now empty.");
                    cart.clear();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
