package tokens

import java.math.BigInteger

open class Relation: Binary() {

    class Less(left: Expression, right: Expression) : Relation() {
        override var left = left
        override var right = right
        override var value: BigInteger = if (left.value < right.value) BigInteger.valueOf(1) else BigInteger.valueOf(0)
    }

    class More(left: Expression, right: Expression): Relation() {
        override var left = left
        override var right = right
        override var value: BigInteger = if (left.value > right.value) BigInteger.valueOf(1) else BigInteger.valueOf(0)
    }

    class Equal(left: Expression, right: Expression): Relation() {
        override var left = left
        override var right = right
        override var value: BigInteger = if (left.value == right.value) BigInteger.valueOf(1) else BigInteger.valueOf(0)
    }

}