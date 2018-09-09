package tokens

open class Expression {
    open var value: Long

    constructor(value: Long = 0) {
        this.value = value
    }
}