@echo off
javac -d class src/bropals/tag16/*.java src/bropals/tag16/world/*.java src/bropals/tag16/state/*.java src/bropals/tag16/entity/*.java src/bropals/tag16/io/*.java src/bropals/tag16/draw/*.java
PAUSE
jar cfe ../Game.jar bropals.tag16.GameMain -C class .
jar cfe ../LevelEditor.jar bropals.tag16.LevelEditorMain -C class .
PAUSE