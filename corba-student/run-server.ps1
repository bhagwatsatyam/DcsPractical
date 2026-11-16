$m2 = "$env:USERPROFILE\.m2\repository"
$jars = Get-ChildItem -Path "$m2\org\glassfish\corba","$m2\org\glassfish\pfl","$m2\org\glassfish\gmbal","$m2\org\glassfish\external" -Recurse -Filter "*.jar" | ForEach-Object { $_.FullName }
$cp = ($jars -join ";") + ";target\classes"

$javaArgs = @(
    "-cp", $cp,
    "--add-opens", "java.base/java.lang=ALL-UNNAMED",
    "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED",
    "--add-opens", "java.base/java.lang.invoke=ALL-UNNAMED",
    "--add-opens", "java.base/java.util=ALL-UNNAMED",
    "--add-opens", "java.base/java.io=ALL-UNNAMED",
    "--add-opens", "java.base/java.net=ALL-UNNAMED",
    "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED",
    "StudentServer"
)

& java $javaArgs
