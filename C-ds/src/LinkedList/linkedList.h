#ifndef LINKED_LIST_H
#define LINKED_LIST_H

/**
 * Struct used as the nodes of the linked list.
 */
typedef struct Node {
    void *data;
    struct Node *next;
} Node;

/**
 * Struct used for meta data about the linked list
 */
typedef struct linkedList {
    Node *front;
    int count;

} LinkedList;


/**
 * Allocates memory on the heap and returns a reference to it. 
 * Calling function responsible to free allocated memory.
 * @return a pointer to the created list.
 */
LinkedList* createLinkedList ();

/**
 * Free the list and all the nodes in it.
 * @param list the LinkedList to be freed.
 */
void freeLinkedList (LinkedList *list);

/**
 * Inserts an item at the front of the list.
 * @param list the LinkedList to inset the item into. 
 * @param data the data of the item to be inserted.
 */
void insertItem (LinkedList *list, void *data);

/**
 * Insert a node into the list at the front.
 * @param list the LinkedList to insert the node into. 
 * @param node the node of the item to be inserted.
 */
void insertNode (LinkedList *list, Node *node);

/**
 * Insert a node at a particular index.
 * @param list the LinkedList to insert the node into. 
 * @param node the node of the item to be inserted.
 * @param index the index at which node is to be inserted.
 * @return an exit code based on the success of the insertion.
 */
int insertNodeAtIndex (LinkedList *list, Node *node, int index);

/**
 * Map a function to all the data elements of the list.
 * The operation must be done on the data itself and a void
 * pointer is passed to the function.
 * @param list the LinkedList to insert the node into. 
 * @param func the function to call on each node.
 */
void mapLinkedList (LinkedList *list, void (*func) (void*));

/**
 * Allocates memory for a node and returns a pointer to it.
 * Calling function is responsible to free the node.
 * @param data the data of the node to create.
 * @return A pointer to the node on the heap.
 */
Node* mallocNode (void *data);

/**
 * Frees a node pointer.
 * @param node the node to be freed.
 */
void freeNode (Node *node);

/**
 * Insert a item at a particular index.
 * @param list the LinkedList to insert the data item into. 
 * @param data the data to insert into the list.
 * @param index the index at which data is to be inserted.
 * @return an exit code based on the success of the insertion.
 */
int insertItemAtIndex (LinkedList *list, void *data, int index);

/**
 * Deletes a node at a particular index.
 * Calling function responsible to free memory of Node.
 * @param list the LinkedList to delete node from.
 * @param index the index at which node is to be deleted.
 * @return a pointer to the deleted node. Returns NULL if index is out of bounds.
 */
Node* deleteNodeByIndex (LinkedList *list, int index);

/**
 * Deletes a particular item in the list.
 * @param list the LinkedList to delete item from.
 * @param index the index at which item is to be deleted.
 * @return a pointer to the data. Return NULL if index is out of bounds.
 */
void* deleteItemByIndex (LinkedList *list, int index);

/**
 * Get an pointer to the Node at a particular index of the list.
 * @param list the LinkedList to get node from.
 * @param index the index at which node is to be retrieved from.
 * @return a pointer to the node. Returns NULL if index is out of bounds.
 */
Node* getNodeByIndex (LinkedList *list, int index);

/**
 * Get the pointer to the data at a particular index.
 * @param list the LinkedList to get item from.
 * @param index the index at which item is to be retrieved from.
 * @return a pointer to the data. Returns NULL if index is out of bounds.
 */
void* getItemByIndex (LinkedList *list, int index);

#endif 
