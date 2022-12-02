#ifndef DOUBLY_LINKED_LIST_H
#define DOUBLY_LINKED_LIST_H

typedef struct Node {
    void *data;
    struct Node *next;
    struct Node *prev;
} Node;

typedef struct doublyLinkedList {
    Node *front;
    Node *back;
    int count;
} DoublyLinkedList;

DoublyLinkedList* createDLList ();

void freeDLList (DoublyLinkedList *list);

void insertNodeAtFront (DoublyLinkedList *list, Node *node);

void insertItemAtFront (DoublyLinkedList *list, void *data);

void insertNodeAtBack (DoublyLinkedList *list, Node *node);

void insertItemAtBack (DoublyLinkedList *list, void *data);

#endif
