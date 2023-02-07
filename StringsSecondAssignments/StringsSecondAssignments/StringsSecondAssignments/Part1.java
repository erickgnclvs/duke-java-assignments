public class Part1
{
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        int length = dna.length();
        return length;
    }
    
    public String findGene(String dna, int index) {
        int startIndex = dna.indexOf("ATG", index);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if (taaIndex != -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex+3);
    }
    
    public void testFindGene() {
        String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        String gene = findGene(dna, 0);
        System.out.println(gene);
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            if (!currentGene.isEmpty()) {
                startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            }
            // startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    public void testOn(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }
    public void test() {
        // testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        // testOn("ATG");
        // testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        testOn("GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA");
    }
    
    public void testFindStopCodon() {
        //             01234567890123456
        String dna1 = "zzzzzzzzzTAAzzzTA";
        String dna2 = "zzzzzTAAzzzzzzzzz";
        String dna3 = "zzzzzzzzzzzzTAAzz";
        String dna4 = "zzzzzzzzzzzzzzzzz";
        String stopCodon = "TAA";
        int stopCodonIndex1 = findStopCodon(dna1, 0, stopCodon);
        System.out.println(stopCodonIndex1);
        System.out.println("--------------------------");
        int stopCodonIndex2 = findStopCodon(dna2, 0, stopCodon);
        System.out.println(stopCodonIndex2);  
        System.out.println("--------------------------");
        int stopCodonIndex3 = findStopCodon(dna3, 0, stopCodon);
        System.out.println(stopCodonIndex3);  
        System.out.println("--------------------------");
        int stopCodonIndex4 = findStopCodon(dna4, 0, stopCodon);
        System.out.println(stopCodonIndex4);  
        System.out.println("--------------------------");
    }
}
