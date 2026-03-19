#!/bin/bash

APP_NAME="MarsTravelsBooking"

#  Mac kräver >=1
VERSION="1.0.0"

#  Din riktiga version
DISPLAY_VERSION="0.1.0"

FINAL_NAME="$APP_NAME-$DISPLAY_VERSION"

ICON="icons/icon.icns"

JPACKAGE="/Users/gustavolin/Library/Java/JavaVirtualMachines/corretto-24.0.2/Contents/Home/bin/jpackage"
INPUT="out/artifacts/grupp2_system_jar"
JAR="grupp2_system.jar"
MAIN_CLASS="com.example.grupp2_system.App.Launcher"

DEST="builds"

echo " Tar bort gamla builds..."
rm -rf "$DEST"/*

echo " Skapar builds-mapp..."
mkdir -p "$DEST"

echo " Bygger .dmg..."
$JPACKAGE \
--input "$INPUT" \
--dest "$DEST" \
--name "$FINAL_NAME" \
--app-version "$VERSION" \
--main-jar "$JAR" \
--main-class "$MAIN_CLASS" \
--icon "$ICON" \
--type dmg

echo " KLART! (Mac builds i /builds)"