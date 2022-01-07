/**
 * Class: DoubleList
 *
 * Description: This class implements a double linked list of integers. 
 *
 * Dependencies:
 *              This list implementation utilizes the NodeDoubleList. The ultimate
 *              goal is to hide the definition and use of NodeDoubleList  
 *              from the user of the DoubleList class.  In this case we are going to
 *              allow the user to see the nodes of the list.
 */
 
public class DoubleList<T>
{
    //*****************************************************************************
    //*** Declaration of private attributes of the list                         ***
    //*****************************************************************************
	
    private NodeDoubleList<T> m_pHead;    // Reference to the head of the list
    private NodeDoubleList<T> m_pTail;    // Reference to the tail of the list
    private NodeDoubleList<T> m_pCurrent; // Reference to the current node of the
                                          // list for search and iteration purposes                      
										  
    private int m_iCount;                 // Maintains the number of elements in the list
                                         
    
    /**
     * Default constructor of the instance of a double list.
     * The list is created empty 
     */
    public DoubleList()
    {
        setHead(null);
        setTail(null);
        setCurrent(null);
        m_iCount = 0;                     // Initialize the counter
    }
    
    /**
     * Accessor method to return the reference to the head of the list.
     * If the list is empty, a null reference is returnd.
     * @return Reference to the head of the list.
     */
    public NodeDoubleList<T>	getHead()    { return m_pHead;              }
    
    /**
    //*** This method should be PRIVATE or PROTECTED.  It is a dangerous method 
    //*** to be accessed  or called by the user.  
	//*** @param head - Mode to which the reference will be set.
	//*** @return Reference to the resulting head node.
	 */
    protected NodeDoubleList<T> setHead(NodeDoubleList<T> head)
    {
        return m_pHead = head;
    }
    
    /**
     * Accessor method to return the reference to the tail of the list.
     * If the list is empty, a null reference is returnd.
     * @return Reference to the tail of the list.
     */
    public NodeDoubleList<T> getTail()    { return m_pTail;         }
    
    /**
    //*** This method should be PRIVATE or PROTECTED.  It is a dangerous method 
    //*** to be accessed  or called by the user.  
	//*** @param tail - Mode to which the reference will be set.
	//*** @return Reference to the resulting tail node.
	 */
    protected NodeDoubleList<T> setTail(NodeDoubleList<T> tail)
	
    {
        return m_pTail = tail;
    }

    /**
     * Accessor method to return the reference to the current node of the list.
     * If the list is empty, a null reference is returnd.
     * @return Reference to the current node of the list.
     */
    public NodeDoubleList<T> getCurrent() { return m_pCurrent;      }
    
	/**
    //*** This method should be PRIVATE or PROTECTED.  It is a dangerous method 
    //*** to be accessed  or called by the user.  
	//*** @param current - Mode to which the reference will be set.
	//*** @return Reference to the resulting current node.
	 */
    protected NodeDoubleList<T> setCurrent(NodeDoubleList<T> current){	return m_pCurrent = current;	}
	
    /**
     * Accessor method to return count of nodes in the list.
     * If the list is empty, 0 is returned.
     * @return number of nodes in the list.
     */
    public int getCount()                  { return m_iCount;        }
    
    /**
    //*** This method should be PRIVATE or PROTECTED.  It is a dangerous method 
    //*** to be accessed  or called by the user.  
	//*** This method is used to increment the count
	//*** @return the resulting value of hre comment
	 */
    protected int incCount()               { return ++m_iCount;      }
	
	/**
    //*** This method should be PRIVATE or PROTECTED.  It is a dangerous method 
    //*** to be accessed  or called by the user. 
	//*** This method is used to decrement the count 
	//*** @return the resulting value of hre comment
	 */
    protected int decCount()               { return --m_iCount;      }
	
    //*****************************************************************************
    //*** 					LIST OPERATION METHODS                              ***
    //*****************************************************************************

    /**
     * Method to check if the list is empty.
     * @return true of the list is empty; false if the list is not empty
     */
    public boolean isEmpty()               { return getCount() == 0; }

