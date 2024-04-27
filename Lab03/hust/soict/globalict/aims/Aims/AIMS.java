package Lab03.hust.soict.globalict.aims.Aims;

import Lab03.hust.soict.globalict.aims.cart.*;
import Lab03.hust.soict.globalict.aims.store.*;
import Lab03.hust.soict.globalict.aims.media.*;



import java.util.Scanner;

public class AIMS {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    public static Media create_Media(){
        System.out.println("Which type of media do you want to add ?:\n1. Book\n2. Digital Video Disc\n3. Compact Disc ");
        System.out.println("Please choose a number in : 1-2-3");
        Scanner keyboard = new Scanner(System.in);
        int option = keyboard.nextInt();
        while(option != 1 && option != 2 && option != 3){
            System.out.println("Please enter again a number in range : 1-2-3");
            option = keyboard.nextInt();
        }
        Media obj;
        System.out.println("Please fill in these information:title-category-id-cost :");
        String title,category;
        int id;
        float cost;
        title = keyboard.nextLine().strip();
        category = keyboard.nextLine().strip();
        id = keyboard.nextInt();
        cost = keyboard.nextFloat();
        if(option == 1){
            System.out.println("Do you want to add authors ?");
            String input = keyboard.nextLine();
            obj = new Book(id, title, category, cost);
               while(input.equals("yes")){
                   String authors = keyboard.nextLine();
                   ((Book)obj).addAuthor(authors);
                   System.out.println("Do you want to add authors ?");
                   input = keyboard.nextLine();
               }
            return obj;
        }else if(option == 2){
             System.out.println("Please eneter the length and the director's name.");
                 System.out.println("The length: ");
                 int length = keyboard.nextInt();
                 System.out.println("The director: ");
                 String director = keyboard.nextLine().strip();
                 obj = new DigitalVideoDisc(title, category, director, length, cost, id);
             return obj;
        }else{
             System.out.println("Please enter the artist 's name: ");
             String artist = keyboard.nextLine();
             obj = new CompactDisc(id, title, category, cost, artist);
             System.out.println("Please enter the length and the director");
             int length = keyboard.nextInt();
             String director = keyboard.nextLine().strip();
             Track track = new Track(director, length);
             ((CompactDisc)obj).addTrack(track);
             return obj;
        }
        

    }
    public static void showMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int input = keyboard.nextInt();
        while(input != 0 && input != 1 && input != 2){
            System.out.println("Please choose again a number in range : 0-1-2-3");
            input = keyboard.nextInt();
        }
        if(input == 1){
            storeMenu();
            showMenu();
        }else if(input == 2){
            Media media = create_Media();
            store.addMedia(media);
            showMenu();
        }else if(input == 3){
            cart.display();
            cartMenu();
            showMenu();
        }else {
            System.out.println("Goodbye !");
            System.exit(0);
        }
        }
        public static void storeMenu() {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media 's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int input = keyboard.nextInt();
            if(input == 1){
                System.out.println("Please enter a title: ");
                String title = keyboard.nextLine().strip();
                Media media = store.searchByTitle(title);
                if(media != null){
                    mediaDetailsMenu(media);
                }else{
                    System.out.println("The media with this title does not exist !");
                }
                storeMenu();
            }else if(input == 2){
                System.out.println("Please enter a title: ");
                String title = keyboard.nextLine().strip();
                Media media = store.searchByTitle(title);
                if(media != null){
                    cart.addMedia(media);
                }else{
                    System.out.println("The media with this title does not exist !");
                }
                storeMenu();
            }else if(input == 3){
                System.out.println("Please enter a title: ");
                String title = keyboard.nextLine().strip();
                Media media = store.searchByTitle(title);
                if(media != null){
                    if(media instanceof CompactDisc){
                       ((CompactDisc)media).play();
                    }else if(media instanceof DigitalVideoDisc){
                        ((DigitalVideoDisc)media).play();
                    }
                }else{
                    System.out.println("The media with this title does not exist !");
                    storeMenu();
                }
                return;
            }else if(input == 4){
                cartMenu();
            }else{
                return;
            }
            }
        public static void mediaDetailsMenu(Media media) {
            Scanner keyboard = new Scanner(System.in);
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add to cart");
                System.out.println("2. Play");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");
                int input = keyboard.nextInt();
                while(input != 1 && input != 2 && input != 0){
                    System.out.println("Please choose a number again in range 0-1-2: ");
                    input = keyboard.nextInt();
                }
                if(input == 1){
                     cart.addMedia(media);
                     mediaDetailsMenu(media);
                }else if(input == 2){
                    if(media instanceof CompactDisc){
                        ((CompactDisc)media).play();
                     }else if(media instanceof DigitalVideoDisc){
                         ((DigitalVideoDisc)media).play();
                     }
                     mediaDetailsMenu(media);
                    }else {
                    return;
                }
            }
        public static void cartMenu() {
            Scanner keyboard = new Scanner(System.in);
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Filter media in cart");
                System.out.println("2. Sort media in cart");
                System.out.println("3. Remove media from cart");
                System.out.println("4. Play a media");
                System.out.println("5. Place order");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4-5");
                int input = keyboard.nextInt();
                if(input == 1){
                    System.out.println("You can choose one of these options : id/category");
                    String option = keyboard.nextLine();
                    while((option.equals("id") == false) && (option.equals("category") == false)){
                        System.out.println("Please enter your option again");
                        option = keyboard.nextLine();
                    }
                    if(option.equals("id")){
                        System.out.println("Please eneter the id you want");
                        input = keyboard.nextInt();
                        cart.search_by_id(input);
                    }else{
                        System.out.println("Please enter the category you want");
                        option = keyboard.nextLine();
                        cart.search_by_title(option);
                    }
                    cartMenu();
                    }else if(input == 2){
                        System.out.println("You can choose one of these options : title/cost");
                        String option = keyboard.nextLine();
                        while((option.equals("title") == false) && (option.equals("cost") == false)){
                            System.out.println("Please enter your option again");
                            option = keyboard.nextLine();
                        }
                        if(option.equals("title")){
                            cart.sortByTitle();;
                        }else{
                            System.out.println("Please enter the category you want");
                           cart.sortByCost();
                        }
                        cartMenu();

                    }else if(input == 3){
                        System.out.println("Enter the media you want to remove");
                        String option = keyboard.nextLine();
                        cart.removeMedia(option);
                        cartMenu();
                        return;
                    }else if(input == 4){
                        System.out.println("Please enter a title: ");
                        String title = keyboard.nextLine().strip();
                        Media media = store.searchByTitle(title);
                        if(media != null){
                            if(media instanceof CompactDisc){
                               ((CompactDisc)media).play();
                            }else if(media instanceof DigitalVideoDisc){
                                ((DigitalVideoDisc)media).play();
                            }
                        }else{
                            System.out.println("The media with this title does not exist !");
                        }
                        cartMenu();
                    }else if(input == 5){
                        System.out.println("An order has been created !");
                        cart.freeCart();
                        cartMenu();
                    }else {
                        return;
                    }
                    
                }

    public static void setup(){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        Book book = new Book(001,"The Valley of Fear", "Detective", 20.00f);
        book.addAuthor("Arthur Conan Doyle");
        Book book1 = new Book(002,"A Living Remedy: A Memoir", "Biography", 202.00f);
        book1.addAuthor("Nicole Chung");
        Book book2 = new Book(003,"On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        book2.addAuthor("Thomas Hertog");
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);
        CompactDisc cd1 = new CompactDisc(004,"30", "Music", 1500.98f,"Adele");
        Track track1CD1 = new Track("All Night Parking (interlude)", 161);
        Track track2CD1 = new Track("To Be Loved", 403);
        Track track3CD1 = new Track("Woman Like Me", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);
        CompactDisc cd2 = new CompactDisc(005,"The Gods We Can Touch", "Music", 2000.22f,"Aurora");
        Track track1CD2 = new Track("Everything Matters", 180+34);
        Track track2CD2 = new Track("Blood in the Wine", 180+30);
        Track track3CD2 = new Track("Artemis", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);
        CompactDisc cd3 = new CompactDisc(006,"Purpose", "Music", 1000.98f,"Justin Bieber");
        Track track1CD3 = new Track("The Feeling", 4*60+5);
        Track track2CD3 = new Track("No Sense", 4*60+35);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }
    public static void main(String[] args) {
        setup();
        showMenu();
    }
}
