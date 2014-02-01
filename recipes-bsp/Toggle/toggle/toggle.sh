#!/bin/sh

case $1 in 
	start)
		/usr/bin/toggle
		echo "Toggle started ok"
		exit 0
		;;
	stop)
		pkill -9 -f toggle
		echo "Execed killall toggle"
		;;
	*)
		echo "Usage: $0 {start|stop}"
esac
