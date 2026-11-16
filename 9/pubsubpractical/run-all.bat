@echo off
echo =========================================
echo   Starting Publish-Subscribe Demo (Prac 9)
echo =========================================
echo.

cd /d "%~dp0"

echo [1/3] Starting Message Broker in separate window...
start "ActiveMQ Broker" cmd /k run-broker.bat

timeout /t 4 /nobreak >nul

echo [2/3] Starting Subscriber in separate window...
start "Message Subscriber" cmd /k run-subscriber.bat

timeout /t 2 /nobreak >nul

echo [3/3] Starting Publisher in this window...
echo.
call run-publisher.bat
