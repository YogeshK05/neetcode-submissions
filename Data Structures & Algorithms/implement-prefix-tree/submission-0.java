class PrefixTree {
    List<HashMap<Integer, HashSet<String>>> map;

    public PrefixTree() {
        map = new ArrayList(26);
        for (int i = 0; i < 26; i++) map.add(new HashMap<>());
    }

    public void insert(String word) {
        int ind = word.charAt(0);
        HashMap<Integer, HashSet<String>> item = map.get(ind - 'a');
        if (!item.containsKey(word.length()))
            item.put(word.length(), new HashSet<>());
        item.get(word.length()).add(word);
    }

    public boolean search(String word) {
        int ind = word.charAt(0);
        HashMap<Integer, HashSet<String>> item = map.get(ind - 'a');
        if (!item.containsKey(word.length()))
            return false;
        HashSet<String> set = item.get(word.length());
        for (String s : set)
            if (s.equals(word))
                return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        int ind = prefix.charAt(0);
        HashMap<Integer, HashSet<String>> item = map.get(ind - 'a');
        for (Map.Entry<Integer, HashSet<String>> e : item.entrySet())
            if (e.getKey() >= prefix.length())
                for (String s : e.getValue())
                    if (s.startsWith(prefix))
                        return true;
        return false;
    }
}