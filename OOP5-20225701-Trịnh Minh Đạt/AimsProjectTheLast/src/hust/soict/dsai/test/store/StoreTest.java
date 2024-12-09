package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create Media objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc( "Tranformers", "action", "Micheal Bay", 198, 39.99f);
        Book book1 = new Book( "conan", "anime", 15.99f, new ArrayList<>());
        Book book2 = new Book( "doraemon", "anime", 12.45f, new ArrayList<>());
        Book book3 = new Book( "Effective Java", "Programming", 45.99f, new ArrayList<>());
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music","Godfather" ,134, 14.99f,"J-97");
        CompactDisc cd2 = new CompactDisc("Don't stop me now", "Music","Mamaday" ,167, 22.99f,"hololive");


        // Add Media items to the store
        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        

        // Try adding duplicate
        store.addMedia(dvd2);

        // Print store contents
        System.out.println(store);

        // Remove a Media item
        store.removeMedia(book2);
        store.removeMedia(cd1);
        

        // Print store contents after removal
        System.out.println(store);
    }
}