    /**
     * Method to advance the current node pointer in the list to the next node.
     * If the list is empty, the pointer is not advanced and false is returned.
     * If the current pointer points to the last node, the pointer to the current
     * node is not advanced and false is returned.  If the pointer points to the
     * node that is not the last in the list, the pointer is advanced to the next 
     * node and true is returned.
     * @return false if the list is empty or the pointer points at the end of the 
     * list.  Otherwise, if the pointer was advanced, true is returned.
     */
    public boolean advance()
    {
        //***
        //*** Make sure the list is not empty and current is not pointing to the tail.
		//*** if either of these are true, return false
        //***
        if ((isEmpty()) || (getCurrent() == getTail()))
        {
            return false;
        }
        
        //***
        //*** Advance physically
        //***
        setCurrent(getCurrent().getNext());
        return true;
    }
	
	/**
     * Method to move the current node pointer in the list to the previous node. 
	 *If the list is empty, the pointer is not moved and false is returned.
	 *If the current pointer points to the first node, the pointer to the current
	 *node is not moved back and false is returned. If the pointer points to the
	 *node that is not the first in the list, the pointer is moved back to the 
	 *previous node and true is returned.
     * @return false if the list is empty or the pointer points at the beginning of the 
     * list.  Otherwise, if the pointer was moved back, true is returned.
     */
    public boolean backup()
    {
        //***
        //*** Make sure the list is not empty and current is not pointing to the head.
		//*** if either of these are true, return false.
        //***
        if ((isEmpty()) || (getCurrent() == getHead()))
        {
            return false;
        }
        
        //***
        //*** Backup physically
        //***
        setCurrent(getCurrent().getPrev());
        return true;
    }
    
    /**
     * Method to set the current pointer to the head of the list.  If the list is
     * empty, false is returned to indicate that nothing was done.  If the list is
     * not empty, the current pointer is set to the head of the list.
     * @return true if the list was not empty, false if the list was empty
     */
    public boolean reset()
    {
        //***
        //*** Make sure the list is not empty
        //***
        if (getCount() == 0)
        {
            return false;
        }
        
        //***
        //*** Reset to beginning of list
        //***
        setCurrent(getHead());
        return true;
    }
	
	/**
     * Method to set the current pointer to the tauk of the list. 
	 *If the list is empty, false is returned to indicate that nothing was done.
	 *If the list is not empty, the current pointer is set to the tauk of the list.
     * @return true if the list was not empty, false if the list was empty.
     */
	public boolean fastForward()
	{
		//***
        //*** Make sure the list is not empty
        //***
		if (getCount() == 0)
        {
            return false;
        }
		//***
		//*** Fastforward to end of list
		//***
        setCurrent(getTail());
		return true;
	}
    /**
     * Method to insert a node at the beginning of the list.  
     * If the current node is pointing in the middle of the list, it is NOT affected by this operation.
     * If the new node is the only node in the list, it becomes the current node.
     * @param data data to be stored in the node.
     * @return number of nodes in the list.
     */
    public int insertFirst(T data)
    {
		//***
        //*** Create a node and make the head of the list with prev set to null 
        //***
		NodeDoubleList<T> node = new NodeDoubleList<T>(data, getHead(), null);
		
		//***
        //*** We now have the node pointing at the head.  See if the list is empty.  If so, set references
        //*** to point accordingly.
        //***
        if (isEmpty())
        {
			setHead(node);
            setTail(node);
            setCurrent(node);
        }
		
        //***
        //*** Create the new node and set it to reference the original head of the list.
        //***
		getHead().setPrev(node);
        setHead(node);
		setCurrent(node);	
		
        //***
        //*** The head becomes the new node and current is also set to that node
        //***
		
        return incCount();
    }

    /**
     * Method to insert a node at the end of the list.
     * If the current node is pointing at one of the nodes, it is not affected.
     * If the new node is the only node in the list, the head, tail, and current references are set to
     * point at the new node.
     * @param data data to be stored in the node.
     * @return number of nodes in the list
     */
    public int insertLast(T data)
    {
        //***
        //*** If the list is empty, we are going to do the operation of insert at the head and exit
        //***
        if (isEmpty())
        {
            return insertFirst(data);
        }

        //***
        //*** We now have at least one node in the list. 
        //*** Create the new node and make it the tail of the list and set reference to the original tail
        //***
        NodeDoubleList<T> node = new NodeDoubleList<T>(data, null, getTail());
        getTail().setNext(node);
        setTail(node);     		// Move tail to the last position
		setCurrent(node);
		
        return incCount();
    }


