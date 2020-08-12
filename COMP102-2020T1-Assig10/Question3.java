// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2020T1, Assignment 10
 * Name: Chloe Crowe
 * Username: Crowechlo
 * ID: 300539785
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * Question 3: Writing programs with Files
 */
public class Question3{

    /**
     * findLongestWord should read all the words from the file specified
     *   by the parameter,
     * and then find and return the longest word.
     * If there are two or more equally longest words, it should return
     *   the last one.
     * It should not count the punctuation.
     */
    public String findLongestWord(String filename) {
        //Sets the longest word to nothing
        String longestWord = "";
        try{
            //Creates a new scanner
            Scanner scan = new Scanner(Path.of(filename));
            //While there is another string in the file
            while (scan.hasNext()){
                //Scans the next word
                String checkWord = scan.next();
                //If the current word is longer than the longest word then it becomes the longest word.
                if (checkWord.length() >= longestWord.length()){
                    longestWord = checkWord;
                }
            }
        }
        //Throws an exception If there is an error in the file
        catch(IOException e){
            UI.println("File error");
        }
        return longestWord;
    }

    /**********************************************************
     * The following is a test method and the GUI for testing *
     **********************************************************/

    public void test1(){
        String longestWord = this.findLongestWord("testfile.txt");
        UI.println("Longest word = "+ longestWord);
    }

    public void test2(){
        String longestWord = this.findLongestWord(UIFileChooser.open());
        UI.println("Longest word = "+ longestWord);
    }

    public void setupGUI() {
        UI.initialise();
        UI.addButton("Run on testfile", this::test1);
        UI.addButton("Run", this::test2);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1.0);
    }

    public static void main(String[] args) {
        new Question3().setupGUI();
    }
}

