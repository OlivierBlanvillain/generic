package generic

trait LegacySyntax {
  object legacy {
    implicit class _1[T1](l: T1 :: HNil) {
      def _1: T1 = l.underlying(0).asInstanceOf[T1]
    }

    implicit class _2[T1, T2](l: T1 :: T2 :: HNil) {
      def _1: T1 = l.underlying(0).asInstanceOf[T1]
      def _2: T2 = l.underlying(1).asInstanceOf[T2]
    }

    implicit class _3[T1, T2, T3](l: T1 :: T2 :: T3 :: HNil) {
      def _1: T1 = l.underlying(0).asInstanceOf[T1]
      def _2: T2 = l.underlying(1).asInstanceOf[T2]
      def _3: T3 = l.underlying(2).asInstanceOf[T3]
    }

    implicit class _4[T1, T2, T3, T4](l: T1 :: T2 :: T3 :: T4 :: HNil) {
      def _1: T1 = l.underlying(0).asInstanceOf[T1]
      def _2: T2 = l.underlying(1).asInstanceOf[T2]
      def _3: T3 = l.underlying(2).asInstanceOf[T3]
      def _4: T4 = l.underlying(3).asInstanceOf[T4]
    }
    // ...

    type Tuple1[T1] = T1 :: HNil
    type Tuple2[T1, T2] = T1 :: T2 :: HNil
    type Tuple3[T1, T2, T3] = T1 :: T2 :: T3 :: HNil
    type Tuple4[T1, T2, T3, T4] = T1 :: T2 :: T3 :: T4 :: HNil
    // ...

    def Tuple1[T1](e1: T1): T1 :: HNil = HList1(e1)
    def Tuple2[T1, T2](e1: T1, e2: T2): T1 :: T2 :: HNil = HList2(e1, e2)
    def Tuple3[T1, T2, T3](e1: T1, e2: T2, e3: T3): T1 :: T2 :: T3 :: HNil = HList3(e1, e2, e3)
    def Tuple4[T1, T2, T3, T4](e1: T1, e2: T2, e3: T3, e4: T4): T1 :: T2 :: T3 :: T4 :: HNil =
      HListN(Array(e1, e2: T2, e3, e4))
    // ...
  }
}
