import javax.swing.JOptionPane;

public class MenuQueue {
    public static void main(String[] args) {
        QueueArray queue = null; 
        boolean running = true; 

        
        String sizeInput = JOptionPane.showInputDialog("Enter the size of the queue:");
        int size = Integer.parseInt(sizeInput);
        queue = new QueueArray(size);
        JOptionPane.showMessageDialog(null, "Queue created with size: " + size);

        while (running) {
            String menu = "Queue Menu\n" +
                          "1. Enqueue\n" +
                          "2. Dequeue\n" +
                          "3. Display Queue\n" +
                          "4. Exit";
            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1":
                    String elementInput = JOptionPane.showInputDialog("Enter an element to enqueue:");
                    if (queue.enqueue(elementInput)) {
                        JOptionPane.showMessageDialog(null, "Element enqueued: " + elementInput);
                    } else {
                        JOptionPane.showMessageDialog(null, "Queue is full. Cannot enqueue.");
                    }
                    break;

                case "2":
                    if (queue.dequeue()) {
                        JOptionPane.showMessageDialog(null, "Element dequeued.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Queue is empty. Cannot dequeue.");
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Current Queue: " + queue.toString());
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}