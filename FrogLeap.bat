@echo off
cd "src\"

set /p INPUT="input: "
java Main %INPUT%

timeout 5

exit



