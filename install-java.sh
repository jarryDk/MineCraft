#!/bin/bash

#
# PLEASE READ
# http://www.oracle.com/technetwork/java/javase/terms/license/index.html
#

DO_HOUSE_KEEPING=true

JAVA_RPM=jdk-8u121-linux-x64.rpm
JAVA_RPM_FOLDER=8u121-b13

JAVA_DOWNLOAD_ADDRESS=http://download.oracle.com/otn-pub/java/jdk/$JAVA_RPM_FOLDER/e9e7ea248e2c4826b92b3f075a80e441/$JAVA_RPM

function update {

  echo " ..:: START running $PWD/$0 [$(date +"%d/%m-%Y %T,%3N")] ::.. "

  echo "Afvikler downloadSoftware";
  downloadSoftware || exit 1

  echo "Afvikler installSoftware";
  installSoftware || exit 1

  echo "Afvikler houseKepping"
  houseKepping

  echo " ..:: END running $PWD/$0 [$(date +"%d/%m-%Y %T,%3N")] ::.. "

  return 0;
}


function downloadSoftware {

  echo "Downloading: $JAVA_DOWNLOAD_ADDRESS..."
  [ -e "$JAVA_RPM" ] && echo 'Java rpm already exists.'
  if [ ! -e "$JAVA_RPM" ]; then
    wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" $JAVA_DOWNLOAD_ADDRESS
    if [ $? -ne 0 ]; then
      echo "Not possible to download Java."
      exit 1
    fi
  fi

}

function installSoftware {
  rpm -ivh $JAVA_RPM

  echo "java -version"
  local VERSION=`java -version`
  echo "$VERSION"

}

function houseKepping {

  if [ "$DO_HOUSE_KEEPING" = true ] ; then
    if [ -e "$JAVA_RPM" ] ; then
      rm -f $JAVA_RPM
      echo "$JAVA_RPM slettet af HouseKepping"
    fi
  fi

}

function main {
  RETVAL=0

  if [ "$2" == "NoHousekeeping" ] ; then
    DO_HOUSE_KEEPING=false;
  fi

  case "$1" in
    update)
      update
    ;;
    *)
      echo "Usage: $0 {update|version}"
      exit 1
    ;;
  esac
  exit $RETVAL
}

main $1
