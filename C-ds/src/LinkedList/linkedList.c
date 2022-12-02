#include <stdlib.h>
#include "linkedList.h"

LinkedList* createLinkedList () {
    LinkedList *list = (LinkedList*) malloc (sizeof(LinkedList));
    list->front = NULL;
    list->count = 0;
    return list;
}

void freeLinkedList (LinkedList *list) {
    Node *cur = list->front;
    Node *node;
    for (int i = 0; i < list->count; ++i) {
        node = cur;
        cur = cur->next;
        free(node);
    }
    free(list);
}

void mapLinkedList (LinkedList *list, void (*func) (void*)) {
    Node *node = list->front;
    for (int i = 0; i < list->count; i++) {
        func(node->data);
        node = node->next;
    }
}

void insertNode (LinkedList *list, Node *node) {
    if (list->front == NULL) {
        list->front = node;
        list->count++;
        return;
    }
    
    node->next = list->front;
    list->front = node;
    list->count++;
}

int insertNodeAtIndex (LinkedList *list, Node *node, int index) {
    if (index > list->count) return EXIT_FAILURE;
    Node *cur = getNodeByIndex(list, index - 1);
    node->next = cur->next;
    cur->next = node;
    list->count++;
    return EXIT_SUCCESS;
}

Node* mallocNode (void *data) {
    Node *node = (Node *) malloc(sizeof(Node));
    node->data = data;
    return node;
}

void freeNode (Node *node) {
    free(node);
}


void insertItem (LinkedList *list, void *data) {
    Node *node = mallocNode(data);
    insertNode(list, node);
}

int insertItemAtIndex (LinkedList *list, void *data, int index) {
    Node *node = mallocNode(data);
    return insertNodeAtIndex(list, node, index);
}

Node* deleteNodeByIndex (LinkedList *list, int index) {
    Node *deleted;
    Node *cur;
    
    if (index >= list->count) return NULL;
    
    if (index == 0) {
        deleted = list->front;
        list->front = deleted->next;

    } else {
        cur = getNodeByIndex(list, index - 1);
        deleted = cur->next;
        cur->next = deleted->next;
    }

    list->count--;
    return deleted;
}

Node* getNodeByIndex (LinkedList *list, int index) {
    Node *cur = list->front;

    if (index >= list->count) return NULL;

    for (int i = 0; i < index; i++)
        cur = cur->next;

    return cur;
}

void* deleteItemByIndex(LinkedList *list, int index){
    void* item;
    Node *deleted = deleteNodeByIndex(list, index);
    item = deleted->data;
    freeNode(deleted);
    return item;
}

void* getItemByIndex (LinkedList *list, int index) {
    return getNodeByIndex(list, index)->data;
}
