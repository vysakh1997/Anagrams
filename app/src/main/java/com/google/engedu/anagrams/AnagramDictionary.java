package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    ArrayList<String> wordList = new ArrayList<>();
    HashSet<String> wordset;
    HashMap<String,ArrayList<String>> lettersToWord = new HashMap<>();


    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);

            String key=sortLetters(word);
            if(!lettersToWord.containsKey(key))
            {
                ArrayList<String> value=new ArrayList<>();
                value.add(word);
                lettersToWord.put(key,value);

            }
            else
            {
                ArrayList<String> value=lettersToWord
            }
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();

        for(int i = 0;i<wordList.size();i++)
        {
            String word = wordList.get(i);

            if(word.length()== targetWord.length())
            {
                if(sortLetters(word).equals(sortLetters(targetWord)))
                    result.add(word);
            }
        }


        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();

            for (char i='a';i<='z';i++){
                String key=sortLetters(word + i);
                if(lettersToWord.get(key)!=null)
                {
                    ArrayList<String> value=lettersToWord.get(key);
                            for(int j=0;j< value.size();j++)
                                result.add(value.get(j));

                }


            }

        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }

    public String sortLetters(String input)
    {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;

     }
}
