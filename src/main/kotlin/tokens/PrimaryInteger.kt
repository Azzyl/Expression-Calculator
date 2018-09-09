package tokens

import java.math.BigInteger

class PrimaryInteger(value: BigInteger): Primary() {
    override var value = value
}