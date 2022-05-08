#!/bin/bash

echo ----------------------------------------------------------------------------------
echo Building release of Arkusia
echo ----------------------------------------------------------------------------------

./mvnw

rm -rf ~/Anwendungen/Arkusia
cp -f target/arkusia-ui-1.0.0.jar release/

jpackage --type app-image \
         --input release \
         --name Arkusia \
         --app-version 1.0.0 \
         --copyright "(C) 2022 Timo Göckeler" \
         --description "Adventure Learning Game by Timo Göckeler" \
         --main-class de.arkusia.ui.Main \
         --main-jar arkusia-ui-1.0.0.jar \
         --icon release/arkusia.png \
         --dest ~/Anwendungen 

echo ----------------------------------------------------------------------------------
echo Arkusia is ready to be played.
echo ----------------------------------------------------------------------------------
