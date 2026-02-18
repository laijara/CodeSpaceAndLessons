#include <stdio.h>
int main(){
    short var1 = 123;
    int var2 = 123123;
    long int var3 = 123123123;
    long long var4 = 123123123123;
    printf("%zu", sizeof(var1));
    printf("%zu", sizeof(var2));
    printf("%zu", sizeof(var3));
    printf("%zu", sizeof(var4));
    printf("%zu", sizeof(long long int));
    printf("\n");
    unsigned short var5 = 123;
    signed short var6 = 1223;
    printf("%i", var5);
    printf("%i", var6);
    printf("\n");

    return 0;
}