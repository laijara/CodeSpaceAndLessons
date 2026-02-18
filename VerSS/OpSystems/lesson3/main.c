#include <stdio.h>

int main() {
    char name[100];
    printf("Введите ваше имя: ");
    scanf("%99s", name);
    printf("Салам кинул, %s", name);
    printf("\n");
    return 0;
}