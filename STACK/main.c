#include <stdio.h>
#include <stdlib.h>
#include "header.h"

int main(){
    Stack *stack = createStack();
    int choice, num;
    
    do{
        printf("Enter choice: ");
        scanf("%d", &choice);
        
        switch(choice){
            case 1: 
                printf("Enter number to push: ");
                scanf("%d", &num);
                stack = push(stack, num);
                break;
            case 2:
                printf("%d\n", pop(stack));
                break;
            case 3:
                printf("Top = %d\n", peek(stack));
                break;
        }
    }while(choice != 4);
    
    return 0;
}