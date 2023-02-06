import edu.duke.*;

public class Part4
{   
    public void findWebLinks() {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : ur.words()) {
            int youTubeIndex = word.indexOf("youtube.com");
            if (youTubeIndex != -1) {
                int firstQuoteIndex = word.indexOf("\"");
                int lastQuoteIndex = word.indexOf("\"", youTubeIndex+1);
                String result = word.substring(firstQuoteIndex, lastQuoteIndex+1);
                System.out.println(result);
            }
        }
    }
}
