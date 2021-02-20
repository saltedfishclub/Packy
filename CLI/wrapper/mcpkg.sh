#!/bin/bash
if [ -z $JAVA_HOME ];then
	# Download from MCPkg Server
	mkdir ~/.cache

else
	echo "JAVA_HOME = $JAVA_HOME"
fi