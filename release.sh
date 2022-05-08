#!/bin/bash

echo ----------------------------------------------------------------------------------
echo Building release of Arkusia
echo ----------------------------------------------------------------------------------

./mvnw
rm -rf Arkusia
jpackage --type app-image -i target -n Arkusia --main-class de.arkusia.ui.Main --main-jar arkusia-ui-1.0.0.jar

echo ----------------------------------------------------------------------------------
echo Arkusia is ready to be played.
echo ----------------------------------------------------------------------------------
