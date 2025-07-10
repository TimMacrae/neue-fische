//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    val n = 10  // Change this value for different number of primes
    val primes = generateFirstNPrimes(n)

    println("First $n prime numbers:")
    println(primes.joinToString(", "))
}

// Generates the first n prime numbers
fun generateFirstNPrimes(n: Int): List<Int> {
    val primes = mutableListOf<Int>()
    var number = 2

    while (primes.size < n) {
        if (isPrime(number)) {
            primes.add(number)
        }
        number++
    }

    return primes
}

// Checks if a number is prime
fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}