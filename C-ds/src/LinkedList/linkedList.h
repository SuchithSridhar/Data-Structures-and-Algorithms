#ifndef LINKED_LIST_H
#define LINKED_LIST_H

typedef struct Node {
    void *data;
    struct Node *next;
} Node;

typedef struct linkedList {
    Node *front;
    int count;

} LinkedList;


/**
 * Allocates memory on the heap and returns a reference to it. 
 * Returns a pointer to the created list.
 */
LinkedList* createLinkedList ();

/**
 * Free the list and all the nodes in it.
 */
void freeLinkedList (LinkedList *list);

/**
 * Inserts an item at the front of the list.
 */
void insertItem (LinkedList *list, void *data);

/**
 * Insert a node into the list at the front.
 */
void insertNode (LinkedList *list, Node *node);

/**
 * Insert a node at a particular index.
 * Returns EXIT_FAILURE if it fails to insert the node.
 * Returns EXIT_SUCCESS if node was inserted successfully.
 */
int insertNodeAtIndex (LinkedList *list, Node *node, int index);

/**
 * Map a function to all the data elements of the list.
 * The operation must be done on the data itself and a void
 * pointer is passed to the function.
 */
void mapLinkedList (LinkedList *list, void (*func) (void*));

/**
 * Allocates memory for a node and returns a pointer to it.
 */
Node* mallocNode (void *data);

/**
 * Frees a node pointer.
 */
void freeNode (Node *node);

/**
 * Insert a item at a particular index.
 * Returns EXIT_FAILURE if it fails to insert the node.
 * Returns EXIT_SUCCESS if node was inserted successfully.
 */
int insertItemAtIndex (LinkedList *list, void *data, int index);

/**
 * Deletes a node at a particular index.
 * Returns a pointer to the deleted node.
 * Calling function responsible to free memory of Node.
 * Returns NULL if index is out of bounds.
 */
Node* deleteNodeByIndex (LinkedList *list, int index);

/**
 * Deletes a particular item in the list.
 * Returns a pointer to the data if found.
 * Returns NULL if index is out of bounds.
 */
void* deleteItemByIndex (LinkedList *list, int index);

/**
 * Get an Node at a particular index of the list.
 * Returns NULL if index is out of bounds.
 */
Node* getNodeByIndex (LinkedList *list, int index);

/**
 * Get a pointer to the data item at a particular index of list.
 * Returns NULL if index is out of bounds.
 */
void* getItemByIndex (LinkedList *list, int index);

#endif 
