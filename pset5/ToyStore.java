/* ToyStore
 * Benedict Brown
 *
 * This is an example of a class that uses Pez dispensers.
 * In theory, one could have many different Toy stores
 * that each stock and sell different Pez dispensers, but
 * this class doesn't do any of that.
 *
 * Instead it has a simple main function that creates
 * some PezDispensers, calls some methods on them, and prints
 * out their states to illustrate how to instantiate (create)
 * objects in Java, how to use them, and how each one gets its
 * own copy of all the (non-static) instance variables.
 */

public class ToyStore {    
    public static void main(String[] args) {
        PezDispenser pez1 = new PezDispenser(15, 25, 35,      //store the location.new is to find something .and (15,25)is the sth new looking for.
                                             true, "Benedict",
                                             "Pizza");
        PezDispenser pez2 = new PezDispenser(150, 250, 35,    //new PD red green blue 
                                             true, "Dory",
                                             "Fried Cusk");
        PezDispenser pez3 = new PezDispenser(15, 250, 3,
                                             true, "Hello Kitty",
                                             "Red Bean");
        PezDispenser pez4 = new PezDispenser(5, 5, 5,
                                             false, "Minion",
                                             "Banana");
        
        pez2.dispenseCandy();   //dispenseCandy() to some of them.
        pez2.dispenseCandy();
        pez3.dispenseCandy();
        
        System.out.println("pez1");  
        pez1.printState();

            
        System.out.println("pez2");
        pez2.printState();

            
        System.out.println("pez3");
        pez3.printState();

            
        System.out.println("pez4");
        pez4.printState();
    }
}