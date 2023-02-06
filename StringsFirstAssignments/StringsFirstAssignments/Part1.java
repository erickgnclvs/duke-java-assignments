public class Part1
{
    public String findSimpleGene(String dna)
    {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "no ATG found";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1) {
            return "no TAA found";
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
            return result;
        }
        else {
            return "invalid gene - not multiple of 3";
        }
    }
    
    public void testing() {
        String test1 = "AATAAGTAATAGGTTGAAGAATTGTTAA"; // String without ATG
        String test2 = "TAGTAGAGTGTAGAATGAGTATTGGTAG"; // String without TAA
        String test3 = "ATTAGGTTAGGTAGAATAGGTATAGGAA"; // String without ATG and TAA
        String test4 = "AAATGAGAGTGTGTGATAAAAGAGTTGG"; // String with ATG and TAA but not multiple of 3 
        String test5 = "AAATGAGAGTGTGTGAGTAAAAGAGTTG"; // String with ATG and TAA and is multiple of 3
        
        String result1 = findSimpleGene(test1);
        System.out.println("result of test1 (AATAAGTAATAGGTTGAAGAATTGTTAA), string without ATG = " + result1);
        System.out.println("\n");
        
        String result2 = findSimpleGene(test2);
        System.out.println("result of test2 (TAGTAAGAGTGTAGAATAGTATTGGTAG), string without TAA = " + result2);       
        System.out.println("\n");
        
        String result3 = findSimpleGene(test3);
        System.out.println("result of test3 (ATTAGGTTAGGTAGAATAGGTATAGGAA), string without ATG and TAA = " + result3);
        System.out.println("\n");
        
        String result4 = findSimpleGene(test4);
        System.out.println("result of test4 (AAATGAGAGTGTGTGATAAAAGAGTTGG), string with ATG and TAA but not multiple of 3 = " + result4);
        System.out.println("\n");
        
        String result5 = findSimpleGene(test5);
        System.out.println("result of test5 (AAATGAGAGTGTGTGAGTAAAAGAGTTG), string with ATG and TAA and is multiple of 3 = " + result5);
        System.out.println("\n");
    }
}
