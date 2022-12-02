#include "doublyLinkedList.h"
#include <stdlib.h>


DoublyLinkedList* createDLList() {
    return malloc(sizeof(DoublyLinkedList));
}

void freeDLList(DoublyLinkedList *list) {
    Node *cur = list->front;
    Node *node;

    while (cur != NULL) {
        node = cur;
        cur = cur->next;
        free(node);
    }

    free(list);
}


void insertNodeAtFront(DoublyLinkedList *list, Node *node) {
    if (list->count == 0) {
        list->front = node;
        list->back = node;
    } else {
        node->next = list->front;
        list->front->prev = node;
    }

    list->count++;
}

void insertNodeAtBack(DoublyLinkedList *list, Node *node) {

}
