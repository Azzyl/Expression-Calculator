import tokens.*

class Parser {

    private val RELATION_FLAG = "RELATION_FLAG"
    private val TERM_FLAG = "TERM_FLAG"
    private val FACTOR_FLAG = "FACTOR_FLAG"

    private fun findOp(flag: String, input: String): Int {
        when (flag) {
            RELATION_FLAG -> {
                var brackets = 0
                for (i in input.lastIndex downTo 0) {
                    if (input[i] == '(') brackets--
                    if (input[i] == ')') brackets++
                    if ((input[i] == '>' || input[i] == '<' || input[i] == '=') && brackets == 0)
                        return i
                }
                if (brackets > 0)
                    return -2
            }
            TERM_FLAG -> {
                var brackets = 0
                for (i in input.lastIndex downTo 0) {
                    if (input[i] == '(') brackets--
                    if (input[i] == ')') brackets++
                    if (((input[i] == '+' || input[i] == '-') && i != 0) && brackets == 0)
                        return i
                }
                if (brackets > 0)
                    return -2
            }
            FACTOR_FLAG -> {
                var brackets = 0
                for (i in input.lastIndex downTo 0) {
                    if (input[i] == '(') brackets--
                    if (input[i] == ')') brackets++
                    if ((input[i] == '*') && brackets == 0)
                        return i
                }
                if (brackets > 0)
                    return -2
            }
        }
        return -1
    }

    fun parse(input: String): Expression {
        var result = parseRelation(input)
        return result
    }

    fun parseRelation(input: String): Expression {
        var i = findOp(RELATION_FLAG, input)
        if (i == -2)
            throw Exception("Invalid brackets")
        if (i == -1)
            return parseTerm(input)
        else
            if (input[i] == '>')
                return Relation.More(parseTerm(input.substring(0, i)), parseTerm(input.substring(i + 1)))
            else
                if (input[i] == '<')
                    return Relation.Less(parseTerm(input.substring(0, i)), parseTerm(input.substring(i + 1)))
                else
                    return Relation.Equal(parseTerm(input.substring(0, i)), parseTerm(input.substring(i + 1)))
    }

    fun parseTerm(input: String): Expression {
        var i = findOp(TERM_FLAG, input)
        if (i == -2)
            throw Exception("Invalid brackets")
        if (i == -1)
            return parseFactor(input)
        else
            if (input[i] == '+')
                return Term.Plus(parseTerm(input.substring(0, i)), parseFactor(input.substring(i + 1)))
            else
                return Term.Minus(parseTerm(input.substring(0, i)), parseFactor(input.substring(i + 1)))
    }

    fun parseFactor(input: String): Expression {
        var i = findOp(FACTOR_FLAG, input)
        if (i == -2)
            throw Exception("Invalid brackets")
        if (i == -1)
            return parsePrimary(input)
        else
            return Factor.Multiply(parseFactor(input.substring(0, i)), parsePrimary(input.substring(i + 1)))
    }

    fun parsePrimary(input: String): Expression {
        if (input[0] == '(' && input[input.lastIndex] == ')')
            return parse(input.substring(1, input.lastIndex))
        else
            return parseInteger(input)
    }

    fun parseInteger(input: String): Expression {
        return Expression(input.toBigInteger())
    }

}