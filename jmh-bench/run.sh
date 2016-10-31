#!/bin/sh
set -eux

cd /home/olivier/workspace/generic/

sbt 'jmh-bench/jmh:run' > jmh-bench/sbt.out
