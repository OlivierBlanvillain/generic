#!/bin/sh
set -eux

sbt ';gen/run ;scalameter-bench/test'        |\
sed "s,\x1B\[[0-9;]*[a-zA-Z],,g"  |\
tee scalameter-bench/sbt.out

rm -f scalameter-bench/out/*
rm -f scalameter-bench/pdf/*

cat scalameter-bench/sbt.out                 |\
grep -Po "(?<=\[info\] ).+(?= #)" |\
sort | uniq                       |\
while read prefix; do
  cat scalameter-bench/sbt.out               |\
  grep -Po "(?<=$prefix #).*"      \
  > "scalameter-bench/out/$prefix.run"
done

for plot in       \
  AccessAllBench  \
  AccessLastBench \
  CreationBench   \
  TailBench; do
    gnuplot <<- EOF
      set xrange [1:22]
      set xlabel "Size"
      set ylabel "Duration (seconds)"
      set title "$plot"
      set terminal pdf
      set output "scalameter-bench/pdf/$plot.pdf"
      plot \
        "scalameter-bench/out/$plot.ArrayHList.run"    title "ArrayHList"    with lines, \
        "scalameter-bench/out/$plot.LinkedHList.run"   title "LinkedHList"   with lines, \
        "scalameter-bench/out/$plot.scalaTuple.run"    title "scala.Tuple"   with lines, \
        "scalameter-bench/out/$plot.UnrolledHList.run" title "UnrolledHList" with lines
EOF
done

pdfjam scalameter-bench/pdf/*.pdf --nup 2x2 --landscape --outfile scalameter-bench/pdf/merged.pdf

exit 0
