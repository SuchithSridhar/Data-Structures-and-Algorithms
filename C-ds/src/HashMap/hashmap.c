#include <stdlib.h>
#include "hashmap.h"

HashMap* createHashMap() {
    HashMap *map = malloc(sizeof(HashMap));
    if (map != NULL) {
        map->size = 0;
        map->head = NULL;
    }
    return map;
}

void destroyHashMap(HashMap *map) {
    HashMapNode *current = map->head;
    HashMapNode *prev;
    while (current != NULL) {
        prev = current;
        current = current->next;
        destroyHashMapNode(prev);
    }
    free(map);
}

HashMapNode* createHashMapNode(void *key, void *value) {
    HashMapNode *node = malloc(sizeof(HashMapNode));
    node->key = key;
    node->value = value;
    return node;
}

void destroyHashMapNode(HashMapNode *node) {
    free(node);
}
