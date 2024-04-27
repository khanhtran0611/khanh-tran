import java.util.Scanner;

class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public DigitalVideoDisc(String title){
        super();
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category,float cost){
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title,String category,String director, float cost){
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        this.category = category;
        this.cost = cost;
        this.title = title;
        this.director = director;
        this.length = length;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }    
}

class Cart {
    int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] cart = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart has been full");
            return;
        }
        cart[qtyOrdered] = disc;
        qtyOrdered = qtyOrdered + 1;
        System.out.println("The disc has been added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered == 0){
            System.out.println("The cart is empty");
            return;
        }
        int i;
        for (i = 0; i < qtyOrdered; i++) {
            if (cart[i] == disc) {
                break;
            }
        }
        if (i != qtyOrdered - 1) {
            for (; i < qtyOrdered - 1; i++) {
                cart[i] = cart[i + 1];
            }
        }
        qtyOrdered = qtyOrdered - 1;
        System.out.println("The disc has been removed");
    }
    public float totalCost(){
        float sum = 0;
         for(int i = 0;i < qtyOrdered ; i++){
            sum = sum + cart[i].getCost();
         }
         return sum ;
    }
}



class aims {
    public static void main(String args[]) {
        Cart anorder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        anorder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","Geogre Lucas",87,24.95f);
        anorder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        anorder.addDigitalVideoDisc(dvd3);
        System.out.print("Total cost is: ");
        System.out.println(anorder.totalCost());
        anorder.removeDigitalVideoDisc(dvd3);
        System.out.print("Total cost after removal is: ");
        System.out.println(anorder.totalCost());
    }
}