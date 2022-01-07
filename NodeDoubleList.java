public class NodeDoubleList<T>
{
	
    //*********************************************************************************
    //*** Declaration of the private attributes of the node                         ***
    //*********************************************************************************
    private T m_iIntData;                         // Wrapper of the Integer type
    private NodeDoubleList<T> m_pNext;            // Pointer to the next node
    private NodeDoubleList<T> m_pPrev; 			  // Pointer to the previous node
	
	//Default Constructor
	//All values set to null
    public NodeDoubleList()
    {
        setData(null);
        setNext(null);
		setPrev(null);
    }
    
	//Initializing Constructor
	//A constructor to set the data, next node, and previous node 
    public NodeDoubleList(T data, NodeDoubleList<T> next, NodeDoubleList<T> prev)
    {
        setData(data);
        setNext(next);
		setPrev(prev);
    }
    
    /**
     * Method to get data from the node.  The method returns data stored in the node in 
     * the wrapper form.
     * @return Data in the Integer wrapper form. null if no data is assigned.
     */
    public T getData(){
		
		if(m_iIntData == null)
			return null;
		else
			return m_iIntData;
		
		}

    /**
     * Method to set data to the node.  
     *
     * @param val = int or Integer value to be set to the node's data portion.
     * @return - Wrapper value of data that was set to the node
     */
    public T setData(T val)     
    { 
        if (val == null)
        {
            m_iIntData = null;
        }
        else
        {
            m_iIntData = val;
        }
        return m_iIntData; 
    }
	
    /**
     * Method to return the pointer to the previous value of the node.
     * @return previous value of the node.
     */
	public NodeDoubleList<T> getPrev()		{return m_pPrev;						}

    /**
     * Method to return the pointer to the next value of the node.
     * @return next value of the node.
     */
    public NodeDoubleList<T> getNext()     { return m_pNext;                       }
    
	/**
     * Method to set the pointer to point at a certain node.
     * @param previous pointer to the previous node.
     * @return value that has been set to the node.
     */
	public NodeDoubleList<T> setPrev(NodeDoubleList<T> prev)
    {
        return m_pPrev = prev;
    }
	
    /**
     * Method to set the pointer to point at a certain node.
     * @param next pointer to the next node.
     * @return value that has been set to the node.
     */
    public NodeDoubleList setNext(NodeDoubleList next)
    {
        return m_pNext = next;
    }
}
