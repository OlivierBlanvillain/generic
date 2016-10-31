#!/bin/sh
set -eux

rm -rf "jmh-bench/out/"*
rm -rf "jmh-bench/pdf/"*

cat "jmh-bench/sbt.out"             |\
sed "s,\x1B\[[0-9;]*[a-zA-Z],,g"    |\
grep -A1000 -e "\[info\] Benchmark" |\
tail -n +1 | head -n -1             |\
tee "jmh-bench/out/results.run"

for plot in       \
  ScanBench       \
  AccessLastBench \
  CreationBench   \
  TailBench; do
    for type in   \
      ArrayHList  \
      LinkedHList \
      ScalaTuple  \
      UnrolledHList; do
        cat "jmh-bench/out/results.run" |\
        grep "$plot" | grep "$type"     |\
        grep -o '[0-9].*' | sort -V     |\
        tr -s " "                       |\
        tee "jmh-bench/out/$plot.$type.run"
    done

    arity=1
    thrpt=4
    ci=6
    title=$(echo $plot | rev | cut -c6- | rev)
    gnuplot <<- EOF
      set xrange [1:22]
      set xlabel "Size"
      set ylabel "Throughput (million op/sec)"
      set title "$title"
      set terminal pdf
      set output "jmh-bench/pdf/$plot.pdf"
      plot \
        "jmh-bench/out/$plot.ArrayHList.run"    using $arity:(\$$thrpt/1000000) title "ArrayHList"    with lines, \
        "jmh-bench/out/$plot.LinkedHList.run"   using $arity:(\$$thrpt/1000000) title "LinkedHList"   with lines, \
        "jmh-bench/out/$plot.ScalaTuple.run"    using $arity:(\$$thrpt/1000000) title "ScalaTuple"    with lines, \
        "jmh-bench/out/$plot.UnrolledHList.run" using $arity:(\$$thrpt/1000000) title "UnrolledHList" with lines
EOF
# "jmh-bench/out/$plot.ArrayHList.run"    using $arity:(\$$thrpt-\$$ci):(\$$thrpt+\$$ci) title "ArrayHList"    with filledcurves, \
done

pdfjam jmh-bench/pdf/*.pdf --nup 2x2 --landscape --outfile jmh-bench/pdf/merged.pdf

exit 0
