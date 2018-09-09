package tokens

open class Relation: Binary() {

    class Less(left: Expression, right: Expression) : Relation() {
        override var left = left
        override var right = right
        override var value: Long = if (left.value < right.value) 1L else 0L
    }

    class More(left: Expression, right: Expression): Relation() {
        override var left = left
        override var right = right
        override var value: Long = if (left.value > right.value) 1L else 0L
    }

    class Equal(left: Expression, right: Expression): Relation() {
        override var left = left
        override var right = right
        override var value: Long = if (left.value == right.value) 1L else 0L
    }

}