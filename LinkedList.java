import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LinkedList<T extends Comparable> {
    private Node<T> head;
    private  Node<T> temp;
    public int memAccess;
    public long time=0;

    public long getTime(){
        return time;
    }
public int getMemAccess(){
    return memAccess;
}

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }
    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        memAccess++;
        newNode.next=head;
        head=newNode;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        Node<T> iterator=head;
        while(iterator.next!=null){
            iterator=iterator.next;
        }iterator.next=newNode;

    }
    public T findMin(){
        if (head==null)
            return null;
        T min=head.value;
        Node<T> iterator=head.next;
        while (iterator!=null){
            if(min.compareTo(iterator.value)==1)
                min=iterator.value;
            iterator=iterator.next;
        }
        return min;
    }
    public void swapLastAndFirstNodes(){
        Node<T> iterator = head;
        Node<T> temp1;
        Node<T> temp2=head;
        Node<T> temp3=head.next;
        while (!(iterator.next.next==null)){
            iterator=iterator.next;
        }
        temp1=iterator.next;
        head=temp1;
        temp1.next=temp3;
        temp2.next=null;
        iterator.next=temp2;
    }
    public void sortedInsert(T val){
        Node<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else if (val.compareTo(head.value)<=0){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.value.compareTo(val)==-1){
                iterator=iterator.next;
            }
            newNode.next=iterator.next;
            iterator.next=newNode;
        }
    }
    public void deleteTheFirst(){
        if(head!=null)
            head=head.next;
    }

    public void delete(T val){
        while (this.search(val)){
            if(head==null)
                return;
            if(head.value.compareTo(val)==0)
                head=head.next;
            else{
                Node<T> previous=head, iterator=head;
                memAccess++;
                while(iterator!=null && iterator.value.compareTo(val)!=0)   {
                    previous=iterator;
                    iterator=iterator.next;
                }
                if(iterator!=null)
                    previous.next=iterator.next;

            }
        }
    }
    public void methodB(File search1){
        long start= System.currentTimeMillis();
    try {

        Scanner myReader1 = new Scanner(search1);
        while (myReader1.hasNextLine()){
            String data1=myReader1.nextLine();
            T a =  (T) Integer.valueOf(data1);
            search(a);
        }

    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }long end= System.currentTimeMillis();
        time=end-start;

    }
    public void methodC(File search1){
        long start= System.currentTimeMillis();
        try {
            Scanner myReader1 = new Scanner(search1);
            Node<T> temp=head;
            while (myReader1.hasNextLine()){
                Node<T> previous=head, iterator=head;
                String data1=myReader1.nextLine();
                T a =  (T) Integer.valueOf(data1);
                    memAccess++;
                    while(iterator!=null && iterator.value.compareTo(a)!=0)   {
                        memAccess++;
                        previous=iterator;
                        iterator=iterator.next;
                    }
                    if(iterator!=null&&iterator!=head){
                        memAccess++;
                        memAccess++;
                    previous.next=iterator.next;
                    iterator.next=temp;
                    temp=iterator;
                    }
        }head=temp;
            myReader1.close();

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }long end= System.currentTimeMillis();
        time=end-start;}
    public void bubbleSort(){

    }

    public void recursiveAddToEnd(T val){
        head=recursiveAddToEnd(head, val);
    }
    public Node<T> recursiveAddToEnd(Node<T> tempHead, T val)
    {
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }
    public boolean recursiveSearch(T val){
            head=recursiveSearch(head,val);
            if (temp!=null){
            return  recursiveSearch(temp,val).value.compareTo(val)==0;}

            return false;
    }
    public Node<T> recursiveSearch(Node<T> iterator, T val) {
        if (iterator != null) {
            memAccess++;
            if (iterator.value.compareTo(val) == 0) {

                temp = iterator;
            } else {
                iterator.next = recursiveSearch(iterator.next, val);
                memAccess++;
            }
        }
        return iterator;
    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.print(iterator+ " ");
            iterator=iterator.next;
        }
        System.out.println();

    }

    public boolean search(T val){
        Node<T> iterator = head;
        while (iterator!=null){
            memAccess++;
            if (iterator.value.compareTo(val)==0){

                return true;
            }
            iterator=iterator.next;
            memAccess++;
        }
        return false;
    }
    public boolean searchAddToFront(T val){
        Node<T> iterator = head;
        while (!(iterator==null)){
            memAccess++;
            if (iterator.value.compareTo(val)==0){


                return true;
            }
            iterator=iterator.next;
            memAccess++;
        }
        return false;
    }
    public int count(){
        Node<T> iterator = head;
        int count=0;
        while (!(iterator==null)){
            iterator=iterator.next;
            count++;
        }
        return count;
    }
}