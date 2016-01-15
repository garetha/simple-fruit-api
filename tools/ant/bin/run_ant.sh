#!/bin/bash
ANT_HOME=$PWD/tools/ant
export ANT_HOME
echo Current directory is $PWD
chmod 777 $PWD/tools/ant/bin/ant

PATH=$PATH:$ANT_HOME/bin

export PATH

$PWD/tools/ant/bin/ant $@