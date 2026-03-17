@echo off

set APP_NAME=MarsTravelsBooking
set ICON=..\icons\icon.ico

set INPUT=..\out\artifacts\grupp2_system_jar
set JAR=grupp2_system.jar
set MAIN_CLASS=com.example.grupp2_system.App.Launcher

echo Rensar gamla builds...
if exist ..\%APP_NAME%.exe rmdir /s /q ..\%APP_NAME%.exe

echo Bygger EXE...
jpackage ^
--input %INPUT% ^
--name %APP_NAME% ^
--main-jar %JAR% ^
--main-class %MAIN_CLASS% ^
--icon %ICON% ^
--type exe

echo.
echo KLART! EXE skapad
pause