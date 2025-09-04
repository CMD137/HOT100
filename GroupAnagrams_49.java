import java.util.*;

//49.单词异位词分组
public class GroupAnagrams_49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //空串特殊处理
            if (strs.length == 0) return new ArrayList<>();
            //构造散列表，key为对字符串转化为字符数组排序后的唯一字符串序列，value为唯一对应的list结果
            Map<String,List<String>> map=new HashMap<>();
            for (String s:strs){
                char[] chars = s.toCharArray();
                //异位词排序后序列相同
                Arrays.sort(chars);
                //排序后的结果构造为字符串便于比较,作为key
                String key=String.valueOf(chars);

                if (map.containsKey(key)){
                    map.get(key).add(s);
                }else {
                    List<String> newList = new ArrayList<>();
                    newList.add(s);
                    map.put(key, newList);
                }
            }
            return  new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
