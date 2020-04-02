public class Node{
   private int value;  //interger stored at this node;
   private Node next; //next node in the list;
   
   public Node(){
      value= 0;    //defalt value is 0
      next = null;  //defalt  is no next node.
   }
   
   public Node(int newValue, Node newNode){
      value = newValue;  //we can creat a node stores a value
      next = newNode;  //so we can make linked list integers
   }//tells where to find the next node in the list.it can hop from node to node.
   
   
   public int getValue(){    //provide the public interface for people using the node class. 
      return value;            // to be able to modify the value in the particlar node.
    
   }
   public void setValue (int newValue){
      value = newValue;
   }
   //do the same thing for the node.
   public Node getNext(){   //node cannot be converted to int
      return next;
       
   }
     
   public void setNext(Node newNext){
      next = newNext;
   }
   
   public String toString(){
      return value +"-> "+ next;//next represent everthing come after the current node list
          //next.toString resursively calling another two nodes on the list.
          //keep on going until next is null. 
          //recursively call two strings in different node.
   }    
   
   
     
   //function look the entire list as whole , rather than individual node.
   //more focus on the procedure than the object the thing,therefore choose to write 
   // static function.
   public static  int iteractiveLength(Node head){
      int length = 0;  //start from the counter
      for (Node n= head;n !=null; n =n.getNext()){ 
         length++;
      }
         // need to be careful the continuation condition(n != null) shoule be.
      return length;
    // if we want to stop one node before the end.
    //in that case. 
    //the continuation condition should be n.getNext() != null
    //everytime you write a loop, need to be very care what the stop condition is.
   }
   
   //look a little more from the point of view individual view.
   //a little more object-orienty.
   //for that reason. the resursive method need to be the non-static method.
   public int recursiveLength(){
      
      // if (this == null) return 0;
      // it is not correct. 
      //we can never recursive length call on null pointer.
      // this will never be null. the pointer will crashed.
      if(getNext() == null) {
         return 1;   //last node in list.
      }
              
      return 1+ getNext().recursiveLength(); //1 +length of rest of list.
   
   //keep track the individual node instead of the whole list.
   }
   
   public void insertAfter(int newValue){
      Node n = new Node(newValue, getNext());
      // setNext(n);   //set up the next pointers.
      //set the next node of the current node to n.
      //"this node n right after my current node"
      // n.setNext(getNext());
       
       
     //now we change the sequence here.  
      setNext(n); 
   }
   
   
   
   
   public static void main(String[] args){
      //Node head = new Node();
      //System.out.println(head);  
           //call toString(). So this object has value = 0,next =null.
            //so we get value(0)+->+next(null)
      
      //head.setNext(new Node(3,null));
      //System.out.println(head);   //garbage print out. To fix that.we need 
                                //two string method.
     
      //Node anotherNode = new Node(2,head);
      
      //as for how to write loops for node.
      Node node0 = new Node();
      Node node1 = new Node(1,node0);
      Node node2 = new Node(2,node1);
      Node node3 = new Node(3,node2);
      Node node4 = new Node(4,node3);
      
      node4.insertAfter(-1);//lose 3 2 1 0.change 4.next.
      
      System.out.println("iterativeLength(node2):"+ iteractiveLength(node2));
      System.out.println("iterativeLength(node4):"+ iteractiveLength(node4));
      
      
      //this time write the recursive method.
      System.out.println("node2.recursiveLength(node2):"+ node2.recursiveLength());
      System.out.println("node4.recursiveLength(node4):"+ node4.recursiveLength());
   }
   
   
  
      
}