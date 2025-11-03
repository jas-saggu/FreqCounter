fun main() {
    val totalCounter = mutableMapOf<String, Int>()
    var running = true

    do {
        // 1. Read sentence immediately
        print("\nEnter a sentence: ")
        val currentLine = readLine()

        // 2. Assign to non-null variable after trimming
        val input = currentLine?.trim() ?: ""

        // 3. Check if input is empty
        if (input == "") {
            println("You entered nothing! Exiting...")
            break
        }

        // 4. Clean and split words
        val words = input
            .lowercase()                              // convert to lowercase
            .replace("[^a-z\\s]".toRegex(), "")       // remove punctuation
            .split(" ")                               // split by space
            .filter { it.isNotBlank() }               // remove empty strings

        // 5. Current sentence counter
        val currentCounter = mutableMapOf<String, Int>()

        // 6. Update both counters
        for (word in words) {
            currentCounter[word] = (currentCounter[word] ?: 0) + 1
            totalCounter[word] = (totalCounter[word] ?: 0) + 1
        }

        // 7. Print current count
        println("\nCurrent string: \"$input\"")
        println("Current count:")
        for ((word, count) in currentCounter) {
            println("- $word: $count")
        }

        // 8. Print running total
        println("\nRunning total:")
        for ((word, count) in totalCounter) {
            println("- $word: $count")
        }

        // 9. Ask user if they want to continue
        println("\nDo you want to enter another sentence?")
        println("1. Yes")
        println("2. No")
        print("Enter your choice (1 or 2): ")
        val choice = readLine()?.trim()

        if (choice == "1") {
            running = true
        } else {
            running = false
        }

    } while (running)

    // 10. Final running total
    println("\nFinal running total:")
    for ((word, count) in totalCounter) {
        println("- $word: $count")
    }
}
