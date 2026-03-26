#include <cstdlib>
#include <ctime>

void vvod(int m[], int n) {
	for (int i = 0; i < n; i++) {
		std::cin >> m[i];
	}
}

void vvodRand(int m[], int n) {
	for (int i = 0; i < n; i++) {
		m[i] = rand() % 100;
	}
}

void vivod(int m[], int n) {
	int f = 0;
	for (int i = 0; i < n; i++) {
		std::cout << m[i] << " ";
	}
}

int main(){
    setlocale(LC_ALL, "ru");
    srand(time(0));
    return 0;
}