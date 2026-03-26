#include <iostream>

void CompletionArray(int arr[]) {
    for (int i = 0; i <= 100; i++) {
        arr[i] = i;
    }
}

int main() {
    setlocale(LC_ALL, "ru");
    int arr[100], l = 1, r, m, inpp;
    std::cout << "Введите число - ";
    std::cin >> inpp;
    CompletionArray(arr);
    while (l < r)
    {
        if (arr[m]) {
            l = m + 1;
        }
        else {
            r = m;
        }
    }
    return 0;
}
