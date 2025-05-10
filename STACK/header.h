#include <stdio.h>
#include <stdlib.h>


typedef struct node{
    int data;
    struct node *next;
}Node;

typedef struct queue{
    int count;
    Node *top;
}Stack;

Stack* createStack();
Stack* push(Stack *stack, int data);
int pop(Stack *stack);
int peek(Stack *stack);