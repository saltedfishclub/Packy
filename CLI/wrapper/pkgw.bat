@echo off


@rem check environment

if not exist "%JAVA_HOME%/bin/java.exe" (
	echo INSTALL
	goto STOP
)

if not exist "./mcpkg.exe" (
	echo INSTALL MCPKG
	goto STOP
)



@rem get args

set args=

:PARAM

set str=%1
if "%str%" == "" (
	goto END
)

set args=%args% %str%
shift /0
goto PARAM

:END



./mcpkg.exe %args%

:STOP

pause
