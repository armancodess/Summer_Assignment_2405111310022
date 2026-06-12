class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index] = currentChar;
            index++;

            if (count > 1) {
                String countString = String.valueOf(count);

                for (char digit : countString.toCharArray()) {
                    chars[index] = digit;
                    index++;
                }
            }
        }

        return index;
    }
}