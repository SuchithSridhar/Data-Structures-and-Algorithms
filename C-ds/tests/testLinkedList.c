#include <stdlib.h>
#include <stdio.h>
#include "../src/LinkedList/linkedList.h"

int main(int argc, char **argv) {
    LinkedList *list = createLinkedList();

    for (int i = 0; i < argc; ++i) {
       insertItem(list, argv[i]); 
    }

    printf("Before Deletion:\n");
    for (int i = 0; i < list->count; i++){
        printf(" -> %s", (char*) getItemByIndex(list, i));
    }
    printf("\n");

    if (list->count > 2) {
        printf("Deleted: %s\n", (char*) deleteItemByIndex(list, 2));
    };

    printf("After Deletion:\n");

    for (int i = 0; i < list->count; i++){
        printf(" -> %s", (char*) getItemByIndex(list, i));
    }
    printf("\n");

    freeLinkedList(list);

    return EXIT_SUCCESS;
}
