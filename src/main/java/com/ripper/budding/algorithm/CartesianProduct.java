package com.ripper.budding.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shadow 取笛卡尔积(粗糙的方式)
 */
public class CartesianProduct {

    public static List<List<String>> pl(List<String> data) {
        if (data.size() == 1) {
            // 如果data中只有一个元素，那么直接得到它的全排列
            List<List<String>> result = new LinkedList<List<String>>();
            List<String> p = new LinkedList<>();
            p.add(data.get(0));
            result.add(p);
            return result;
        } else {
            // 否则，去除第一个元素，然后得到剩下的 n-1 个元素的全排列，第一个元素插入到每一种排列中的相应位置上就可以得到所有元素的全排列了
            // 也就是说， n-1 个元素的全排列中的每一种排列又可以衍生出 n 种排列
            String first = data.get(0);
            List<String> remainList = data.subList(1, data.size());
            List<List<String>> remainPl = pl(remainList);
            List<List<String>> result = new LinkedList<List<String>>();
            for (int i = 0; i < remainPl.size(); i++) {
                List<String> thisOne = remainPl.get(i);
                for (int j = 0; j <= thisOne.size(); j++) {
                    List<String> copyOne = new LinkedList<>(thisOne);
                    copyOne.add(j, first);
                    result.add(copyOne);
                }
            }
            return result;
        }
    }

    public static void run(String[][] a, List<String> rs, int layer, String curstring) {
        // 大于一个组的时候
        if (layer < a.length - 1) {
            if (a[layer].length == 0)
                run(a, rs, layer + 1, curstring);
            else {
                for (int i = 0; i < a[layer].length; i++) {
                    StringBuilder s1 = new StringBuilder();
                    s1.append(curstring);
                    s1.append(a[layer][i]);
                    run(a, rs, layer + 1, s1.toString());
                }
            }
        } else if (layer == a.length - 1) { // 只有一个集合的时候
            if (a[layer].length == 0) {
                rs.add(curstring);
            } else {
                // 只有一个集合，且集合中有元素时：就是这个集合元素本身
                for (int i = 0; i < a[layer].length; i++) {
                    rs.add(curstring + a[layer][i]);
                }
            }
        }

    }

    public static void main(String[] args) {
        String ck[][] = {{"语文1", "语文2"}, {"数学1", "数学2"}, {"外语1", "外语2",}};
        List<String> result = new ArrayList<String>();
        // 这个地方组装准备全排列的数据
        CartesianProduct.run(ck, result, 0, "");
        int i = 1;
        for (String s : result) {
            System.out.println(i++ + ":" + s);
        }

    }
}

class kc {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}