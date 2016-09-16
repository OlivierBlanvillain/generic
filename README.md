# Generic

Rewriting rules for Tuple types

```scala
()               → HNil
(T1,)            → T1 :: HNil
(T1, T2)         → T1 :: T2 :: HNil
(T1, T2, T3)     → T1 :: T2 :: T3 :: HNil
(T1, T2, T3, T4) → T1 :: T2 :: T3 :: T4 :: HNil
...
```

Rewriting rules for Tuple creation

```scala
()               → HNil
(e1,)            → HList1(e1)
(e1, e2)         → HList2(e1, e2)
(e1, e2, e3)     → HList3(e1, e2, e3)
(e1, e2, e3, e4) → HListN(Array(e1, e2, e3, e4))
...
```

Rewriting rules for Tuple pattern matching

```scala
case ()               → case HNil =>
case (e1,)            → case HList1(e1) =>
case (e1, e2)         → case HList2(e1, e2) =>
case (e1, e2, e3)     → case HList3(e1, e2, e3) =>
case (e1, e2, e3, e4) →
  // Something like that...
  case HListN(underlying) =>
    val e1 = l.underlying(0).asInstanceOf[T1]
    val e2 = l.underlying(1).asInstanceOf[T2]
    val e3 = l.underlying(2).asInstanceOf[T3]
    val e4 = l.underlying(3).asInstanceOf[T4]
...
```
