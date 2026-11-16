@echo off
echo =========================================
echo        Starting CORBA Student App        
echo =========================================
echo.

if exist student.ref del student.ref

echo [1/2] Launching Server in a new window...
start "CORBA Student Server" cmd /k run-server.bat

echo [2/2] Waiting for server to initialize...
:waitloop
if exist student.ref goto ready
timeout /t 1 /nobreak >nul
goto waitloop

:ready
echo Server is ready! Running Client...
echo.
call run-client.bat
