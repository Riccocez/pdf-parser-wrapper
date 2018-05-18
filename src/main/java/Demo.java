

import org.allenai.scienceparse.BibRecord;
import org.allenai.scienceparse.ExtractedMetadata;
import org.allenai.scienceparse.Parser;
import org.allenai.scienceparse.Section;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Demo {

    public static void main (String[] args){

        try {

            InputStream inputStream = new FileInputStream("/path/to/my/pdf");

            final Parser parser = Parser.getInstance();
            System.out.println("The parser is working!!");

            // Parse without timeout
            final ExtractedMetadata em = parser.doParse(inputStream);

            System.out.println("Abstract:" + em.abstractText);
            System.out.println("Abstract:" + em.getAbstractText());
            System.out.println("Source:" + em.getSource().name());
            System.out.println("Title:" + em.getTitle());
            System.out.println("Year" + em.getYear());
            System.out.println("Creator" + em.getCreator());
            List<String> authors = em.authors;
            for(String author: authors){
                System.out.println("Authors:" + author);
            }
            List<Section> sections = em.getSections();
            for(Section section: sections){
                System.out.println("Sections:" + section.getHeading());
            }
            List<BibRecord> references = em.getReferences();
            for(BibRecord reference:references){
                System.out.println("References:" + reference);
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
