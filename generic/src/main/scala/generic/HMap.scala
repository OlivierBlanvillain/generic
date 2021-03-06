package generic

// An HMap is an HList with HEntry elements. We are reusing HList for it's nice syntax

// Should be `K <: Singleton` but inference for `--` does not quite work with that.
final case class HEntry[K, V](value: V)

// Accessor type class to compute the element of type K in a HMap L -------------------------------

trait PhantomGet[K, M <: HList] {
  type Index <: Nat
}

object PhantomGet {
  type Aux[K, M <: HList, I <: Nat] =     PhantomGet[K, M] { type Index = I }
  def  aux[K, M <: HList, I <: Nat] = new PhantomGet[K, M] { type Index = I }

  implicit def getHead[K, V, T <: HList]: Aux[K, HEntry[K, V] :: T, Zero] = aux
  implicit def getTail[K, H, T <: HList, I <: Nat]
    (implicit t: Aux[K, T, I]): Aux[K, H :: T, Succ[I]] = aux
}

// Syntax -----------------------------------------------------------------------------------------

trait HMapSyntax {
  object hmap {
    implicit class hmapGet[M <: HList](m: M) {
      def get[K, V, I <: Nat](k: K)
        (implicit
          g: PhantomGet.Aux[k.type, M, I],
          a: At.Aux[M, I, HEntry[k.type, V]]
        ): V = a(m).value
    }

    implicit class EntryAssoc[K](k: K) {
      def -- [V](value: V): HEntry[K, V] = HEntry(value)
    }
  }
}
