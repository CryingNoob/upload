package KWIC;

import java.util.ArrayList;

/**
 * 循环移位
 */
public class Loop {
    private ArrayList<String> wordlist = new ArrayList<>();
    private ArrayList<String> linelist = new ArrayList<>();
    private ArrayList<String> lines;

    public Loop(ArrayList<String> lines) {
        this.lines = lines;
    }

    protected ArrayList<String> transform() {
        String line = "";

        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i);
            // 单词拆分
            String[] words = line.split(" ");
            for (String word : words) {
                wordlist.add(word);
            }
            //单词重组
            this.regroup();
            wordlist.clear();
            line = "";
        }
        return linelist;
    }
    protected void regroup() {
        for (int i = 0; i < wordlist.size(); i++) {
            String reline = "";

            for (int j = 0; j < wordlist.size(); j++) {
                if (j == 0) {
                    reline += wordlist.get(j);
                } else {
                    reline += " " + wordlist.get(j);
                }

            }
            linelist.add(reline);
            String word = wordlist.remove(0);
            wordlist.add(word);
        }

    }
}
