# Generic

Tuple types

```scala
()               → HNil
(T1,)            → T1 :: HNil
(T1, T2)         → T1 :: T2 :: HNil
(T1, T2, T3)     → T1 :: T2 :: T3 :: HNil
(T1, T2, T3, T4) → T1 :: T2 :: T3 :: T4 :: HNil
...
```

Tuple creation

```scala
()               → HNil
(e1,)            → HList1(e1)
(e1, e2)         → HList2(e1, e2)
(e1, e2, e3)     → HList3(e1, e2, e3)
(e1, e2, e3, e4) → HListN(Array(e1, e2, e3, e4))
...
```

Tuple pattern matching

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

Assuming Function4 is the new 22

```
Function0[A]             → Function0[A]          & GenFun[HNil, C]

Function1[A, B]          → Function1[A, B]       & GenFun[A :: HNil, C]
Function2[A, B, C]       → Function2[A, B, C]    & GenFun[A :: B :: HNil, C]
Function3[A, B, C, D]    → Function3[A, B, C, D] & GenFun[A :: B :: C :: HNil, D]
Function4[A, B, C, D, E] → GenFun[A :: B :: C :: D :: HNil, E]
```

```
Function0[A]             → Function0[A]          & GenFun[HNil, C]

Function1[A, B]          → Function1[A, B]       & GenFun[A :: HNil, C]
Function1[Tuple1[A], B]  → Function1[A, B]       & GenFun[A :: HNil, C]

Function1[(A, B), C]     → Function2[A, B, C]    & GenFun[A :: B :: HNil, C]
Function2[A, B, C]       → Function2[A, B, C]    & GenFun[A :: B :: HNil, C]

Function1[(A, B, C), D]  → Function3[A, B, C, D] & GenFun[A :: B :: C :: HNil, D]
Function3[A, B, C, D]    → Function3[A, B, C, D] & GenFun[A :: B :: C :: HNil, D]

Function4[A, B, C, D, E] → GenFun[A :: B :: C :: D :: HNil, E]
```

(a, b, c) =>


```
trait Function2[A, B, C] {
  def apply(a: A, b: B): C
}

|
v

trait GenFun[I <: HList, O] {
  def apply(i: I): O
}

trait Function2[A, B, C] extends GenFun[A :: B :: HNil, C] {
  def apply(a: A, b: B): C
  def apply(i: A :: B :: HNil): C = apply(i._1, i._2)
}
```






















