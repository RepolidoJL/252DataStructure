public class QueueArray{
    private Object[] items;
    private int count;

    public QueueArray(int size){
        items = new Object[size];
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public boolean enqueue(Object i){
        if(!isFull()){
            items [count] = i;
            count = count + 1;
            return true;
        }
        return false;
    }


    public boolean dequeue(){
        if(!isEmpty()){
            if(count == 1){
                items[0] = null;
            }
            else{
                for(int i = 0; i < count-1; i=i+1){
                    items[i] = items [i+1];
                }
                items[count-1] = null;
            }
            count += count-1;
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "[";

        for(int i=0; i < count; i = i + 1){
            result = result + items[i];
            if( i < count - 1){
                result = result + ",";
            }
        }
        result = result +  "]";
        return result;
    }
}