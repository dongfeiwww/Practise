import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

import api.Api;

/**
 * @Fei Dong
 */
class Hangman {
  // dictionary for English
  final static String DICT_FILE = "/usr/share/dict/words";
  // first time to run
  boolean _first;
  // most frequent char sorted in order of dictionary
  Integer[] _freqChars;
  // to store some length and char info. Key is 'word length', value is a set of words in dictionary
  HashMap<Integer, Set<String>> _wordMap;
  // have tried char
  List<Character> _triedChars;
  // game words from reponse with some '_' masks
  List<String> _wordList;

  public Hangman() throws Exception {
    _wordMap = new HashMap<Integer, Set<String>>();
    _triedChars = new ArrayList<Character>();
    _first = true;
    buildWordMap();
  }

  // load dictionary and build word map initially
  public void buildWordMap() throws Exception {
    InputStream    fis;
    BufferedReader br;
    String         line;
    final int[] charFreq = new int[26];
    // read from dict and build length map on top of that
    fis = new FileInputStream(DICT_FILE);
    br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
    while ((line = br.readLine()) != null) {
      String word = line.toLowerCase();
      int len = word.length();
      if (!_wordMap.containsKey(len)) {
         _wordMap.put(len, new HashSet<String>());
      }

      _wordMap.get(len).add(word);
      for (char c: word.toCharArray()) {
        if (c >= 'a' && c <= 'z') {
          charFreq[c - 'a'] += 1;
        }
      }
    }

    _freqChars = getSortedIndexHelper(charFreq);
    // Done with the file
    br.close();
  }

  // sort by indices
  Integer[] getSortedIndexHelper(final int[] charFreq) {
    final Integer[] charSortArray = new Integer[26];
    for (int i=0; i<26; i++)
      charSortArray[i] = i;
    Arrays.sort(charSortArray, new Comparator<Integer>() {
        @Override public int compare(final Integer o1, final Integer o2) {
            return Integer.compare(charFreq[o2], charFreq[o1]);
        }
    });
    return charSortArray;
  }

  // pares a phrase into word array
  void parsePhrase(String phrase) {
    String[] segs = phrase.split(" ");
    _wordList = new ArrayList<String>();
    for (int i=0; i<segs.length; i++) {
      _wordList.add(segs[i]);
    }
  }

  // main search function
  // algorithm:
  //  * first time, it directly return with most freq char in global dictionary
  //  * parse phrase into a list of mask words, filter that length from _wordMap.set = _wordMap[length]
  //  * scan for each mask word, build a position map e.g. '_ell_' => {1:e,2:l,3:l} and search in
  //     set with exact position, and maintain a charFreq count map to get the most freq char.
  //  * update _wordMap with all found possibles words. It can reduce searching space in next round
  //  * sort charFreq and return the most freq char until now (exclude char guess before)
  char searchBestFit(String phrase) {
    parsePhrase(phrase);
    // first time we just try the most freq char
//    if (_first) {
//      _first = false;
//      return (char)(_freqChars[0] + 'a');
//    }

    HashMap<Integer, Set<String>> wordMapForNextRound = new HashMap<Integer, Set<String>>();
    int[] charFreq = new int[26];
    for (int i=0; i<_wordList.size(); i++) {
      String word = _wordList.get(i);
      int len = word.length();
      if (!wordMapForNextRound.containsKey(len)) {
        wordMapForNextRound.put(len, new HashSet<String>());
      }

      // from position to char
      HashMap<Integer, Character> positionMap = new HashMap<Integer, Character>();
      // search if contain mask
      if (word.contains("_")) {
        for (int j=0; j<word.length(); j++) {
          char c = word.charAt(j);
          if (c >= 'a' && c <= 'z') {
            _triedChars.add(c);
            positionMap.put(j, c);
          }
        }

        if (positionMap.size() > 0) {
          wordMapForNextRound.get(len).addAll(findPossibleWords(word, positionMap, charFreq));
        }
      }
      else {
        wordMapForNextRound.get(len).addAll(_wordMap.get(len));
      }
    }

    // update _wordMap for next round, it will reduce candidate words in map
    _wordMap = wordMapForNextRound;

    // sort by char index and return the first char that not tried before.
    char bestFit = 'a';
    Integer[] charIndexArray = getSortedIndexHelper(charFreq);
    for (int x: charIndexArray) {
      char c =  (char) ('a' + x);
      if (!_triedChars.contains(c)) {
        _triedChars.add(c);
        bestFit = c;
        break;
      }
    }
    return bestFit;
  }

  Set<String> findPossibleWords(String word, HashMap<Integer, Character> positionMap, int[] charFreq) {
    Set<String> candidates = _wordMap.get(word.length());
    Set<String> possibles = new HashSet<String>();
    for (String candidate: candidates) {
      boolean match = true;
      for (Map.Entry<Integer, Character> entry: positionMap.entrySet()) {
        if (!entry.getValue().equals(candidate.charAt(entry.getKey()))) {
          match = false;
          break;
        }
      }
      if (match) {
        possibles.add(candidate);
      }
    }

    // update charFreq that appear in every possible words
    for (String s: possibles) {
        for (char cs: s.toCharArray()) {
          if (cs >= 'a' && cs <= 'z' && !positionMap.values().contains(cs)) {
            charFreq[cs - 'a'] += 1;
          }
        }
    }

    for (int i=0; i<26; i++)
      System.out.println("charFreq:" + (char) (i+'a') + charFreq[i]);
    return possibles;
  }

	public static void main(String[] args) throws Exception {
    // Start the game!!!
	  Hangman hangman = new Hangman();

		// Show an example usage of the API.  This creates a new game and makes
		// three guesses, showing the game state response after each call.
		Api.GameResponse response = Api.sendNewGameRequest("test@test.com");
    System.out.println("original: " + response.phrase);
    char guess = hangman.searchBestFit("_hat");
    System.out.println("guess: " + guess);
//    int i=0;
// 		while (response.num_tries_left > 0 && response.phrase.contains("_")) {
//		  char guess = hangman.searchBestFit(response.phrase);
//		  response = Api.sendGuessRequest(response.game_key, guess);
//	    System.out.println("try:" + (++i) + " guess char:" + guess + " response:"
//	        +  response.phrase + " left times:" + response.num_tries_left);
//		}
	}

}
