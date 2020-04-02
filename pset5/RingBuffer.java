// TODO: FILE HEADER
// TODO: There should be no "TODO" comments left in
//       your code by the time you're done!

public class RingBuffer {
   private double[] bufferArray; // items in the buffer
   private int first;            // index for the next dequeue or peek
   private int last;             // index for the next enqueue
   private int currentSize;      // number of items in the buffer
   private int capacity;
         
   // create an empty buffer, with given max capacity
   public RingBuffer(int capacity) {
    
      bufferArray = new double[capacity];
      this.capacity = capacity;
   }

   // return number of items currently in the buffer
   public int currentSize() {
      // TODO: YOUR CODE HERE
   
      return currentSize; 
   }

   // is the buffer empty (size equals zero)?
   public boolean isEmpty() {
      return currentSize == 0; 
   }

   // is the buffer full (size equals array capacity)?
   public boolean isFull() {
   
      return currentSize == capacity;}

   
   // add item x to the end
   public void enqueue(double x) {
        
      
      if (isFull()) {
         throw new RuntimeException("ERROR: Attempting to enqueue " +
                                    "to a full buffer.");
      }
     
     
      bufferArray[last]=x;
      currentSize++;
      last = (last + 1) % capacity;
    
      
   }

   // delete and return item from the front
   public double dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("ERROR: Attempting to dequeue " +
                                    "from an empty buffer.");
      }
      currentSize--;
      double newFirst = bufferArray[first];
      first = (first + 1) % capacity;
      return newFirst;       }

   // return (but do not delete) item from the front
   public double peek() {
      if (isEmpty()) {
         throw new RuntimeException("ERROR: Attempting to peek " +
                                    "at an empty buffer.");
      }
      
   
      return bufferArray[first];       }

   // print the contents of the RingBuffer object for debugging
   // TODO: ADD TO THIS METHOD IF YOU ADD ANY INSTANCE VARIABLES OF YOUR OWN
   private void printBufferContents() {
      // print out first, last, and currentSize
      System.out.println("first:        " + first);
      System.out.println("last:         " + last);
      System.out.println("currentSize:  " + currentSize);
   
      // print bufferArray's length and contents if it is not null
      // otherwise just print a message that it is null
      if (bufferArray != null) {
         System.out.println("array length: " + bufferArray.length);
         System.out.println("Buffer Contents:");
      
         // print out each item in the RingBuffer array
         // some of these values may be leftovers if the
         // there has been a mix of enqueueing and dequeueing
         for (int i = 0; i < bufferArray.length; i++) {
            System.out.println(bufferArray[i]);
         }
      } else {
         System.out.println("bufferArray is null");
      }
   }

   // a simple test of the constructor and methods in RingBuffer
   public static void main(String[] args) {
      // create a RingBuffer with bufferSize elements
      // where bufferSize is a command-line argument
      int bufferSize = Integer.parseInt(args[0]);
      RingBuffer buffer = new RingBuffer(bufferSize);
   
      // right now the buffer should be empty, and first and last should be 0
      buffer.printBufferContents();
      // should be true if bufferSize >= 4
      System.out.println("buffer.isEmpty() returns " + buffer.isEmpty());
      // should be false if bufferSize >= 4
      System.out.println("buffer.isFull() returns " + buffer.isFull());
      
      // enqueue a bunch of values to test
      for (int i = 0; i < bufferSize; i++) {
         buffer.enqueue(i);
         System.out.println("Enqueued " + i);
      }
   
      // right now the buffer size should match its capacity
      // first and last should be 0 (because last should have wrapped around)
      // for bufferSize 8, should be 0, 1, 2, 3, 4, 5, 6, 7
      buffer.printBufferContents();
      // should be false if bufferSize >= 4
      System.out.println("buffer.isEmpty() returns " + buffer.isEmpty());
      // should be true if bufferSize >= 4
      System.out.println("buffer.isFull() returns " + buffer.isFull());
      // for bufferSize 8, should be 8
      System.out.println("buffer.currentSize() returns " + buffer.currentSize());
   
      // now start dequeueing and peeking
      // this should print
      //   Front of buffer is 0
      //   Dequeued 0
      //   Front of buffer is 1
      //   Dequeued 1
      //   ... (up to half the elements that were in the queue)
      for (int i = 0; i < bufferSize / 2; i++) {
         double val = buffer.peek();
         System.out.println("Front of buffer is: " + val);
         val = buffer.dequeue();
         System.out.println("Dequeued " + val);
      }
   
      // now the buffer size should be half its capacity
      // first should be capacity/2 and last should be 0 (because it wrapped around)
      // for bufferSize 8, should be 0, 1, 2, 3, 4, 5, 6, 7
      // (remember, 0, 1, 2, 3 are now garbage values becuase first is 4)
      buffer.printBufferContents();
      // should be false if bufferSize >= 4
      System.out.println("buffer.isEmpty() returns " + buffer.isEmpty());
      // should be false if bufferSize >= 4
      System.out.println("buffer.isFull() returns " + buffer.isFull());
      // for bufferSize 8, should be 4
      System.out.println("buffer.currentSize() returns " + buffer.currentSize());
   
      // now enqueue another capacity / 4 elements
      for (int i = 0; i < bufferSize / 4; i++) {
         buffer.enqueue(bufferSize + i);
         System.out.println("Enqueued " + (bufferSize + i));
      }
   
      // now the buffer size should be three quarters of its capacity
      // first should be capacity / 2,
      // last should be capacity / 4
      // if bufferSize is 8, should be 8, 9, 2, 3, 4, 5, 6, 7
      // (remember, 2 and 3 are garbage values because first is still 4)
      buffer.printBufferContents();
      // should be false if bufferSize >= 4
      System.out.println("buffer.isEmpty() returns " + buffer.isEmpty());
      // should be false if bufferSize >= 4
      System.out.println("buffer.isFull() returns " + buffer.isFull());
      // for bufferSize 8, should be 6
      System.out.println("buffer.currentSize() returns " + buffer.currentSize());
   }
}