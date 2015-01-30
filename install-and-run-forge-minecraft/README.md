#install-and-run-forge-minecraft

[install-and-run-forge-minecraft-1.8.sh] (https://raw.githubusercontent.com/jarryDk/MineCraft/master/install-and-run-forge-minecraft/install-and-run-forge-minecraft-1.8.sh)

[install-and-run-forge-minecraft-1.7.10.sh] (https://raw.githubusercontent.com/jarryDk/MineCraft/master/install-and-run-forge-minecraft/install-and-run-forge-minecraft-1.7.10.sh)

Fetch

    minecraft_server.<MINECRAFT_VERSION>.jar
    forge-<FORGE_MINECRAFT_VERSION>-installer.jar

Create the eula.txt file

Then runs

    java -cp .:minecraft_server.<MINECRAFT_VERSION>.jar:forge-<FORGE_MINECRAFT_VERSION>-installer.jar cpw.mods.fml.installer.SimpleInstaller --installServer
    java -Xmx1G -Xms1G -jar forge-<FORGE_MINECRAFT_VERSION>-universal.jar nogui

