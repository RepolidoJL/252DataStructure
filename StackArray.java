public class StackArray {
   private Object[] items;
   private int count;

   // Constructor to initialize stack with a specific size
   public StackArray(int size) {
      if (size > 50 || size < 5) {
         size = 10;
      }
      items = new Object[size];
      count = 0;
   }

   // Check if the stack is full
   public boolean isFull() {
      return count == items.length;
   }

   // Check if the stack is empty
   public boolean isEmpty() {
      return count == 0;
   }

   // Push an item onto the stack
   public boolean push(Object value) {
      if (!isFull()) {
         items[count] = value;
         count++; // Increment count after adding item
         return true;
      }
      return false;
   }

   // Peek the top item of the stack
   public Object peek() {
      if (!isEmpty()) {
         return items[count - 1]; // Get the last added item
      }
      return null;
   }

   // Pop an item off the stack
   public boolean pop() {
      if (!isEmpty()) {
         items[count - 1] = null; // Nullify the last item
         count--; // Decrement count after removing item
         return true;
      }
      return false;
   }

   // Convert stack to string for easy visualization
   public String toString() {
      String result = "";
      for (int i = count - 1; i >= 0; i--) { // Traverse from the top of the stack
         result = result + "[" + items[i] + "]\n";
      }
      return result;
   }
}
