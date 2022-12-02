#ifndef HASHMAP_H
#define HASHMAP_H

struct KeyValuePair {
    void *key;
    void *value;
};

typedef struct hashMapNode {
    void *key;
    void *value;
    struct hashMapNode *next;
} HashMapNode;

typedef struct hashMap {
    struct hashMapNode* head;
    int size;
} HashMap;

typedef int (*Comparator)(const void *, const void *);

HashMap* createHashMap();
void destroyHashMap(HashMap*);

HashMapNode* createHashMapNode(void*, void*);
void destroyHashMapNode(HashMapNode*);

int insertIntoHashMap(HashMap*, void*, void*);
int replaceFromKeyHashMap(HashMap*, void*, void*, Comparator compareKeys);
struct KeyValuePair* getFromKeyHashMap(HashMap*, void*, Comparator compareKeys);
void* deleteFromKeyHashMap(HashMap*, void*, Comparator compareKeys);

#endif
