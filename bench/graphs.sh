#!/bin/sh
set -eux

sbt ';gen/run ;bench/test'        |\
sed "s,\x1B\[[0-9;]*[a-zA-Z],,g"  |\
tee bench/sbt.out

rm -f bench/out/*
rm -f bench/pdf/*

cat bench/sbt.out                 |\
grep -Po "(?<=\[info\] ).+(?= #)" |\
sort | uniq                       |\
while read prefix; do
  cat bench/sbt.out               |\
  grep -Po "(?<=$prefix #).*"      \
  > "bench/out/$prefix.run"
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
      set output "bench/pdf/$plot.pdf"
      plot \
        "bench/out/$plot.ArrayHList.run"    title "ArrayHList"    with lines, \
        "bench/out/$plot.LinkedHList.run"   title "LinkedHList"   with lines, \
        "bench/out/$plot.scalaTuple.run"    title "scala.Tuple"   with lines, \
        "bench/out/$plot.UnrolledHList.run" title "UnrolledHList" with lines
EOF
done

pdfjam bench/pdf/*.pdf --nup 2x2 --landscape --outfile bench/pdf/merged.pdf

exit 0
