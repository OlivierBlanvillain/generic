# Generic

FrontEnd rewriting for values & pattern matching expressions)

```scala
()               → HNil
(e1,)            → HCons(e1, HNil)
(e1, e2)         → HCons(e1, HCons(e2, HNil))
(e1, e2, e3)     → HCons(e1, HCons(e2, HCons(e3, HNil)))
(e1, e2, e3, e4) → HCons(e1, HCons(e2, HCons(e3, HCons(e4, HNil))))
...
```

FrontEnd rewriting for types

```scala
()               → HNil
(T1,)            → T1 :: HNil
(T1, T2)         → T1 :: T2 :: HNil
(T1, T2, T3)     → T1 :: T2 :: T3 :: HNil
(T1, T2, T3, T4) → T1 :: T2 :: T3 :: T4 :: HNil
...
```

FrontEnd rewriting for assessors

```scala
t._1 → t.at(_1)
t._2 → t.at(_2)
t._3 → t.at(_3)
t._4 → t.at(_4)
```

Optimization rewriting rule for creation

```scala
HCons(e1, HNil)                                  → HList1(e1)
HCons(e1, HCons(e2, HNil))                       → HList2(e1, e2)
HCons(e1, HCons(e2, HCons(e3, HNil)))            → HList3(e1, e2, e3)
HCons(e1, HCons(e2, HCons(e3, HCons(e4, HNil)))) → HListN(Array(e1, e2, e3, e4))
```

Optimization rewriting rule for pattern matching

```scala
case HCons(e1, HNil) =>                          → case HList1(e1) =>
case HCons(e1, HCons(e2, HNil)) =>               → case HList2(e1, e2) =>
case HCons(e1, HCons(e2, HCons(e3, HNil))) =>    → case HList3(e1, e2, e3) =>
case HCons(e1, HCons(e2, HCons(e3, HCons(e4, HNil)))) => →
  case HListN(underlying) =>
    val e1 = l.underlying(0).asInstanceOf[T1]
    val e2 = l.underlying(1).asInstanceOf[T2]
    val e3 = l.underlying(2).asInstanceOf[T3]
    val e4 = l.underlying(3).asInstanceOf[T4]
```
