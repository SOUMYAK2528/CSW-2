import java.util.*;



public class linkedList{

    private Node head;

    private class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data= data;
            next= null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next= head;
        head= newNode;
    }
    public void pushtail(int value){
        Node newNode= new Node(value);
        Node curr = head;
        if(head == null){
            head.next= newNode;

        }
        while(curr.next!=null){
            curr=curr.next;

        }
        curr.next=newNode;

    }

    public void  SortedInsert(int value){
        
        Node newNode= new Node(value);
        Node curr= head;
        if(curr==null || curr.data>value){
            newNode.next=head;
            head=newNode;
            return;
        }
        while(curr.next!=null && curr.next.data<value){
            curr=curr.next;
        }
        newNode.next= curr;
        curr.next=newNode;

    }

    public void printList(){
        Node tnode = head;
        while( tnode != null){
            System.out.print(tnode.data+" ");
            tnode= tnode.next;
        }
    }

    public void sort(){
        int swapped;
        Node ptr1;
        Node lptr=null;

        if(head==null) 
            return ;
      

        do{
            swapped=0;
            ptr1=head;
            while( ptr1.next != lptr ){
                if(ptr1.data >ptr1.next.data){
                    int temp = ptr1.data;
                    ptr1.data=ptr1.next.data;
                    ptr1.next.data= temp;
                    swapped =1;
                }
                ptr1=ptr1.next;

            }
            lptr=ptr1;
        }while(swapped!=0);
    }

    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.push(4);
        list.push(5);
        list.push(90);
        list.push(81);
        list.push(12);
        //print list
        System.out.println("Original linkedlist");
        list.printList();

        //list after sorting
        System.out.println("List after sorting");
        list.sort();
        list.printList();

        System.out.println("Inserting an element in the sorted linkedlist");
        list.SortedInsert(45);
        list.printList();

    }

   
    
}