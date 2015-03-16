package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * Add a word to this trie
   * 
   * @param word
   */
  public void addWord(String word) {
    if (word == null || word.length() == 0)
      return;
    root.addWord(word.toLowerCase());
  }

  /**
   * Get the words in the trie with the given prefix
   * 
   * @param prefix
   * @return
   */
  public List<String> getWords(String prefix) {
    List<String> result = new ArrayList<String>();
    if (prefix == null || prefix.length() == 0)
      return result;
    TrieNode lastNode = root;
    StringBuilder prefixBuilder = new StringBuilder();
    for (int i = 0; i < prefix.length(); i++) {
      if (lastNode == null)
        return result;
      lastNode = lastNode.getChild(prefix.charAt(i));
      prefixBuilder.append(prefix.charAt(i));
    }
    if (lastNode == null) {
      return result;
    }
    return lastNode.getWords(prefixBuilder);
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    List<String> l = new ArrayList<String>();
    l.add("ball");
    l.add("bat");
    l.add("bats");
    l.add("doll");
    l.add("dork");
    l.add("dorm");
    l.add("send");
    l.add("sense");
    for (String s : l) {
      trie.addWord(s);
    }
    for (String s : trie.getWords("send")) {
      System.out.println(s);
    }
  }
}

class TrieNode {

  private TrieNode[] children;
  private boolean isWord;
  private char character;

  public TrieNode() {
    children = new TrieNode[26];
    isWord = false;
  }

  public TrieNode(char character) {
    this();
    this.character = character;
  }

  public void addWord(String word) {
    char ch = word.charAt(0);
    int index = ch - 'a';
    if (children[index] == null) {
      children[index] = new TrieNode(ch);
      // children[index].parent = this;
    }
    if (word.length() > 1) {
      children[index].addWord(word.substring(1));
    } else {
      children[index].isWord = true;
    }
  }

  public TrieNode getChild(char ch) {
    return children[ch - 'a'];
  }

  /**
   * Get all the words under this node
   * 
   * @return
   */
  public List<String> getWords(StringBuilder currentString) {
    List<String> result = new ArrayList<String>();
    int len = currentString.length();
    if (isWord) {
      result.add(currentString.toString());
    }
    for (TrieNode child : children) {
      if (child != null) {
        List<String> childResult = child.getWords(currentString
            .append(child.character));
        result.addAll(childResult);
        currentString.delete(len, currentString.length());
      }
    }
    return result;
  }
}
