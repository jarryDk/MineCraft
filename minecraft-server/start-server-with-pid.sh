#!/bin/bash

set -uo pipefail

cd ${0%/*}

# export JAVA_HOME="/opt/java/jdk-17.0.1+12"
# export JAVA_HOME="/opt/java/jdk-19.0.1+10"
export JAVA_HOME="/opt/java/jdk-21+35"

MINECRAFT_VERSION=1.20.2

JAVA_XMX=2048M
JAVA_XMS=2048M

PIDFILE=./minecraft_server.pid
SESSION_LOCK=./world/session.lock

# DO_PRINT_DEBUG_MSG=True
HOST_NAME=$(hostname)
RUN_UNIT="Minecraft"

function doLog(){
    type_of_msg=$(echo $*|cut -d" " -f1)
    msg=$(echo "$*"|cut -d" " -f2-)
    [[ $type_of_msg == DEBUG ]] && [[ $DO_PRINT_DEBUG_MSG -ne 1 ]] && return
    [[ $type_of_msg == INFO ]] && type_of_msg="INFO " # one space for aligning
    [[ $type_of_msg == WARN ]] && type_of_msg="WARN " # as well

    fullMsg="`date "+%Y-%m-%dT%H:%M:%S%z"` [$type_of_msg] -- [$RUN_UNIT][@$HOST_NAME][$$] -- ""$msg"

    # Print to the terminal if we have one
    test -t 1 && echo $fullMsg 

    # Append to log_file
    log_file="$RUN_UNIT.`date "+%Y%m%d"`.log"
    echo $fullMsg >> $log_file
}
#eof function doLog

function restart() {
  doLog "WARN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
  doLog "WARN ~ Getting ready to restart Minecraft version : $MINECRAFT_VERSION"
  doLog "WARN ~ Minecraft crached at $(date +'%Y-%m-%d %H:%M:%S')"
  if [[ -f $PIDFILE ]]; then
    doLog "WARN ~ - Remove the file $PIDFILE as part of restart"
    rm -fv $PIDFILE
  fi
  if [[ -f $SESSION_LOCK ]]; then
    doLog "ERROR ~ - Remove the file $SESSION_LOCK as part of restart"
    rm -fv $SESSION_LOCK
  fi
  PID_OF_PORT_IN_USE=$(lsof -i:25565 | grep LISTEN | awk '{print $2}')
  if [ "X" != "X$PID_OF_PORT_IN_USE" ]; then
    doLog "ERROR ~ - Kill existing Minecraft server running on port 25565 as part of restart"
    kill -9 $PID_OF_PORT_IN_USE
  fi
  doLog "WARN ~ Ready to restart Minecraft version : $MINECRAFT_VERSION"
  doLog "WARN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
  exec "./start-server-with-pid.sh"
}
#eof function restart

doLog "INFO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
doLog "INFO ~ Getting ready to start Minecraft version : $MINECRAFT_VERSION"
doLog "INFO ~ Minecraft starting at $(date +'%Y-%m-%d %H:%M:%S')"
doLog "INFO ~ JAVA_HOME : $JAVA_HOME"
doLog "INFO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"

if [[ ! -d $JAVA_HOME ]]; then
    doLog "ERROR JAVA_HOME ($JAVA_HOME) is NOT a directory."
    exit 0
fi

if [[ ! -f "server_$MINECRAFT_VERSION.jar" ]]; then
    doLog "ERROR server_$MINECRAFT_VERSION.jar is not a file."
    exit 0
fi

doLog "INFO Looking for the PID file : $PIDFILE"

#  PID file
if [[ -f $PIDFILE ]]; then
  pid=$(cat $PIDFILE)
  ps -p $pid > /dev/null 2>&1
  if [ $? -eq 0 ]; then
    doLog "WARN Minecraft is already running" 
    exit 0
  else
    # process not found, overwrite
    doLog "WARN Process not found. Create a new PID file"
    echo $$ > $PIDFILE
  fi
else
  # wasn't running, write pid
  doLog "INFO Wasn't running. Create a new PID file"
  echo $$ > $PIDFILE;
fi

# after PID file has been set
trap restart EXIT

$JAVA_HOME/bin/java -Xmx$JAVA_XMX -Xms$JAVA_XMS -jar server_$MINECRAFT_VERSION.jar nogui
