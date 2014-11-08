@echo off
javac -d class src/bropals/tag16/*.java
PAUSE
jar cfe ../Game.jar bropals.tag16.GameMain -C class .
jar cfe ../LevelEditor.jar bropals.tag16.LevelEditorMain -C class .
PAUSE