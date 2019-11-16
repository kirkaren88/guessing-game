package com.karen.kirakosyan

import java.lang.NumberFormatException
import kotlin.random.Random
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var gameLevel: String?
    var stepsCount: Int = 0

    while (true) {
        gameLevel = insertGameLevel()

        if (gameLevel == "0") {
            println("Game over!")
            exitProcess(0)
        }

        if (gameLevel != null) {

            println("Your game level is $gameLevel")

            when (gameLevel) {
                "easy" -> stepsCount = 7
                "medium" -> stepsCount = 5
                "hard" -> stepsCount = 3
            }

            println("You have $stepsCount steps to guess number between 1 to 100")
            var randomNumber = Random.nextInt(1, 100);

            var rangeStart: Int = 1
            var rangeEnd: Int = 100
            var guessWasSuccess: Boolean = false

            for (i in 0 until stepsCount) {
                println("Please enter number between $rangeStart to $rangeEnd")
                try {
                    var insertedNumber: Int? = readLine()?.toInt()

                    if (insertedNumber != null) {
                        if (randomNumber == insertedNumber) {
                            guessWasSuccess = true
                            println("Congrats, you guess the number , it is $randomNumber");
                            break
                        }
                        if (randomNumber > insertedNumber) {
                            rangeStart = insertedNumber
                            if (i != stepsCount - 1) {
                                println("Take higher")
                            }
                        } else {
                            rangeEnd = insertedNumber
                            if (i != stepsCount - 1) {
                                println("Take lower")
                            }
                        }
                    }
                } catch (e: NumberFormatException) {
                    println("Please insert only number!")
                }
            }

            if (!guessWasSuccess) {
                println("You lost the game!")
            }

            println()
            println("Game starts again!")
        }
    }
}


fun insertGameLevel(): String? {
    println("Enter game level please(1- Easy, 2- Medium, or 3- Hard, 0- Exit)")
    var gameLevel: String?
    var gameLevelByNumber: String? = readLine()

    if (gameLevelByNumber == "" || (gameLevelByNumber != "1" && gameLevelByNumber != "2" && gameLevelByNumber != "3" && gameLevelByNumber != "0")) {
        println("Wrong command")
        return null
    }

    when (gameLevelByNumber) {
        "1" -> gameLevel = "easy"
        "2" -> gameLevel = "medium"
        "3" -> gameLevel = "hard"
        else -> gameLevel = "0"
    }
    
    return gameLevel
}