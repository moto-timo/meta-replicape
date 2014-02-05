#!/bin/sh

case $1 in
        start)
              	/usr/bin/octoprint --iknowwhatimdoing --daemon start --config /etc/octoprint/config.yaml
                echo "Octoprint started"
                exit 0
                ;;
        stop)
             	/usr/bin/octoprint --daemon stop
                echo "Octoprint stopped"
                ;;
        *)
          	echo "Usage: $0 {start|stop}"
esac

