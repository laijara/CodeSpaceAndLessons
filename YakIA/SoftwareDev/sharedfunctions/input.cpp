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
    std::cout << "Выберите метод ввода 0 - Случайный выбор, 1 - Пользовательский ввод: ";
	std::cin >> choise;
	if (choise == 0) {
		std::cout << "Введите количество элементов - ";
		std::cin >> n;
		vvodRand();
		std::cout << std::endl;
		vivod();
		std::cout << std::endl;
		vivod();
	}
	else if (choise == 1) {
		std::cout << "Введите количество элементов - ";
		std::cin >> n;
		vvod();
		std::cout << std::endl;
		vivod();
		std::cout << std::endl;
		vivod();
	}
	else {
		std::cout << "Такого действия не существует" << std::endl;
	}
    return 0;
}