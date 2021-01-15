package _12_java_collection_framework.thuc_hanh.luu_danh_sach_theo_tuoi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Chien", 18);
        hashMap.put("Anh", 28);
        hashMap.put("Lee", 38);
        hashMap.put("Fuc", 20);
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Chien", 18);
        linkedHashMap.put("Anh", 28);
        linkedHashMap.put("Lee", 38);
        linkedHashMap.put("Fuc", 20);
        System.out.println("\nThe age for " + "Lee is " + linkedHashMap.get("Lee"));
    }
}
