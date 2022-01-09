#!/bin/bash

RUN_UNIT="Minecraft"
LOG_FILE="$RUN_UNIT.`date "+%Y%m%d"`.log"

DATE_FOR_LOG_FILE_INPUT=$1
DATE_FOR_LOG_FILE_DEFAULT=`date "+%Y%m%d"`
DATE_FOR_LOG_FILE=${DATE_FOR_LOG_FILE_INPUT:-$DATE_FOR_LOG_FILE_DEFAULT}

LOG_FILE_OLD="$RUN_UNIT.$DATE_FOR_LOG_FILE_INPUT.log"
LOG_FILE="$RUN_UNIT.$DATE_FOR_LOG_FILE.log"

echo "LOG_FILE_OLD : $LOG_FILE_OLD"
echo "LOG_FILE : $LOG_FILE"

if  [ "X$DATE_FOR_LOG_FILE_INPUT" != "X" ]  && [[ ! -f $LOG_FILE_OLD ]]; then
  echo "Old log file not found"
  echo "Use cat_log.sh <YYYYMMDD>"
  exit 0
fi

if [[ ! -f $LOG_FILE ]]; then
  echo "Log file not found"
  exit 0
fi

tail -f $LOG_FILE  | awk  '
  /INFO/ {print "\033[32m" $0 "\033[39m"}
  /WARN/ {print "\033[31m" $0 "\033[39m"}
  /ERROR/ {print "\033[1;31m" $0 "\033[39m"}
'