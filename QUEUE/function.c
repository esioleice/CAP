#include <stdio.h>
#include <stdlib.h>
#include "header.h"

Queue *createQueue(){
    Queue *queue = (Queue*)malloc(sizeof(Queue));
    queue->count = 0;
    queue->front = NULL;
    queue->rear = NULL;
    return queue;
}
void enqueue(Queue *queue, int data){
    Node *temp = (Node*)malloc(sizeof(Node));
    temp->data = data;
    temp->next = NULL;
    
    if(queue->count == 0){
        queue->front = temp;
        queue->rear = temp;
    }else{
        queue->rear->next = temp;
        queue->rear = temp;
    }
    queue->count++;
}
void dequeue(Queue *queue){
    if(queue->count == 0){
        printf("Queue is empty");
        return;
    }
    Node *temp = queue->front;
    if(queue->count == 1){
        queue->front = NULL;
        queue->rear = NULL;
    }else{
        queue->front = queue->front->next;
    }
    free(temp);
    queue->count--;
}
void display(Queue *queue){
    if(queue->count == 0){
        printf("Queue is empty");
    }else{
        printf("Front: %d \t Rear: %d", queue->front->data, queue->rear->data);
    }
    printf("\n");
}
void displayQueue(Queue *queue){
    Node *temp = queue->front; 
    if(queue->count == 0){
        printf("Queue is empty.");
    }
    while(temp != NULL){
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}