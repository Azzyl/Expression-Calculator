package tokens

open class Term: Binary() {

    class Plus(left: Expression,right: Expression): Term() {
        override var left = left
        override var right = right
        override var value: Long = left.value + right.value
    }

    class Minus(left: Expression,right: Expression): Term() {
        override var left = left
        override var right = right
        override var value: Long = left.value - right.value
    }

}