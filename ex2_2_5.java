import java.util.Scanner;

class ex2_2_5{
    public static void main (String args[]){
     int[][] a = new int[][]{{1,2},{3,4}};
     int[][] b = new int[][]{{4,5},{6,7}};
     if(a.length != b.length){
        System.out.print("Cannot operate matrices additon");
        System.exit(0);
     }
     for(int i = 0 ;i < a.length ; i++){
        if(a[i].length != b[i].length ){
            System.out.print("Cannot operate matrices additon");
        System.exit(0);
        }
        for(int j = 0 ; j < a[i].length ; j++){
            a[i][j] = a[i][j] + b[i][j];
        }
     }
     for(int i = 0 ;i < a.length ; i++){
        for(int j = 0 ; j < a[i].length ; j++){
            System.out.print(a[i][j] + " ");
        }
        System.out.print("\n");
     }
  }
}