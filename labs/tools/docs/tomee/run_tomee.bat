@echo off
setlocal

rem -------------------------------------------------------------------------------------------------
rem Im folgenden Parameterblock bitte konkrete Werte eintragen

rem Server-Installationsverzeichnis
set CATALINA_HOME=@tomee_home@

rem Basis-Verzeichnis für konkrete Server-Variante
set CATALINA_BASE=%CATALINA_HOME%\base\seminar

set TITLE=TomEE

rem -------------------------------------------------------------------------------------------------

call %CATALINA_HOME%\bin\startup.bat
endlocal

