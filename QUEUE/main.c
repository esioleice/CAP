#include <stdio.h>
#include <stdlib.h>
#include "header.h"

int main(){
  Queue *queue = createQueue();
 
    int choice, num;
 
    do {
        printf("1. Enqueue\n" );
        printf("2. Dequeue\n" );
        printf("3. Display Queue\n");
        printf("4. Exit\n" );
        printf("Enter choice: ");
        scanf("%d", &choice );
 
        switch (choice) {
            case 1:
                printf("Enter number to enqueue: ");
                scanf("%d", &num);
                enqueue(queue, num);
                break;
            case 2:
                dequeue(queue);
                break;
            case 3:
                displayQueue(queue);
                break;
        }
 
    }while(choice != 4);
}