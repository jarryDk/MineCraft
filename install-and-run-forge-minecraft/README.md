#install-and-run-forge-minecraft

[install-and-run-forge-minecraft.sh] (https://raw.githubusercontent.com/jarryDk/MineCraft/master/install-and-run-forge-minecraft/install-and-run-forge-minecraft.sh)

Fetch

    minecraft_server.1.7.10.jar
    forge-1.7.10-10.13.2.1286-installer.jar

Create the eula.txt file

Then runs

    java -cp .:minecraft_server.1.7.10.jar:forge-1.7.10-10.13.2.1286-installer.jar cpw.mods.fml.installer.SimpleInstaller --installServer
    java -Xmx1G -Xms1G -jar forge-1.7.10-10.13.2.1286-universal.jar nogui

