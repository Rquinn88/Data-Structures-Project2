import java.util.Scanner;

public class ListTest
{
    public static void main(String[] args)
    {
        //***
        //*** Creaate the list
        //***
        SingleListInts myList = new SingleListInts();
        
        System.out.printf("Created a new list. The list contains %d elements.\n\n", myList.getCount());
        
        //***
        //*** Attempt to delete from an EMPTY list
        //***
        System.out.println("Attempting to delete a node from an empty list");
        System.out.println("==============================================");
        if (myList.deleteCurrent() == 0)
            System.out.printf("\nNo node to delete, and the operation returned %6d.\n\n", myList.deleteCurrent()); 
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");

        //***
        //*** Attempt to index into an empty list
        //***
        System.out.println("Attempting to index into an empty list");
        System.out.println("======================================");
        try
        {
            System.out.println("The item at location 0 is: " + myList.getItemAt(0));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nThe exception " + e + " has been caught.\n");
        }
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");

        //***
        //*** Add integers at the tail of the list
        //***
        System.out.printf("Adding integers %d, %d, and %d to the END of the list.\n", 1, 5, 9);
        myList.insertLast(1);
        myList.insertLast(5);
        myList.insertLast(9);
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        
        //***
        //*** Add integers at the head of the list
        //***
        System.out.printf("Adding integers %d, %d, and %d to the FRONT of the list.\n", 1, 5, 9);
        myList.insertFirst(1);
        myList.insertFirst(5);
        myList.insertFirst(9);
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        //***
        //*** Try finding an element and inserting AFTER it
        //***
        System.out.println("Locating element 1 and inserting 15 after it.\n");
        if (myList.find(1))
            myList.insertAfter(15);
        else
            System.out.println("\n****** Can't find!!!!\n");
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        //***
        //*** Try finding an element and inserting BEFORE it
        //***
        System.out.println("Locating element 15 and inserting 19 before it.\n");
        if (myList.find(15))
            myList.insertBefore(19);
        else
            System.out.println("\n****** Can't find!!!!\n");
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        //***
        //*** Adding a unique element to the end of the list and inserting a value before it
        //***
        System.out.println("Adding 25 to the end of the list and inserting 0 before it.");
        myList.insertLast(25);
        if (myList.find(25))
            myList.insertBefore(0);
        else
            System.out.println("\n****** Can't find!!!!\n");
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        //***
        //*** iterating over the list with idexing to ACCESS values. 
        //***
        System.out.println("Printing the contents of the list using indexing.");
        System.out.println();
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("Singly-Linked List: %d nodes.\n\n", myList.getCount());
        System.out.println("Node Values");
        System.out.println("-----------");

        for (int i = 0; i < myList.getCount(); i++)
            System.out.printf("myList[%2d]:  %6d\n", i, myList.getItemAt(i));
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println();
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");

        
        //***
        //*** iterating over the list with idexing to SET values. 
        //***
        System.out.println("Doubling values and rinting the contents of the list using indexing.");
        System.out.println();

        for (int i = 0; i < myList.getCount(); i++)
            myList.setItemAt(i, (myList.getItemAt(i) * 2));

        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("Singly-Linked List: %d nodes.\n\n", myList.getCount());
        System.out.println("Node Values");
        System.out.println("-----------");

        for (int i = 0; i < myList.getCount(); i++)
            System.out.printf("myList[%2d]:  %6d\n", i, myList.getItemAt(i));
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println();
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");

        //***
        //*** Test deleting a node from the middle
        //***        
        System.out.println("Find the node with the value of 30 and delete it.");
        System.out.println();

        if (myList.find(30))
            myList.deleteCurrent();
        else
            System.out.println("\n****** Can't find!!!!\n");
        System.out.printf("The current node is: %6d\n", myList.getData());
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        

        //***
        //*** Test deleting a node from the head
        //***        
        System.out.println("Delete the head node.");
        System.out.println();
        
        myList.reset();
        myList.deleteCurrent();
        System.out.printf("The current node is: %6d\n", myList.getData());
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        

        //***
        //*** Test deleting a node from the tail
        //***        
        System.out.println("Find the node with the value of 50 (the tail node) and delete it.");
        System.out.println();
        
        if (myList.find(50))
            myList.deleteCurrent();
        else
            System.out.println("\n****** Can't find!!!!\n");
        System.out.printf("The current node is: %6d\n", myList.getData());
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        
        //***
        //*** Test deleting the node before the tail
        //***        
        System.out.println("Find the node with the value of 18 (preceding the tail node) and delete it.");
        System.out.println();
        
        if (myList.find(18))
            myList.deleteCurrent();
        else
            System.out.println("\n****** Can't find!!!!\n");
        System.out.printf("The current node is: %6d\n", myList.getData());
        displayList(myList);
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");
        

        //***
        //*** Attempt to index into negative numbers
        //***
        System.out.println("Attempting to use a negative index of -1");
        System.out.println("========================================");
        try
        {
            System.out.println("The item at location -1 is: " + myList.getItemAt(-1));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nThe exception " + e + " has been caught.\n");
        }
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");

        

        //***
        //*** Attempt to index past the list bound
        //***
        int countSnapshot = myList.getCount();

        System.out.println("Attempting to index past the last element");
        System.out.println("=========================================");
        try
        {
            System.out.printf("The item at location %2d is: %6d\n", countSnapshot,  myList.getItemAt(countSnapshot));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nThe exception " + e + " has been caught.\n");
        }
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");



        //***
        //*** Attempt to index the same place, after an item has been added to the list
        //***
        countSnapshot = myList.getCount();

        System.out.println("Adding an item 224 to the list and attempting to index the same index as in the previos test");
        System.out.println("============================================================================================");
        myList.insertFirst(224);
        displayList(myList);
        System.out.println("\n\n");
        System.out.println("Now indexing:\n\n");
        try
        {
            System.out.printf("The item at location %2d is: %6d\n", countSnapshot,  myList.getItemAt(countSnapshot));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nThe exception " + e + " has been caught.\n");
        }
        System.out.println("\n\n");
        pause("Press <ENTER> to continue");



    }

    //*************************
    //*** Method to display the list
    //*************************
    public static void displayList(SingleListInts list)
    {
        System.out.println();
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println();

        System.out.printf("Singly-Linked List: %d nodes.\n\n", list.getCount());
        if (list.getCount() == 0)
        {
            System.out.println("The list is empty!!!\n");
            return;
        }
        System.out.println("Node Values");
        System.out.print("-----------");
        int nodeCount = 0;
        list.reset();
        do
        {
            if (nodeCount == 0)
                System.out.println();
            System.out.printf(" %5d", list.getData());
            nodeCount = (nodeCount + 1) % 12;
        } while (list.advance());
        System.out.println();
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println("\n");
    }


    //**************************
    //*** Method to pause the execution
    //**************************
    public static void pause(String prompt)
    {
        System.out.printf("%s ... ", prompt);
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("\n\n");
    }
}
