@echo off

set APP_NAME=MarsTravelsBooking
set VERSION=0.1.0
set FINAL_NAME=%APP_NAME%-%VERSION%

set ICON=icons\icon.ico

set INPUT=target
set MAIN_CLASS=com.example.grupp2_system.App.Launcher

set DEST=builds

REM Build JAR using Maven wrapper
call mvnw.cmd clean package

REM Find built JAR
for %%f in (target\*.jar) do set JAR=%%~nxf

if "%JAR%"=="" (
  echo ERROR: No JAR found in target\
  exit /b 1
)

echo Using JAR: %JAR%

echo Cleaning old builds...
if exist %DEST%\*.exe del /q %DEST%\*.exe
if exist %DEST%\*.msi del /q %DEST%\*.msi

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
--type exe ^
--win-menu ^
--win-shortcut ^
--win-dir-chooser

echo Building Windows installer (MSI)...
jpackage ^
--input %INPUT% ^
--dest %DEST% ^
--name %FINAL_NAME% ^
--app-version %VERSION% ^
--main-jar %JAR% ^
--main-class %MAIN_CLASS% ^
--icon %ICON% ^
--type msi ^
--win-menu ^
--win-shortcut ^
--win-dir-chooser

echo.
echo Build completed. Output located in /builds
pause