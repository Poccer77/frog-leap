@echo off
cd "out\production\FrogLeap"

set /p INPUT="input: "
"C:\Program Files\Eclipse Adoptium\jdk-17.0.2.8-hotspot\bin\java.exe" Main %INPUT%

timeout 5

exit



