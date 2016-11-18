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

trait TA[F[_]] {
  def apply[T]: F[T]
}


trait Poly1Function1[A[_], B[_]] {
  def apply[T](t: A[T]): B[T]
}

object Demo {
  val headOption = // : TA[[A] => List[A] => Option[A]] = _.headOption
    new TA[[A] => List[A] => Option[A]] {
      def apply[T]: List[T] => Option[T] = _.headOption
    }

  val head = // : TA[[A] => List[A] => A] = _.head
    new TA[[A] => List[A] => A] {
      def apply[T]: List[T] => T = _.head
    }

  val pure = // : TA[[A] => A => List[A]] = List apply _
    new TA[[A] => A => List[A]] {
      def apply[T]: T => List[T] = List apply _
    }

  def f[A](n: A)(l: Int, u: Int)(implicit e: Ordering[A]): String = null

  val l: TA[[A] => Function1[A, Function2[Int, Int, ImplicitFunction1[Ordering[A], String]]]] = null

  // val l: TA[[A] => A => (Int, Int) => implicit Ordering[A] => String] = f _
}
