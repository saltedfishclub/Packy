#!/bin/bash
if [ -z $JAVA_HOME ];then
	# Download from MCPkg Server
	if [ -d "~/.cache" ];then
	mkdir ~/.cache
	fi
  if [ ! -d "/bin/mcpkg" ];then
    echo "Downloading MCPkg from server.."
    sudo curl -O /bin/mcpkg https://pkg.sfclub.cc/static/bin/mcpkg_linux_amd64
    sudo chmod +x /bin/mcpkg
  fi
else
	echo "You should install java first."
	echo "Attempting to install java automatically... (Centos OR Debian/Ubuntu ONLY)"
	source /etc/os-release
  case $ID_LIKE in
  "debian")
  sudo apt install openjdk-8-jdk -y
  ;;
  "rhel fedora")
  sudo yum -y install java-1.8.0-openjdk.x86_64
  ;;
esac
fi

mcpkg $*