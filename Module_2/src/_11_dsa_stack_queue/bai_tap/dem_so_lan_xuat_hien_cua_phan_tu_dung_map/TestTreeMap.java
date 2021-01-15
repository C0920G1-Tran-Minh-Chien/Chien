package _11_dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_phan_tu_dung_map;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    public static final char SPACE = ' ';
    public static final char BREAK_LINE = '\n';

    public static void main(String[] args) {
        String str = "Trump vo dich Trump ";
        System.out.println(str);
        // liệt kê sô lần xuất hiện của các từ trong chuỗi trên
        System.out.println("Liệt kê số lần xuất hiện của các từ: ");
        Map<String, Integer> wordMap = countWords(str);
        for (String key : wordMap.keySet()) {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }
//      Đếm số từ của một chuỗi,
//      giả sử các từ được ngăn cách nhau bởi một hoặc nhiều
//      dấu 'space'xuống dòng '\n'
//      @param input - chuỗi ký tự
//      @return số từ của chuỗi ký tự input
//     /
    public static Map<String, Integer> countWords(String input) {
        // khởi tạo wordMap
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE
                    && input.charAt(i) != BREAK_LINE) {
//                Nếu k phải space hoặc xuống dòng thì nối vào
                // build một từ
                sb.append(input.charAt(i));
            } else {
                // thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        // thêm từ cuối cùng tìm được vào wordMap
        addWord(wordMap, sb);
        return wordMap;
    }

//      Thêm từ vào wordMap
//      wordMap: map chứa các từ và số lần xuất hiện
//      sb: từ cần thêm vào wordMap
    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }
}
