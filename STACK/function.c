#include <stdio.h>
#include <stdlib.h>
#include "header.h"

Stack* createStack(){
    Stack *stack = (Stack*)malloc(sizeof(Stack));
    stack->top = NULL;
    stack->count = 0;
    return stack;
}
Stack* push(Stack *stack, int data){
    Node *temp = (Node*)malloc(sizeof(Node));
    temp->data = data;
    temp->next = stack->top;
    stack->top = temp;
    stack->count++;
    return stack;
}
int pop(Stack *stack){
    Node *temp;
    int deleted = 0;
    if(stack->top == NULL){
        printf("Stack is empty");
    }else{
        temp = stack->top;
        stack->top = stack->top->next;
        deleted = temp->data;
        free(temp);
        stack->count--;
    }
    return deleted;
}
int peek(Stack *stack){
    if(stack->top != NULL){
        return stack->top->data;
    }else{
        return 0;
    }
}