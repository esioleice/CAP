#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int data;
    struct node *next;
}Node;

typedef struct q{
    int count;
    Node *front;
    Node *rear;
}Queue;

Queue *createQueue();
void enqueue(Queue *queue, int data);
void dequeue(Queue *queue);
void display(Queue *queue);
void displayQueue(Queue *queue);