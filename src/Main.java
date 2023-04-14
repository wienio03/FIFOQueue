class QueueNode {
    Integer info;
    QueueNode next;

    public QueueNode(int info){
        next = null;
        this.info = info;
    }

}

class FIFO {
        private QueueNode front;
        private QueueNode rear;

    public FIFO() {
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return (front == null || rear == null);
    }
    public void offer(int data){
        QueueNode tmp = new QueueNode(data);

        if(rear == null){
            front = rear = tmp;
        }
        else{
            rear.next = tmp;
            rear = tmp;
        }
    }
    public QueueNode poll(){
        if(!isEmpty()){
            QueueNode tmp = front;
            front = front.next;
            if(front == null)
                rear = null;
            return tmp;
        }
        return null;
    }
    public QueueNode peek(){
        if(isEmpty())
            return null;
        return front;
    }
    public int size(){
        QueueNode tmp = front;
        int i = 0;
        while(tmp != null) {
            tmp = tmp.next;
            i++;
        }
        return i;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("FIFO Queue: ");
        if(isEmpty())
            sb.append("empty");
        else{
            QueueNode tmp = front;
            while(tmp != null){
                sb.append(tmp.info);
                tmp = tmp.next;
            }
        }
        return sb.toString();
    }
    @Override
    public int hashCode(){
        int result = front.hashCode();
        result = 31 * result + size();
        return result;
    }
    @Override
    public boolean equals(Object obj){
        boolean checkInfo = false;
        if(obj.getClass() != getClass() || obj == null)
            return false;
        FIFO fifo = (FIFO) obj;
        if(fifo.size() != size())
            return false;
        QueueNode tmp = front;
        QueueNode objTmp = fifo.front;
        while(front != null && objTmp != null){
            if(tmp.info == objTmp.info) checkInfo = true;
            else checkInfo = false;
            tmp = tmp.next;
            objTmp = objTmp.next;
        }
        return checkInfo;
    }
}


public class Main {
    public static void main(String[] args) {
        FIFO queue = new FIFO();
        queue.offer(10);
        queue.offer(20);
        QueueNode x = queue.poll();
        System.out.println("Return value: " + x.info + " \n" + queue.toString());
    }
}