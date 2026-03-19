@echo off

set APP_NAME=MarsTravelsBooking
set VERSION=0.1.0
set FINAL_NAME=%APP_NAME%-%VERSION%

set ICON=icons\icon.ico

set INPUT=out\artifacts\grupp2_system_jar
set JAR=grupp2_system.jar
set MAIN_CLASS=com.example.grupp2_system.App.Launcher

set DEST=builds

echo Cleaning old builds...
if exist %DEST%\*.exe del /q %DEST%\*.exe

echo Creating builds directory...
if not exist %DEST% mkdir %DEST%

echo Building Windows executable...
jpackage ^
--input %INPUT% ^
--dest %DEST% ^
--name %FINAL_NAME% ^
--app-version %VERSION% ^
--main-jar %JAR% ^
--main-class %MAIN_CLASS% ^
--icon %ICON% ^
--type exe

echo.
echo Build completed. Output located in /builds
pause