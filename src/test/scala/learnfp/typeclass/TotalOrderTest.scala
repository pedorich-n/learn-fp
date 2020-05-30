package learnfp.typeclass

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class TotalOrderTest extends AnyWordSpecLike with Matchers {
  import TotalOrderInstances._

  "TotalOrder" should {
    "compare ints" in {
      Comparator.less(5, 10) shouldBe true
      Comparator.less(10, 5) shouldBe false
    }

    "compare strings" in {
      Comparator.less("5", "9") shouldBe true
      Comparator.less("9", "5") shouldBe false
    }

    "compare list of ints" in {
      Comparator.less(List(5, 10), List(10, 20)) shouldBe true
    }
  }

}
