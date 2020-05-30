package learnfp.typeclass

import scala.language.implicitConversions

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class ShowTest extends AnyWordSpecLike with Matchers {
  import ShowInstances._

  "Show" should {
    "show int " in {
      Printer.show(5) shouldBe "5"
    }

    "show double" in {
      Printer.show(5.0) shouldBe "5.0"
    }

    "show list of int" in {
      Printer.show(List(5, 10, 20)) shouldBe "[5, 10, 20]"
    }
  }

}
