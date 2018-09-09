package tokens

import java.math.BigInteger

open class Expression {
    open var value: BigInteger

    constructor(value: BigInteger = BigInteger.valueOf(0)) {
        this.value = value
    }
}