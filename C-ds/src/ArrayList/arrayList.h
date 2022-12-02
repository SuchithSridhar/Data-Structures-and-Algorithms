#ifndef ARRAYLIST_H
#define ARRAYLIST_H

#define INITIAL_ARRAY_SIZE 50

typedef struct {
    int size;
    int elem_size;
    int totalSize;
    void* array;
} ArrayList;

/**
 * Create an array list on the heap and return a pointer to it.
 * @param elem_size the size of each element to be stored in the array.
 * @return a pointer to the created array list. Return NULL if malloc fails.
 */
ArrayList* createArrayList(int elem_size);

/**
 * Destroy the array list passed in - free it from memory.
 * @param *list the array list to be freed.
 * @return Returns an exit code.
 */
int destroyArrayList(ArrayList *list);

/**
 * Get the size of the array list passed in.
 * @param *list the array list to get the size of.
 * @return Return an exit code.
 */
int getArrayListSize(ArrayList *list);

/**
 * Insert an element into the array list.
 * @param *list The array list to insert into element.
 * @param *elem A pointer to the element to be stored.
 * @return Returns an exit code.
 */
int insertIntoArrayList(ArrayList *list, void* elem);

/**
 * Delete an element from the array list.
 * @param *list The array list from which to delete an element.
 * @param index The index of the element to be deleted.
 * @return Returns an exit code.
 */
int deleteFromArrayList(ArrayList *list, int index);

/**
 * Get an element from an array.
 * Note, if an element is deleted after getting it
 * that memory will be overwritten. So, make sure to copy
 * the element into another part of memory.
 * @param *list The array list to access element from.
 * @param index The index of the element to be retrieved.
 * @return The element at the given index. Returns NULL if out of bounds.
 */
void* getFromArrayList(ArrayList *list, int index);

/**
 * Expand the arrayList for when it gets full by chunk size.
 * @param *list The ArrayList to be expanded.
 * @param chunk the size to increase the array by.
 * @return Returns an exit code.
 */
int increaseArrayListSize(ArrayList *list, int chunk);

/**
 * Double the size of the array list for when it gets full.
 * @param *list The ArrayList to be expanded.
 * @return Returns an exit code.
 */
int doubleArrayListSize(ArrayList *list);

#endif

