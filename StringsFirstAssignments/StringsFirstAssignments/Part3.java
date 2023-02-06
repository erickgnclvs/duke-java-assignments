public class Part3
{
    public boolean twoOccurrences(String stringa, String stringb)
    {
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
}