    /**
     * Method to insert a node immediately after the current node.  
     * If the list is empty, the node is inserted as the only node of the list, and the current node
     * is set to reference the only node in the list. 
     * @param data to be stored in the node
     * @return number of nodes in the list
     */
    public int insertAfter(T data)
    {
        
        //***
        //*** If the list is empty, we are going to do the operation of insert at the head and exit
        //***
        if (isEmpty())
        {
            return insertFirst(data);
        }
		
        //***
        //*** The list is definitely not empty, so we are going to insert the node after the current.
        //*** Create the new node referencing the node that the current node is referencing
        //***
        NodeDoubleList<T> node = new NodeDoubleList<T>(data, getCurrent().getNext(), getCurrent());
        getCurrent().setNext(node);             // Set current node to reference the new node
		node.getNext().setPrev(node);			// Create link between next node and new node
		
        return incCount();
 
    }

    /**
     * Method to insert a node immediately before the current node.  
     * If the list is empty, the node is inserted as the only node of the list, and the current node
     * is set to reference the only node in the list. 
     * @param data to be stored in the node
     * @return number of nodes in the list
     */
    public int insertBefore(T data)
    {
        
        //***
        //*** If the list is empty, we are going to do the operation of insert at the head and exit
        //***
        if (isEmpty())
        {
            return insertFirst(data);
        }
		
        //***
        //*** The list is definitely not empty, so we are going to insert the node after the current.
        //*** Create the new node referencing the node that the current node is referencing
        //***
        NodeDoubleList<T> node = new NodeDoubleList<T>(data, getCurrent(), getCurrent().getPrev());
        getCurrent().setPrev(node);             // Set current node to reference the new node
		node.getPrev().setNext(node);			// Create link between previous node and new node
		
        return incCount();
 
    }


    /**
     * Method to delete the current node in the list
     * @return number of nodes in the list after completion of the operation.
     */
    public int deleteCurrent()
    {
        //***
        //*** Case 1.  The list is empty.  We simply do nothing.
        //***
        if (isEmpty())
        {
            return getCount();
        }

        //***
        //*** Case 2.  List has only one node.
        //***
        if (getHead() == getTail()) 
        {
            setHead(null);
            setTail(null);
            setCurrent(null);
            return decCount();
        }

        //***
        //*** Case 3. Current node is the head.
        //***
        if (getHead() == getCurrent())
        {
            setCurrent(getHead().getNext());
			getCurrent().setPrev(null);		// Sever the link between the current node (node after head)
											// and the node preceeding it
            getHead().setNext(null);
            setHead(getCurrent());
            return decCount();
        }

        //***
        //*** The following case covers both current node in the middle and current node as the last 
        //*** node.
        //***
        NodeDoubleList<T> tmp = getHead();               // Create temporary reference; start with head
        
        //***
        //*** Find the node that precedes the current node
        //***
        while  (tmp.getNext() != getCurrent()) 
        {
            tmp = tmp.getNext();
        }

        //***
        //*** Case 4. We are deleting the node that precedes the last node.  In this case
        //***         the new current node will move back to what the new tail node is.
        //***
        if (tmp.getNext() == getTail())
        {
            //***
            //*** Delete the tail
            //***
            tmp.setNext(null);
            setCurrent(tmp);
			getTail().setPrev(null); // Sever the link between the current node (tail) and the node preceeding it
            setTail(tmp);
            return decCount();
        }

        //***
        //*** Case 5: Now that we are here, we are looking at the node preceding the current node.
        //***         We will delete the current node and make the next node the current node.
        //***
        tmp.setNext(getCurrent().getNext());
        getCurrent().setNext(null);
        setCurrent(tmp.getNext());
		getCurrent().setPrev(null); // Sever the link between the current node and the node preceeding it
		
        return decCount();
    }


