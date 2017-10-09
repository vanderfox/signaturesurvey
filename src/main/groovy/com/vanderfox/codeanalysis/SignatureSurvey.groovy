package com.vanderfox.codeanalysis

/**
 * Created by lfox on 9/5/17.
 */
class SignatureSurvey {

    static void main(String[] args) {
        if (args.length < 1) {
            print "usage:  SignatureSurvey <file> <list of characters separated by spaces>"
            return
        }
        recurseDirectory(new File(args[0]), args)

    }

    static void recurseDirectory(File currentDirectory, String[] args) {
        if (currentDirectory.directory) {
            File[] files = currentDirectory.listFiles()
            files.each { currentFile ->
                if(currentFile.isDirectory()) {
                    recurseDirectory(currentFile, args)
                } else {
                    if(currentFile.getAbsolutePath().endsWith("." + args[1]))
                        parseSignature(currentFile, args)
                }
            }
        }
    }

    static void parseSignature(File codeFile, String[] args) {
        print codeFile.getName() + ":  "
        def lines = codeFile.readLines()
        lines.each {
            def currentLine = it
            char[] characterArray = currentLine.toCharArray()
            characterArray.each { foo ->
                for (int i = 2; i < args.length; i++) {
                    if (args[i] == foo)
                        print foo
                }
            }
        }
        println()
    }

}
