#include <stdlib.h>
#include <string.h>
#include "arrayList.h"

ArrayList* createArrayList(int elem_size) {
    ArrayList *newlist = (ArrayList *) malloc(sizeof(ArrayList));
    if (newlist == NULL) return NULL;

    newlist->array = malloc(elem_size * INITIAL_ARRAY_SIZE);
    if (newlist->array == NULL) {
        free(newlist);
        return NULL;
    }

    newlist->size = 0;
    newlist->elem_size = elem_size;
    newlist->totalSize = INITIAL_ARRAY_SIZE;

    return newlist;
}

int destroyArrayList(ArrayList *list) {
    free(list->array);
    free(list);
    return EXIT_SUCCESS;
}

int insertIntoArrayList(ArrayList *list, void *elem) {
    if (list->size == list->totalSize) {
         int exit_code = doubleArrayListSize(list);
         if (exit_code != EXIT_SUCCESS) return exit_code;
    }

    memcpy(list->array, elem, list->elem_size);
    list->size++;

    return EXIT_SUCCESS;
}

int getArrayListSize(ArrayList *list) {
    return list->size;
}

void* getFromArrayList(ArrayList *list, int index) {
    if (index < 0 || index >= list->size) return NULL;
    return list->array + (index * list->elem_size);
}

int deleteFromArrayList(ArrayList *list, int index) {
    // TODO: Better exit code here
    if (index < 0 || index >= list->size) return EXIT_FAILURE;
    
    if (index == list->size) {
        list->size--;
        return EXIT_SUCCESS;
    }

    void* elem_start = list->array + (index * list->elem_size);
    void* elem_end = elem_start + list->elem_size;
    void* array_end = list->array + (list->size * list->elem_size);

    // Copy from the end of the deleted element to the end of the array.
    // [ 1, 2, 3, 4 ] -> [ 1, 3, 4, 4 ]
    memcpy(elem_start, elem_end, (array_end - elem_end));
    list->size--;

    return EXIT_SUCCESS;
}

