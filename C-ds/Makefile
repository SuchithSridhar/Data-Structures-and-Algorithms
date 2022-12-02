CC = gcc
CFLAGS = -Wextra -Wall -g
BINDIR = bin
SRCDIR = src
TESTDIR = tests

help:
	@printf "make testLinkedList\n"

testLinkedList: $(TESTDIR)/testLinkedList.c $(SRCDIR)/LinkedList/linkedList.c
	$(CC) -o $(BINDIR)/testLinkedList $(CFLAGS) $(TESTDIR)/testLinkedList.c $(SRCDIR)/LinkedList/linkedList.c

