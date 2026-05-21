@echo off
chcp 65001 > nul
echo ===================================================
echo [1/4] Настройка окружения GraalVM...
echo ===================================================
set "PATH=C:\Program Files\GraalVM\graalvm-jdk-17.0.12+8.1\bin;%PATH%"
cd /d C:\Users\ruslan1\Documents\GitHub\CodeSpaceAndLessons\JavaLessons\progs\src

echo.
echo [2/4] Компиляция исходного кода Java (UTF-8)...
javac -encoding utf8 game\prog.java
if %errorlevel% neq 0 (
    echo [ОШИБКА] Не удалось скомпилировать prog.java. Проверьте синтаксис в коде.
    pause
    exit /b %errorlevel%
)

echo.
echo ===================================================
echo [3/4] ЗАПУСК АГЕНТА-ШПИОНА (Сбор конфигурации JNI/AWT)
echo ===================================================
echo СЕЙЧАС ЗАПУСТИТСЯ ВАША ИГРА.
echo ВАЖНО: Обязательно дойдите до вызова кода на 18-й строке (звук/окно).
echo После этого завершите игру стандартным способом (выйдите из нее).
echo ===================================================
echo Нажмите любую клавишу, чтобы запустить игру...
pause > nul

java -agentlib:native-image-agent=config-output-dir=META-INF\native-image game.prog

echo.
echo ===================================================
echo ИГРА ЗАВЕРШЕНА. Начинается финальная сборка EXE...
echo ===================================================

if not exist game\out (
    mkdir game\out
)

echo [4/4] Компиляция Native Image (это займет пару минут)...
call native-image -H:ConfigurationFileDirectories=META-INF\native-image game.prog -o game\out\prog --no-fallback

if %errorlevel% neq 0 (
    echo [ОШИБКА] Сборка Native Image завершилась неудачей.
    pause
    exit /b %errorlevel%
)

echo.
echo ===================================================
echo [УСПЕХ] Полностью автономный EXE успешно создан!
echo Путь к файлу: game\out\prog.exe
echo ===================================================
pause