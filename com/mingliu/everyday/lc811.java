import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lc811 {
    static Map<String, Integer> map;

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            domainHelper(cpdomains[i]);
        }
        List<String> res = new LinkedList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        return res;
        
    }

    private static void domainHelper(String cpdomain) {
        String[] domains = cpdomain.split(" +");
        int count = Integer.parseInt(domains[0]);
        String domain = domains[1];
        String[] domainArr = domain.split("\\.");
        int size = domainArr.length;
        int len = domain.length();
        String subdomain = "";
        for (int i = size - 1; i >= 0; i--) {
            if (subdomain.length() == 0) {
                subdomain = domainArr[i] + subdomain;
            } else {
                subdomain = domainArr[i] + "." + subdomain;
            }

//            if (map.containsKey(subdomain)) {
//                map.put(subdomain, map.get(subdomain)+count);
//            }else{
//                map.put(subdomain, map.get(subdomain)+count);
//            }
            map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
        }
    }
}
