package com.h2.entities

import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
    behavior of "an email"
    it should "return an Email, given an address" in {
        val email = Email("naha@giggle.com")
        assertResult("naha")(email.localPart)
        assertResult("giggle.com")(email.domain)
    }

    it should "return another email object for another address" in {
        assertResult ("dov") {
            Email("dov@yahoo.com").localPart
        }
    }
}

class EmailAtsignSpec extends AnyFlatSpec {
    behavior of "an email"
    it should "throw IAE on no atsign in address" in {
        assertThrows[IllegalArgumentException] {
            val email = Email("noAtsignHere")
        }
    }
    it should "return normally on one atsign in address" in {
        assertResult("destination.com") {
            val email = Email("oneAtsign@destination.com")
            email.domain
        }
    }
    it should "throw IAE on more than one atsign in address" in {
        assertThrows[IllegalArgumentException] {
            val email = Email("here@and@there.com")
        }
    }

    it should "intercept IAE on no atsign" in {
        val interceptedIllegalArgumentException = intercept[IllegalArgumentException] {
            val badEmail = Email("nobodyATnowhere")
        }
        assert(interceptedIllegalArgumentException.isInstanceOf[IllegalArgumentException])
    }

//    ignore should "bill customer for number of characters in email message" in {}

}