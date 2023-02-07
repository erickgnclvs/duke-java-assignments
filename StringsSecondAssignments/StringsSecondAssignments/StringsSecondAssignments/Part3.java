public class Part3
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
    
    public int printAllGenes(String dna) {
        int startIndex = 0;
        int counter = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            counter++;
            if (!currentGene.isEmpty()) {
                startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            }
            // startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return counter;
    }
    
    public int countGenes(String dna){
        int counter = printAllGenes(dna);
        return counter;
    }
    
    public void testCountGenes() {
        int counter = countGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        System.out.println(counter + "\n");
    }
    
}
