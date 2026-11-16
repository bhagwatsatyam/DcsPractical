Write-Host "=========================================" -ForegroundColor Cyan
Write-Host "       Starting CORBA Student App        " -ForegroundColor Cyan
Write-Host "=========================================" -ForegroundColor Cyan
Write-Host ""

# Clean up any old reference file
if (Test-Path "student.ref") {
    Remove-Item "student.ref" -Force
}

# Start Server in a separate window
Write-Host "[1/2] Launching Server in a new window..." -ForegroundColor Yellow
$scriptDir = $PSScriptRoot
if (-not $scriptDir) { $scriptDir = (Get-Location).Path }
Start-Process powershell -ArgumentList "-NoExit", "-File", "$scriptDir\run-server.ps1"

# Wait for student.ref to be generated
Write-Host "[2/2] Waiting for server to initialize..." -ForegroundColor Yellow
$timeout = 15
$count = 0
while (-not (Test-Path "student.ref") -and $count -lt $timeout) {
    Start-Sleep -Seconds 1
    $count++
}

if (Test-Path "student.ref") {
    Write-Host "Server is ready! Running Client..." -ForegroundColor Green
    Write-Host ""
    & "$scriptDir\run-client.ps1"
} else {
    Write-Host "Server did not generate 'student.ref' within $timeout seconds." -ForegroundColor Red
    Write-Host "Please check the Server window for any error messages." -ForegroundColor Red
}
