import java.util.Scanner;

class Dll
{
    Node start;
    static class Node
    {  
        int barcode_no , price ,stock_avail , expiry_date;
        Node next;
        Node prev;
        Node(int a , int b ,int c ,int d)
        {
            barcode_no = a;
            price = b;
            stock_avail = c;
            expiry_date = d;
        }
    }   

    static Dll add(Dll list, int a, int b , int c , int d)
    {
        Node new_node = new Node(a,b,c,d);
        new_node.next = null;
        new_node.prev = null;
        if(list.start== null)
        {
            list.start = new_node;
        }
        else
        {
            Node last = list.start;
            Node prev = list.start;
            while(last.next!=null)
            {
                last.prev = last;
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    } 

    static void print(Dll list)
    {
        Node q = list.start;
        System.out.println("Barcode No"+"\t "+"Price"+"\t"+ "Stock Available"+"Expiry Date");
        while(q != null)
        {
            System.out.println(q.barcode_no+"\t"+"\t"+q.price+"\t"+"\t"+ q.stock_avail+"\t"+"\t"+ q.expiry_date);
            q=q.next;
        }
        return;
    }

    static void issue( Dll list)
    {
        Node n = list.start;
        Scanner obj3 = new Scanner(System.in);
        System.out.println("Enter Barcode No.");
        int a = obj3.nextInt();
        System.out.println("Enter Price");
        int b = obj3.nextInt();
        System.out.println("Enter Stock Available");
        int c = obj3.nextInt();
        System.out.println("Enter Expiry Date");
        int d = obj3.nextInt();
        while(n.barcode_no!=a)
        {
            n = n.next;
        }
        n.price = b;
        n.stock_avail = c;
        n.expiry_date = d;
        return;
    }

    static void returnmed( Dll list)
    {
        Node n = list.start;
        System.out.println("Enter Barcode No. ");
        Scanner c = new Scanner(System.in);
        int a = c.nextInt();
        while(n.barcode_no!=a)
        {
            n = n.next;
        }
        n.price = 0;
        n.stock_avail = 0;
        n.expiry_date = 0;
        return;
    }
}

public class Project 
{
    public static void main(String [] args)
    {
        Dll list = new Dll();
        list = Dll.add(list,111,0,0,0);
        list = Dll.add(list,222,0,0,0);
        list = Dll.add(list,333,0,0,0);
        list = Dll.add(list,444,0,0,0);
        list = Dll.add(list,555,0,0,0);

        while(true)
        {
            System.out.println("Medical Management");
            System.out.println("1: Add a medicine");
            System.out.println("2: Price of a medicine");
            System.out.println("3: Stock available of a medicine");
            System.out.println("4: Print medicine details");
            System.out.println("5: Exit");

            Scanner obj1 = new Scanner(System.in);
            System.out.println("Enter your choice");
            int choice = obj1.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the barcode no.");
                    int x = obj1.nextInt();
                    list = Dll.add(list, x, 0,0,0);
                    break;

                case 2:
                    Dll.issue(list);
                    break;

                case 3:
                    Dll.returnmed(list);
                    break;

                case 4:
                    Dll.print(list);
                    break;

                case 5: 
                    System.exit(0); 
                    break;           
            }
        }
    }
}