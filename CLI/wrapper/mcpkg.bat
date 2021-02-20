@echo off


@rem check environment

if not exist "%JAVA_HOME%\bin\java.exe" (
	echo 请先安装 Java
	goto STOP
)

if not exist "%AllUsersProfile%\mcpkg.exe" (
	echo MCPkg missing! We're downloading it.
	curl -O "%AllUsersProfile%\mcpkg.exe" https://pkg.sfclub.cc/static/bin/mcpkg_windows_amd64
	echo retry me!
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
