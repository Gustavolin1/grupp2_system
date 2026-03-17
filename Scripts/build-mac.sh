#!/bin/bash

APP_NAME="MarsTravelsBooking"
ICON="icons/icon.icns"

JPACKAGE="/Users/gustavolin/Library/Java/JavaVirtualMachines/corretto-24.0.2/Contents/Home/bin/jpackage"
INPUT="out/artifacts/grupp2_system_jar"
JAR="grupp2_system.jar"
MAIN_CLASS="com.example.grupp2_system.App.Launcher"

echo "🧹 Tar bort gamla builds..."
rm -rf $APP_NAME.app
rm -rf $APP_NAME.dmg

echo "📦 Bygger .app..."
$JPACKAGE \
--input $INPUT \
--name $APP_NAME \
--main-jar $JAR \
--main-class $MAIN_CLASS \
--icon $ICON \
--type app-image

echo "📦 Bygger .dmg..."
$JPACKAGE \
--input $INPUT \
--name $APP_NAME \
--main-jar $JAR \
--main-class $MAIN_CLASS \
--icon $ICON \
--type dmg

echo "🚀 KLART!"