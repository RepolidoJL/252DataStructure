import javax.swing.*;

public class Mainn {

    // Function to define precedence for operators
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2; // * and / have higher precedence
        return 0;
    }

    // Convert infix expression to postfix
    public static String convertToPostfix(String exp) {
        StackNode operators = new StackNode(); // Stack to store operators
        String result = ""; // String to store the postfix expression
        StringBuilder number = new StringBuilder(); // To handle multi-digit numbers

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i); // Current character

            // If the character is a digit, we are handling a number (possibly multi-digit)
            if (Character.isDigit(ch)) {
                number.append(ch); // Append digits to the current number
            } else {
                if (number.length() > 0) {
                    result += number.toString(); // Add the current number to result
                    number.setLength(0); // Reset the number builder
                }

                if (ch == '(') {
                    operators.push(new MyNode(ch)); // Push '(' onto the stack
                } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    result += ch; // Add operand directly to the result
                } else if (ch == ')') {
                    // Pop until '(' is found and process
                    while (!operators.isEmpty() && (char) operators.peek().item != '(') {
                        char op = (char) operators.pop().item;
                        result += op;
                    }
                    operators.pop(); // Remove '('
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    // Process operators based on precedence
                    while (!operators.isEmpty() && precedence(ch) <= precedence((char) operators.peek().item)) {
                        result += (char) operators.pop().item;
                    }
                    operators.push(new MyNode(ch)); // Push the current operator
                }
            }
        }

        // If there's any number left at the end, add it to the result
        if (number.length() > 0) {
            result += number.toString();
        }

        // Pop all remaining operators
        while (!operators.isEmpty()) {
            result += (char) operators.pop().item;
        }

        return result; // Return final postfix expression
    }

    public static void main(String args[]) {
        // Input the infix expression using JOptionPane
        String infixExpression = JOptionPane.showInputDialog("Enter an infix expression:");
        
        // Display the infix expression
        JOptionPane.showMessageDialog(null, "The Infix Expression is: " + infixExpression);

        // Convert the infix expression to postfix
        String result = convertToPostfix(infixExpression);

        // Display the postfix expression
        JOptionPane.showMessageDialog(null, "The Postfix of the given Infix Expression is: " + result);
    }
}

// The MyNode class used for nodes in the StackNode stack
class MyNode {
    Object item;
    MyNode next;

    MyNode(Object item) {
        this.item = item;
        this.next = null;
    }
}

// The StackNode class implementing a basic stack
class StackNode {
    private MyNode top;

    public StackNode() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(MyNode newNode) {
        newNode.next = top;
        top = newNode;
    }

    public MyNode pop() {
        if (!isEmpty()) {
            MyNode node = top;
            top = top.next;
            return node;
        }
        return null;
    }

    public MyNode peek() {
        return top;
    }
}
