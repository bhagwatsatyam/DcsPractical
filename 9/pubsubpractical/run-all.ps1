Write-Host "=========================================" -ForegroundColor Cyan
Write-Host "  Starting Publish-Subscribe Demo (Prac 9)" -ForegroundColor Cyan
Write-Host "=========================================" -ForegroundColor Cyan
Write-Host ""

$dir = $PSScriptRoot

# 1. Start Broker
Write-Host "[1/3] Starting Message Broker in separate window..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$dir'; mvn exec:java '-Dexec.mainClass=com.example.MessageBroker'"

Start-Sleep -Seconds 4

# 2. Start Subscriber
Write-Host "[2/3] Starting Subscriber in separate window..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$dir'; mvn exec:java '-Dexec.mainClass=com.example.Subscriber'"

Start-Sleep -Seconds 2

# 3. Start Publisher in current window
Write-Host "[3/3] Starting Publisher in this window..." -ForegroundColor Green
Write-Host ""
Set-Location $dir
mvn exec:java "-Dexec.mainClass=com.example.Publisher"
