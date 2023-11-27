import java.lang.NumberFormatException

fun main() {
    println("First: ")
    val first: Double = getEnteredNumber()
    println("Second: ")
    val second: Double = getEnteredNumber()

    val operation: Char = getEnteredOperation()

    calculate(first, second, operation)
}

fun getEnteredNumber(): Double {
    return try {
        print("Enter number = ")
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Incorrect format, use number format!")
        getEnteredNumber()
    }
}

fun getEnteredOperation(): Char {
    print("Enter operation (+, -, /, *): ")
    val operation: Char = readlnOrNull()?.trim()?.firstOrNull() ?: ' '
    return if (charArrayOf('+', '-', '/', '*').contains(operation)) {
        operation
    } else {
        println("Incorrect operation! Allowed operations: +, -, /, *")
        getEnteredOperation()
    }
}

fun calculate(first: Double, second: Double, operation: Char) {
    print("${getTextNumber(first)} $operation ${getTextNumber(second)} = ")
    when (operation) {
        '+' -> println(getTextNumber(first + second))
        '-' -> println(getTextNumber(first - second))
        '/' -> if (second == 0.0) {
            println("Cannot divide by zero")
        } else {
            println(getTextNumber(first / second))
        }
        '*' -> println(getTextNumber(first * second))
    }
}

fun getTextNumber(number: Double): String {
    return if (number % 1.0 == 0.0) number.toInt().toString() else number.toString()
}
