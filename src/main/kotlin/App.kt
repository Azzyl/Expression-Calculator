import java.io.File
import java.math.BigInteger

fun readFileLines(fileName: String): List<String> {
    val file = File(fileName)
    val strings = file.readLines()
    return strings
}

fun main(args: Array<String>) {
    val input = readFileLines("in.txt")
    val parser = Parser()
    val output = ArrayList<BigInteger>()
    for (i in 0..input.lastIndex)
        output.add(parser.parse(input[i]).value)
    File("out.txt").printWriter().use { out ->
        output.forEach {
            out.println("${it}")
        }
    }
}