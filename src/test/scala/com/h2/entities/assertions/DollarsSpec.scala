package com.h2.entities.assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {
behavior of "A Dollar"

  it should "create a correct Dollar object for number 10 input" in {
    val tenDollars = Dollars(102)
    assert("$102" === tenDollars.toString)
  }

  it should "correctly identify that 10usd greater than 5usd" in {
    val tenDollars = Dollars(10)
    val fourDollars = Dollars(4)

    assert (tenDollars > fourDollars)
  }

  it should "use \"less than\" properly" in {
    val fortyFive = Dollars(45)
    val ninetyTwo = Dollars(92)
    assert (fortyFive < ninetyTwo)
  }

}
