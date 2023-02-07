public class Part2 {
    public int howMany(String stringa, String stringb) {
        int startIndex = 0;
        int counter = 0;
        int currIndex = stringb.indexOf(stringa, startIndex);
        while (true) {
            if (currIndex != -1) {
                counter++;
            } else {
                break;
            }
            currIndex = stringb.indexOf(stringa, currIndex + stringa.length());
        }
        return counter;
    }
    
    public void testHowMany() {
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println(howMany(stringa, stringb));
        stringa = "AA";
        stringb = "ATAAAATAAAA";
        System.out.println(howMany(stringa, stringb));
    }
}