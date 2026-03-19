#!/bin/bash
set -e

APP_NAME="MarsTravelsBooking"
VERSION="1.0.0"
DISPLAY_VERSION="0.1.0"

FINAL_NAME="$APP_NAME-$DISPLAY_VERSION"
ICON="icons/icon.icns"

JPACKAGE="jpackage"
INPUT="target"
MAIN_CLASS="com.example.grupp2_system.App.Launcher"
DEST="builds"

echo "Removing old builds..."
rm -rf "$DEST"
mkdir -p "$DEST"
xattr -cr .

echo "Building JAR..."
chmod +x mvnw
./mvnw clean package

JAR=$(find target -name "*.jar" | head -n 1)

#  STEG 1: Bygg app-image (stabilt)
echo "Building .app..."
$JPACKAGE \
--input "$INPUT" \
--dest "$DEST" \
--name "$FINAL_NAME" \
--app-version "$VERSION" \
--main-jar "$(basename "$JAR")" \
--main-class "$MAIN_CLASS" \
--icon "$ICON" \
--mac-package-name "MarsTravel" \
--mac-package-identifier "com.marstravels.booking" \
--type app-image

#  STEG 2: Bygg dmg från app-image
echo "Building .dmg..."
$JPACKAGE \
--input "$DEST" \
--dest "$DEST" \
--name "$FINAL_NAME" \
--app-version "$VERSION" \
--type dmg \
--icon "$ICON"

#  STEG 3: FIXA macOS metadata (VIKTIGT)
echo "Fixing macOS metadata..."
xattr -cr "$DEST"

echo "DONE! Check /builds"