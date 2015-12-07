/**
 * Created by sudhanshu on 06/12/15.
 */

import de.l3s.boilerpipe.extractors.ArticleExtractor;
import java.net.URL;


import de.l3s.boilerpipe.document.TextDocument;

import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;


public class HtmlContentExtractor {
    String contentFromHTML;

    public String content(String url) {
        try {
            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(url));
            final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            String title = doc.getTitle();

            String contentFromHTML = ArticleExtractor.INSTANCE.getText(doc);
//            System.out.println(contentFromHTML);
            return contentFromHTML;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
