package lc819;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {


        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord(paragraph, banned));
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        final List<String> collect = list.stream().map(integer -> String.valueOf(integer)).collect(Collectors.toList());
        System.out.println(collect);
    }


}
//class Solution {
//    public String mostCommonWord(String paragraph, String[] banned) {
//        Trie root = new Trie();
//        Trie current = root;
//        for(String str: banned){
//            for(char c: str.toCharArray()){
//                int index = c - 'a';
//                if(current.next[index] == null){
//                    current.next[index] = new Trie();
//                }
//                current = current.next[index];
//            }
//            current.isBanned = true;
//            current = root;
//        }
//        int max = 0;
//        String result = null;
//        paragraph = paragraph.toLowerCase();
//        int start=0, end = 0;
//        int len = paragraph.length();
//        for(int i=0; i< len; i++){
//            while(i< len && (paragraph.charAt(i) < 'a' || paragraph.charAt(i) > 'z')){
//                i++;
//            }
//            start = i;
//
//            while(i< len && paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z'){
//                int index = paragraph.charAt(i) - 'a';
//                if(current.next[index] == null){
//                    current.next[index] = new Trie();
//                }
//                current = current.next[index];
//                i++;
//            }
//
//            current.count++;
//
//            if(!current.isBanned && current.count > max){
//                max = current.count;
//                result = paragraph.substring(start, i);
//            }
//            current = root;
//        }
//
//        return result;
//
//    }
//
//    class Trie{
//        Trie[] next = new Trie[26];
//        boolean isBanned = false;
//        int count = 0;
//    }
//}

/*map的功能*/
class Solution {
    List<String> allWord;

    private String leaveOnlyWord(String string) {
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' &&  c <= 'z') {
                continue;
            }else if (c >= 'A' &&  c <= 'Z'){
                continue;
            }else{
                chars[i] = ' ';
            }

        }
        return new String(chars);
    }
    public String mostCommonWord(String paragraph, String[] banned) {

        String[] strings = leaveOnlyWord(paragraph).split(" +");


        final List<String> words = Arrays.asList(strings);
        final List<String> bannned_words = Arrays.asList(banned);
        allWord = words;

//        words.stream().flatMap(s -> bannned_words.stream().filter(banned_word -> !s.equalsIgnoreCase(banned_word))).forEach(s -> System.out
//            .println(s));

        final Map<Integer, List<String>> collect = words.parallelStream()
            .filter(s -> notBanned(s, banned))
            .collect(Collectors.groupingBy(s -> countString(s)));

        int max = 0;
        for (Map.Entry<Integer, List<String>> entry : collect.entrySet()) {
            max = Math.max(entry.getKey(), max);
        }

        return collect.get(max).get(0).toLowerCase();

    }

    private int countString(String s){
        int res = 0;
        for (String word : allWord) {
            if (word.equalsIgnoreCase(s)) res++;
        }
        return res;
    }

    private boolean notBanned(String s, String[] banned){
        for (String bannedWord : banned)
        {
            if (s.equalsIgnoreCase(bannedWord)) return false;
        }
        return true;
    }
}