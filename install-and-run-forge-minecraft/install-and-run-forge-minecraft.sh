#!/bin/bash
#uri :https://raw.githubusercontent.com/jarryDk/MineCraft/master/install-and-run-forge-minecraft/install-and-run-forge-minecraft.sh
#title :install-and-run-forge-minecraft.sh
#description :Install and run forge minecraft version 1.7.10
#author :Michael Bornholdt Nielsen
#date :20150119
#usage :/bin/bash install-and-run-forge-minecraft.sh

MINECRAFT_VERSION=1.7.10
MINECRAFT_JAR=minecraft_server.$MINECRAFT_VERSION.jar
MINECRAFT_JAR_DOWNLOAD=https://s3.amazonaws.com/Minecraft.Download/versions/$MINECRAFT_VERSION/$MINECRAFT_JAR

FORGE_VERSION=1.7.10-10.13.2.1286
FORGE_INSTALLER_JAR=forge-$FORGE_VERSION-installer.jar
FORGE_UNIVERSON_JAR=forge-$FORGE_VERSION-universal.jar
FORGE_INSTALLER_JAR_DOWNLOAD=http://files.minecraftforge.net/maven/net/minecraftforge/forge/$FORGE_VERSION/$FORGE_INSTALLER_JAR

if [ ! -e "eula.txt" ]; then
cat > eula.txt << "EOF"
eula=true
EOF
fi

if [ ! -e "$FORGE_UNIVERSON_JAR" ]; then

  if [ ! -e "$FORGE_INSTALLER_JAR" ]; then
	wget $MINECRAFT_JAR_DOWNLOAD
  fi

  if [ ! -e "$FORGE_INSTALLER_JAR" ]; then
	wget $FORGE_INSTALLER_JAR_DOWNLOAD
  fi

  java -cp .:minecraft_server.1.7.10.jar:forge-1.7.10-10.13.2.1286-installer.jar cpw.mods.fml.installer.SimpleInstaller --installServer

fi


java -Xmx1G -Xms1G -jar forge-1.7.10-10.13.2.1286-universal.jar nogui

