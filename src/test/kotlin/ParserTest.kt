import junit.framework.TestCase
import java.math.BigInteger

class ParserTest : TestCase() {

    val objectUnderTest = Parser()

    fun testParse() {
        val input = "(2+2*2)"
        val correctValue = BigInteger.valueOf(6)
        val testValue = objectUnderTest.parse(input).value
        assertTrue(correctValue == testValue)
    }

    fun testParseRelation() {
        val input = "1<2"
        val correctValue = BigInteger.valueOf(1)
        val testValue = objectUnderTest.parseRelation(input).value
        assertTrue(correctValue == testValue)
    }

    fun testParseTerm() {
        val input = "12-10+4"
        val correctValue = BigInteger.valueOf(6)
        val testValue = objectUnderTest.parseTerm(input).value
        assertTrue(correctValue == testValue)
    }

    fun testParseFactor() {
        val input = "1*2*3*4*5*0"
        val correctValue = BigInteger.valueOf(0)
        val testValue = objectUnderTest.parseFactor(input).value
        assertTrue(correctValue == testValue)
    }

    fun testParsePrimary() {
        val input = "(3)"
        val correctValue = BigInteger.valueOf(3)
        val testValue = objectUnderTest.parsePrimary(input).value
        assertTrue(correctValue == testValue)
    }

    fun testParseInteger() {
        val input = "123"
        val correctValue = BigInteger.valueOf(123)
        val testValue = objectUnderTest.parse(input).value
        assertTrue(correctValue == testValue)
    }
}