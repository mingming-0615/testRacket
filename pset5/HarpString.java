// TODO: FILE HEADER
// TODO: There should be no "TODO" comments left in
//       your code by the time you're done!

public class HarpString {

   private RingBuffer ringBuffer; // ring buffer

   // create a harp string of the given frequency
   public HarpString(double frequency) {
   
      double capacity = Math.ceil(44100/frequency);
      ringBuffer = new RingBuffer((int) capacity);
      while(!ringBuffer.isFull()){
         ringBuffer.enqueue(0.0);
      }
     //System.out.println(ringBuffer.capacity());
    	//System.out.println(buffer.fillCount());
    	//System.out.println(buffer.isFull());
    	//System.out.println("First :" + buffer.first + " Last:" + buffer.last + " ArrSize:" + buffer.rb.length);
   }

   // pluck the harp string by replacing the buffer with white noise
   public void pluck() {
      while(!ringBuffer.isEmpty()){
         ringBuffer.dequeue();
      }
         
      while(!ringBuffer.isFull()){
         double r = Math.random() - 0.5;
         ringBuffer.enqueue(r);
      }
      
   }
   // advance the simulation one time step
   public void tic() {
      double first = ringBuffer.dequeue();
      double second = ringBuffer.peek();
      double newSamp = -0.996 * ((first + second) / 2 ) ;
      ringBuffer.enqueue(newSamp);     
   }

   // return the current sample
   public double sample() {
      // TODO: YOUR CODE HERE
      return ringBuffer.peek();
   
   }

   public static void main(String[] args) {
      // how many samples should we "play"
      int numSamplesToPlay = Integer.parseInt(args[0]);
   
      // a starting set of samples; it's pretty easy to calculate
      // the new samples that will get generated with a calculator
      double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
   
      // create a harp string to test with exactly samples.length,
      // this looks a little funny because the HarpString constructor
      // expects a frequency, not a number of elements
      HarpString testString = new HarpString(44100.0 / samples.length);
   
      // at this point the RingBuffer underlying testString should have
      // a capacity of samples.length and should be full
      System.out.println("testString.ringBuffer.isEmpty(): " + 
                         testString.ringBuffer.isEmpty());
      System.out.println("testString.ringBuffer.isFull():  " + 
                         testString.ringBuffer.isFull());
      System.out.println("testString.ringBuffer.currentSize(): " +
                         testString.ringBuffer.currentSize());
   
      // replace all the zeroes with the starting samples
      for (int i = 0; i < samples.length; i++) {
         testString.ringBuffer.dequeue();
         testString.ringBuffer.enqueue(samples[i]);
      }
   
      // "play" for numSamples samples; printing each one for inspection
      for (int i = 0; i < numSamplesToPlay; i++) {
         double sample = testString.sample();
      
         // this statement prints the time t, padded to 6 digits wide
         // and the value of sample padded to a total of 8 characters
         // including the decimal point and any - sign, and rounded
         // to four decimal places
         System.out.printf("%6d %8.4f\n", i, sample);
      
         testString.tic(); // advance to next sample
      }
   
      // pluck the string
      testString.pluck();
   
      System.out.println();
      System.out.println("The next 10 values should be random numbers between -0.5 and +0.5");
      System.out.println("Everything after those 10 values are calculated");
      System.out.println("using the Karplus-Strong algorithm.");
   
      // "play" for numSamples samples; printing each one for inspection
      // the first numSamples of these should be random values between -0.5 and +0.5
      for (int i = 0; i < numSamplesToPlay; i++) {
         double sample = testString.sample();
      
         // this statement prints the time t, padded to 6 digits wide
         // and the value of sample padded to a total of 8 characters
         // including the decimal point and any - sign, and rounded
         // to four decimal places
         System.out.printf("%6d %8.4f\n", i + numSamplesToPlay, sample);
      
         testString.tic(); // advance to next sample
      }
   }
}