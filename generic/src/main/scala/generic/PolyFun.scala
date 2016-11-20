package generic

trait ImplicitFunction1[A, B] {
  def apply(implicit a: A): B
}

object Predef {
  def explicitly[I, O](f: ImplicitFunction1[I, O], a: I): O = {
    implicit val ia: I = a
    f.apply
  }
}

trait UTypeApp1[U, F[_ <: U]] {
  def apply[T <: U]: F[T]
}

trait TypeApp1[F[_]] {
  def apply[T]: F[T]
}

trait TypeApp2[F[_, _]] {
  def apply[T, U]: F[T, U]
}

trait KindApp1[F[_[_]]] {
  def apply[G[_]]: F[G]
}

trait KindApp2[F[_[_], _[_]]] {
  def apply[G[_], H[_]]: F[G, H]
}

// trait Poly1Function1[A[_], B[_]] {
//   def apply[T](t: A[T]): B[T]
// }


object Demo {
  val headOption = // : TypeApp1[[A] => List[A] => Option[A]] = _.headOption
    new TypeApp1[[A] => List[A] => Option[A]] {
      def apply[T]: List[T] => Option[T] = _.headOption
    }

  val head = // : TypeApp1[[A] => List[A] => A] = _.head
    new TypeApp1[[A] => List[A] => A] {
      def apply[T]: List[T] => T = _.head
    }

  val pure = // : TypeApp1[[A] => A => List[A]] = List apply _
    new TypeApp1[[A] => A => List[A]] {
      def apply[T]: T => List[T] = List apply _
    }

  def f[A](n: A)(l: Int, u: Int)(implicit e: Ordering[A]): String = null

  val l: TypeApp1[[A] => Function1[A, Function2[Int, Int, ImplicitFunction1[Ordering[A], String]]]] = null

  // val l: TypeApp1[[A] => A => (Int, Int) => implicit Ordering[A] => String] = f _

  def mkCollection[C[_]](collection: TypeApp1[[A] => Seq[A] => C[A]]): TypeApp1[[A] => A => C[A]] =
    new TypeApp1[[A] => A => C[A]] {
      def apply[A]: A => C[A] = a => collection[A](Seq(a))
    }

  val mkCol: KindApp1[[C[_]] => TypeApp1[[A] => Seq[A] => C[A]]] = null

  def mkCollection2[C[_, _]](collection: TypeApp2[[A, B] => (A, B) => C[A, B]]) = null

  // val mkSet = mkCollection[Set](null)

  // mkSet[Int](1): Set[Int]

  // mkCollection(Set.apply _)

  // def mkCollection[A, C[_]](collection: TypeApp1[A => C[A]], value: A): C[A] = collection[A]

}

trait TATTT[A, B]

object L {
  // type Size = UTypeApp1[F = [L <: HList] => L => Nat]
  def f[A, B]: A = null.asInstanceOf[A]

  f[A = Int, B = String]
  // val a = new TATTT[A = Int, B = String] {}
}


