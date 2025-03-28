import java.util.Scanner;

public class MyStackArray {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      StackArray stack = null;      boolean running = true;

      while (running) {
         System.out.println("MyStackArray");
         System.out.println("Menu:");
         System.out.println("1. Create");
         System.out.println("2. Exit");
         System.out.print("Enter choice: ");
         int choice = scanner.nextInt();
         
         switch (choice) {
            case 1: 
               System.out.print("Enter stack size (between 5 and 50): ");
               int size = scanner.nextInt();
               stack = new StackArray(size); 
               System.out.println("Stack created with size: " + size);
               
             
               boolean stackOperations = true;
               while (stackOperations) {
                  
                  System.out.println("1. Push");
                  System.out.println("2. Peek");
                  System.out.println("3. Pop");
                  System.out.println("4. Display");
                  System.out.println("5. Go back");
                  System.out.print("Enter choice: ");
                  int operationChoice = scanner.nextInt();
                  
                  switch (operationChoice) {
                     case 1: // Push
                        System.out.print("Enter value to push: ");
                        Object value = scanner.next();
                        if (stack.push(value)) {
                           System.out.println("Pushed " + value + " onto the stack.");
                        } else {
                           System.out.println("Stack is full! Cannot push.");
                        }
                        break;

                     case 2: // Peek
                        Object peekedValue = stack.peek();
                        if (peekedValue != null) {
                           System.out.println("Top of the stack: " + peekedValue);
                        } else {
                           System.out.println("Stack is empty!");
                        }
                        break;

                     case 3: // Pop
                        if (stack.pop()) {
                           System.out.println("Popped an item from the stack.");
                        } else {
                           System.out.println("Stack is empty! Cannot pop.");
                        }
                        break;

                     case 4: // Display
                        System.out.println("Stack contents:");
                        System.out.println(stack.toString());
                        break;

                     case 5: // Go back
                        stackOperations = false; 
                        break;

                     default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                  }
               }
               break;

            case 2: // Exit
               running = false; 
               break;

            default:
               System.out.println("Invalid choice. Please try again.");
               break;
         }
      }

      scanner.close();
      System.out.println("Program exited.");
   }
}
