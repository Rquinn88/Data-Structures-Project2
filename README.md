# Data-Structures-Project2

This project's goal is to create a doubly linked list in Java
It will have two classes:

Class to represent a node:

The class is named NodeDoubleList<T> and has three attributes:

• A reference to a data object, which shall be of the type defined by a generic (T). This will allow for the
  use of the list for any data types which are references to complex object types.
• A reference to the next node, which will be a reference to NodeDoubleList<T> object.
• A reference to the previous node, which will be a reference to NodeDoubleList<T> object.

Class to represent the List:

The class is named DoubleList<T> and have the following attributes:
  
• A reference to the head of the list, which is of type NodeDoubleList<T>.
• A reference to the tail of the list, which is of type NodeDoubleList<T>.
• A reference to the current node of the list, which is of type NodeDoubleList<T>. This attribute shall
  behave like a “cursor”.
• A node counter, which keeps track of the number of nodes in the list.
  
The DoubleList<T> class has the following functionality:
  
• Add node to the empty list
• Add node to the head of the list
• Add node to the tail of the list
• Add node after the current node
• Add node before the current node
• Set value to the current node
• Find node by data
• Check whether the node exists
• Delete current node
• Clear the list 
