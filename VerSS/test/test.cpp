#include <iostream>
using namespace std;

void Classed3(){
    cout << "Задание 8" << endl;
    class bankAccount {
        public:
        string name;
        int age;
        void getBalance() {
            char Answer;
            cout << "Вывести баланс? Y-да N-нет: ";
            cin >> Answer;
            if (Answer == 'Y') cout << balance;
        }
        private:
        int balance = 1;
    };
    bankAccount bank;
    bank.getBalance();
    cout << endl;
}

void Classed2(){
    cout << endl << "Задание 7" << endl;
    class Treug {
        public:
        int a;
        int b;
    };
    class Crug: public Treug{
        public:
        int c;
    };

    Crug crug;
    crug.a = 10;
    crug.b = 20;
    crug.c = 30;
    cout << crug.a << crug.b << crug.c << endl;
    cout << endl; 
}

void Classed(){
    cout << endl << "Задание 5" << endl;
    class Student {
        public: 
        string name;
        int age;
        void Info(){
            cout << "Имя - " << name << endl;
            cout << "Возраст - " << age << endl; 
        }
    };

    Student student;
    student.name = "Абоба";
    student.age = 35;
    student.Info();
    cout << endl;
}
   

void factorial(){
    cout << endl << "Задание 2" << endl;
    int a, fact;
    fact = 1;
    cout << "Введите число - ";
    cin >> a;
    for(int i = 1; i < a; i++){
        fact = fact * i;
    }
    cout << "Факториал числа " << a << " - " << fact << endl;
    cout << endl;
}

void helloWorld(){
    cout << endl << "Задание 1" << endl;
    cout << "Hello world" << endl;
    cout << endl;
}

int main(){
    setlocale(LC_ALL, "ru");
    helloWorld();
    factorial();
    Classed();
    Classed2();
    Classed3();
    return 0;
}