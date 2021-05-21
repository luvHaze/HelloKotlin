package CodingTest.Programmers.SolveSample

import java.util.Stack
private class RecommendIDSolution {
    fun solution(new_id: String): String {
        var answer: String = stepOne(new_id)
            .stepTwo()
            .stepThree()
            .stepFour()
            .stepFive()
            .stepSix()
            .stepSeven()

        return answer
    }

    fun stepOne(id: String): String {
        return id.toLowerCase()
    }

    fun String.stepTwo(): String {
        return this.filter { char ->
            char in 'a'..'z' || char in '0'..'9'
                    || char == '-' || char == '_' || char == '.'
        }
    }

    fun String.stepThree(): String {
        val stack = Stack<Char>()
        this.forEach { char ->
            if(stack.isNotEmpty()) {
                if(stack.peek() != '.' || char != '.') {
                    stack.push(char)
                }
            } else {
                stack.push(char)
            }
        }

        return stack.joinToString("")
    }

    fun String.stepFour(): String {
        val stack = Stack<Char>()
        this.forEachIndexed { idx, char ->
            if(idx == 0 || idx == this.length) {
                if(char != '.') {
                    stack.push(char)
                }
            } else {
                stack.push(char)
            }
        }
        return stack.joinToString("")
    }

    fun String.stepFive(): String {
        return if(this == "") {
            this + "a"
        } else {
            this
        }
    }

    fun String.stepSix(): String {
        val stack = Stack<Char>()
        this.forEachIndexed { idx, char ->
            if(idx < MAX_LENGTH) {
                stack.push(char)
            }
        }
        if(stack.peek() == '.') stack.pop()

        return stack.joinToString("")
    }

    fun String.stepSeven(): String {
        if(this.length <= 2) {
            val lastChar = this.last()
            var fixString = this
            while(fixString.length < MIN_LENGTH) {
                fixString += lastChar
            }
            return fixString
        }

        return this
    }

    companion object {
        const val MAX_LENGTH = 15
        const val MIN_LENGTH = 3
    }
}