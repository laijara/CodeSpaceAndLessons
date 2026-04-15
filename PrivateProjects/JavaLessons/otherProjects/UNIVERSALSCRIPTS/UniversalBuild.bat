@echo off
chcp 65001 > nul
setlocal EnableDelayedExpansion

:: ======================================================================
:: УНИВЕРСАЛЬНЫЙ СКРИПТ СБОРКИ JAVA ПРОЕКТОВ (JPackage)
:: Путь к Java (меняйте только если установите новую версию Java на ПК)
set JAVA_BIN=C:\Program Files\Java\jdk-21\bin
:: ======================================================================

:: Определяем корневую папку проекта
cd /d "%~dp0"
:: Если скрипт запустили из папки scripts, выходим на уровень выше (в корень)
for %%I in ("%CD%") do if /I "%%~nxI"=="scripts" cd ..

:: Файл, где скрипт будет хранить память о вашем проекте
set CONFIG_FILE=build_config.txt

:: === ШАГ 0: ПЕРВИЧНАЯ НАСТРОЙКА (ТОЛЬКО ОДИН РАЗ) ===
if not exist "%CONFIG_FILE%" (
    echo ==========================================================
    echo   ПЕРВЫЙ ЗАПУСК: Настройка нового проекта
    echo ==========================================================

    :: Получаем имя текущей папки
    for %%I in ("%CD%") do set "FOLDER_NAME=%%~nxI"

    :: Спрашиваем имя приложения
    set /p APP_NAME="1. Название программы (Enter, чтобы назвать [!FOLDER_NAME!]): "
    if "!APP_NAME!"=="" set APP_NAME=!FOLDER_NAME!

    :: Спрашиваем главный класс
    set /p MAIN_CLASS="2. Главный класс (Enter, если это [Main]): "
    if "!MAIN_CLASS!"=="" set MAIN_CLASS=Main

    :: Записываем настройки в файл
    echo !APP_NAME!> "%CONFIG_FILE%"
    echo !MAIN_CLASS!>> "%CONFIG_FILE%"
    echo.
    echo Настройки сохранены в %CONFIG_FILE%! Начинаем сборку...
    echo ==========================================================
) else (
    :: Если файл есть, просто молча читаем из него настройки
    <"%CONFIG_FILE%" (
        set /p APP_NAME=
        set /p MAIN_CLASS=
    )
)

echo.
echo 1. Очистка старых сборок...
if exist out\classes rmdir /S /Q out\classes
if exist out\jar rmdir /S /Q out\jar
if exist out\release\!APP_NAME! rmdir /S /Q "out\release\!APP_NAME!"

echo 2. Создание структуры папок...
if not exist out\classes mkdir out\classes
if not exist out\jar mkdir out\jar
if not exist out\release mkdir out\release

echo 3. Компиляция исходного кода...
"%JAVA_BIN%\javac.exe" -encoding UTF-8 -sourcepath src -d out\classes src\!MAIN_CLASS!.java
if errorlevel 1 (
    echo.
    echo [ОШИБКА] Не удалось скомпилировать код! Проверьте синтаксис.
    pause
    exit /b
)

echo 4. Сборка JAR архива...
"%JAVA_BIN%\jar.exe" cfe out\jar\!APP_NAME!.jar !MAIN_CLASS! -C out\classes .

echo 5. Сборка автономного .exe через jpackage...
"%JAVA_BIN%\jpackage.exe" --type app-image --name "!APP_NAME!" --dest out\release --input out\jar --main-jar "!APP_NAME!.jar" --main-class !MAIN_CLASS! --win-console --add-modules java.base,java.desktop --java-options "-Xshare:off"

echo.
echo ======================================================================
echo ГОТОВО! Ваша программа собрана и ждет вас здесь:
echo out\release\!APP_NAME!
echo ======================================================================
pause