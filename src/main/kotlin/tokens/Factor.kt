package tokens

open class Factor: Binary() {

    class Multiply(left: Expression, right: Expression): Factor() {
        override var left = left
        override var right = right
        override var value: Long = left.value * right.value
    }

}