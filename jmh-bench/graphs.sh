#!/bin/sh
set -eux

rm -rf "jmh-bench/out/"*
rm -rf "jmh-bench/pdf2/"*

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
      set terminal pdf lw 3 dashed
      set title "$title"
      set output "jmh-bench/pdf2/$plot.pdf"

      set xrange [1:22]
      set xlabel "Tuple Size"
      set ylabel "Throughput (Mops/sec)"

      set style line 1 lc rgb '#A6CEE3' # light blue
      set style line 2 lc rgb '#1F78B4' # dark blue
      set style line 3 lc rgb '#B2DF8A' # light green
      set style line 4 lc rgb '#33A02C' # dark green
      set style line 5 lc rgb '#FB9A99' # light red
      set style line 6 lc rgb '#E31A1C' # dark red
      set style line 7 lc rgb '#FDBF6F' # light orange
      set style line 8 lc rgb '#FF7F00' # dark orange

      plot \
        "jmh-bench/out/$plot.ArrayHList.run"    using $arity:(\$$thrpt - \$$ci)/1000000:(\$$thrpt + \$$ci)/1000000 notitle with filledcurves ls 1, \
        "jmh-bench/out/$plot.ArrayHList.run"    using $arity:(\$$thrpt/1000000) title "ArrayHList"                                with lines ls 2, \
        "jmh-bench/out/$plot.LinkedHList.run"   using $arity:(\$$thrpt - \$$ci)/1000000:(\$$thrpt + \$$ci)/1000000 notitle with filledcurves ls 3, \
        "jmh-bench/out/$plot.LinkedHList.run"   using $arity:(\$$thrpt/1000000) title "LinkedHList"                               with lines ls 4, \
        "jmh-bench/out/$plot.ScalaTuple.run"    using $arity:(\$$thrpt - \$$ci)/1000000:(\$$thrpt + \$$ci)/1000000 notitle with filledcurves ls 5, \
        "jmh-bench/out/$plot.ScalaTuple.run"    using $arity:(\$$thrpt/1000000) title "ScalaTuple"                                with lines ls 6, \
        "jmh-bench/out/$plot.UnrolledHList.run" using $arity:(\$$thrpt - \$$ci)/1000000:(\$$thrpt + \$$ci)/1000000 notitle with filledcurves ls 7, \
        "jmh-bench/out/$plot.UnrolledHList.run" using $arity:(\$$thrpt/1000000) title "UnrolledHList"                             with lines ls 8
EOF
done

pdfjam jmh-bench/pdf/*.pdf --nup 2x2 --landscape --outfile jmh-bench/pdf/merged.pdf

exit 0
