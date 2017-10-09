package com.vanderfox.codeanalysis

/**
 * Created by lfox on 9/5/17.
 */
class SignatureSurvey {

    static void main(String[] args) {
        File file = new File(args[0])
        def lines = file.readLines()
        lines.each {
            def currentLine = it
            char[] characterArray = currentLine.toCharArray()
            characterArray.each { foo ->
                args.each {
                    if (it == foo)
                        print it
                }
            }
        }
    }

}
