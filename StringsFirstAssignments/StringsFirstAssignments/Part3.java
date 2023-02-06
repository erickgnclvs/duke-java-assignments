public class Part3
{
    public boolean twoOccurrences(String stringa, String stringb) {
        // If stringa appears at least twice in stringb returns true
        int foo = stringb.indexOf(stringa);
        if (foo != -1) {
            int bar = stringb.indexOf(stringa, foo+1);
            if (bar != -1) {
                return true;
            }
        }
        return false;
    }
    
    public String lastPart(String stringa, String stringb) {
        int indexOfStringaInStringb = stringb.indexOf(stringa);
        String result = stringb;
        if (indexOfStringaInStringb != -1) {
            result = stringb.substring(indexOfStringaInStringb + stringa.length());
        }
        return result;
    }
    
    public void testing() {
        String test1stringa = "by";
        String test1stringb = "A story by Abby Long";
        String test2stringa = "a";
        String test2stringb = "banana";
        String test3stringa = "atg";
        String test3stringb = "ctgtatgta";
        String line = "\n";
        
        boolean resultTest1 = twoOccurrences(test1stringa, test1stringb);
        System.out.println("string a = " + test1stringa + "\nstring b = " + test1stringb + "\nresult = " + resultTest1);
        System.out.println(line);
        
        boolean resultTest2 = twoOccurrences(test2stringa, test2stringb);
        System.out.println("string a = " + test2stringa + "\nstring b = " + test2stringb + "\nresult = " + resultTest2);
        System.out.println(line);
        
        boolean resultTest3 = twoOccurrences(test3stringa, test3stringb);
        System.out.println("string a = " + test3stringa + "\nstring b = " + test3stringb + "\nresult = " + resultTest3);
        System.out.println(line);
    }
    
    public void testingLastPart() {
        String stringa1 = "an";
        String stringb1 = "banana";
        System.out.println("Initial full string = " + stringb1);
        System.out.println("string a is = " + stringa1);
        String result1 = lastPart(stringa1, stringb1);
        System.out.println("Remainder String = " + result1);
        System.out.println("\n");
        
        String stringa2 = "zoo";
        String stringb2 = "forest";
        System.out.println("Initial full string = " + stringb2);
        System.out.println("string a is = " + stringa2);
        String result2 = lastPart(stringa2, stringb2);
        System.out.println("Remainder String = " + result2);
        System.out.println("\n");
        
        
        String stringa3 = "an";
        String stringb3 = "there was a spider in the banana tree";
        System.out.println("Initial full string = " + stringb3);
        System.out.println("string a is = " + stringa3);
        String result3 = lastPart(stringa3, stringb3);
        System.out.println("Remainder String = " + result3);
        System.out.println("\n");
        
    }
}
