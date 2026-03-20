#!/bin/bash
set -e

APP_NAME="MarsTravelsBooking"
VERSION="1.0.0"
DISPLAY_VERSION="0.1.0"

FINAL_NAME="$APP_NAME-$DISPLAY_VERSION"
ICON="icons/icon.icns"
if [ ! -f "$ICON" ]; then
  echo "WARNING: Icon not found at $ICON, proceeding without custom icon..."
  ICON=""
fi

JPACKAGE="jpackage"
INPUT="target"
MAIN_CLASS="com.example.grupp2_system.App.Launcher"
DEST="builds"

echo "Removing old builds..."
rm -rf "$DEST"
mkdir -p "$DEST"
xattr -cr .

echo "Building project with Maven..."
mvn clean package

echo "Listing target directory..."
ls -l target

JAR=$(ls target/*.jar | grep -v original | head -n 1)
if [ -z "$JAR" ]; then
  echo "ERROR: No JAR found in $INPUT/"
  exit 1
fi
echo "Using JAR: $JAR"
if [ ! -f "$JAR" ]; then
  echo "ERROR: Selected JAR does not exist"
  exit 1
fi

#  STEG 1: Bygg app-image (stabilt)
echo "Building .app..."
$JPACKAGE --input "$INPUT" --dest "$DEST" --name "$FINAL_NAME" --app-version "$VERSION" --main-jar "$(basename "$JAR")" --main-class "$MAIN_CLASS" ${ICON:+--icon "$ICON"} --mac-package-name "MarsTravel" --mac-package-identifier "com.marstravels.booking" --type app-image --verbose

#  STEG 2: Bygg dmg från app-image
echo "Building .dmg..."
APP_IMAGE="$DEST/$FINAL_NAME.app"
if [ ! -d "$APP_IMAGE" ]; then
  echo "ERROR: App image not found at $APP_IMAGE"
  exit 1
fi

$JPACKAGE --dest "$DEST" \
  --name "$FINAL_NAME" \
  --app-version "$VERSION" \
  --type dmg \
  ${ICON:+--icon "$ICON"} \
  --app-image "$APP_IMAGE"

#  STEG 3: FIXA macOS metadata (VIKTIGT)
echo "Fixing macOS metadata..."
xattr -cr "$DEST"

echo "DONE! Build contents:"
ls -l "$DEST"