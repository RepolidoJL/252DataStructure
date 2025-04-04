public class QueueNode{
   private MyNode top;
   private int count;
   
   public QueueNode(){
      top = null;
      count = 0;
   }
   
   public boolean isEmpty(){
      return top == null;
   }
   
   public boolean isFull(){
      return false;
   }
   
   public boolean enqueue(Object newNode){
    if(isEmpty()){
        top = newNode;
    }
    else{
        MyNode tempTop = top;
        while(tempTop.next !=null){
            tempTop = tempTop.next;
        }
        tempTop.next = newNode;
    }
    count = count +1;
    return true;
   }

   public boolean dequeue(){
    if(!isEmpty()){
        if(top !=null && top.next == null){
            top = null;
        }
        else{
            top = top.next;
        }
        count = count - 1;
        return true;
    }
    return false;
   }
   
   public String toString()
   {
      String result = "";
      if(!isEmpty())
      {
         MyNode tempTop = top;
         while(tempTop != null)
         {
            result += "[" + tempTop.item + "]->";
            tempTop = tempTop.next;
         }
      }
      return result;
   }
}