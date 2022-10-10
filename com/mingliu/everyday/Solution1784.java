public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        String[] str = s.split("0+");
        return str.length <= 1;
    }
}