    /**
     * Method to get the value of the current node.
     * @return data object stored by the current node.  If the list is empty, null is returned.
     * @throw OutOfBoundsException if the list is empty.
     */
    public T getData() throws IndexOutOfBoundsException
    { 
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        
        return getCurrent().getData();       
    }

    /**
     * Method to set the value of the current node.
     * @param data Object to be set to the current node.
     * @return data value that was just set to the current node
     */
    public T setData(T data) //throws IndexOutOfBoundsException
    { 
        if (isEmpty())
        {
            //throw new IndexOutOfBoundsException("The list is empty");
            insertFirst(data);
            return data;
        }
        return getCurrent().setData(data);   
    }

    /**
     * Method to find the first occurence of data item in the list starting from head.
     * If the node containing the matching value is found, the current is set to point to that node.
     * @param data data item sought in the list
     * @return true if found, false if not found.
     */
    public boolean find(T data)
    {
		//***
		//*** If list is empty, there is no node to find - return false
		//***
		if (isEmpty())
        {
            return false;
        }
		
        //***
        //*** We need a temporary reference to traverse the list
        //***
        NodeDoubleList<T> tmp = getHead();     // Create temporary reference; start with head

        //***
        //*** Traverse the list until reached the end or the value is found
        //***
        while ( (tmp != null) && (! tmp.getData().equals(data)) )
        {
            tmp = tmp.getNext();
        }
        
        //***
        //*** Check what stopped the search
        //*** 
        if (tmp == null)
        {
            return false;
        }
        
        //***
        //*** We didn't fall off the end of the list.
        //*** Set current node to reference it.
        //***
        setCurrent(tmp);
		
        return true;
    }


    /**
     * Method to index the element of the list by index.  If the index excedes the number of elements in the list,
     * an IndexOutOfBoundsException is thrown.
     * @param index - Index of the element to be accessed
     * @return Data stored by the indexed element
     * @throws IndexOutOfBoundsException thrown when attempting to index past the end of list.
     */
    public T getItemAt(int index) throws IndexOutOfBoundsException
    {
        //***
        //***  Make sure the list is not empty and we are within the existing element bounds
        //*** 
        if ((isEmpty()) || (index < 0) || (index >= getCount()) )
        {
            throw new IndexOutOfBoundsException("Accessing list outside its bounds.");
        }
        
        //***
        //*** Index is good. Find the node.
        //***
        
        //***
        //*** We need a temporary reference to traverse the list
        //***
        NodeDoubleList<T> tmp = getHead();               // Create temporary reference; 
                                                         // start with head
        //***
        //*** Iterate until i reaches index
        //***
        int i = 0;                                        // Initialize traveling index
        while (i < index)
        {
            tmp = tmp.getNext();
            i++;
        }

        //***
        //*** We are now where we want to be.
        //***
        return tmp.getData();

    }
	
    /**
     * Method to set a value to the element by index.  If the index excedes the number of elements in the list,
     * an IndexOutOfBoundsException is thrown.
     * @param index - Index of the element to be accessed
     * @param data - Data to be set to the node indexed by index
     * @return Data stored by the indexed element
     * @throws IndexOutOfBoundsException thrown when attempting to index past the end of list.
     */
    public T setItemAt(int index, T data) throws IndexOutOfBoundsException
    {
        //***
        //***  Make sure the list is not empty and we are within the existing element bounds
        //*** 
        if ((isEmpty()) || (index < 0) || (index >= getCount()) )
        {
            throw new IndexOutOfBoundsException("Accessing list outside its bounds.");
        }
        
        //***
        //*** Index is good. Find the node.
        //***
        
        //***
        //*** We need a temporary reference to traverse the list
        //***
        NodeDoubleList<T> tmp = getHead();               // Create temporary reference; 
                                                         // start with head
        //***
        //*** Iterate until i reaches index
        //***
        int i = 0;                                        // Initialize traveling index
        while (i < index)
        {
            tmp = tmp.getNext();
            i++;
        }

        //***
        //*** We are now where we want to be.
        //***
        return tmp.setData(data);
    }
    
}



