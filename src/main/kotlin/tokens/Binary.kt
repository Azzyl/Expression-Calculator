package tokens

open class Binary: Expression() {
    open lateinit var left: Expression
    open lateinit var right: Expression
}