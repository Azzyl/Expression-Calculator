package tokens

import java.math.BigInteger

open class Factor: Binary() {

    class Multiply(left: Expression, right: Expression): Factor() {
        override var left = left
        override var right = right
        override var value: BigInteger = left.value * right.value
    }

}