class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.size() > 0 && set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int part = n % 10;
                sum += part * part;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}