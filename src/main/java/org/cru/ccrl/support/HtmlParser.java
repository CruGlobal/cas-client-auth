package org.cru.ccrl.support;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * author@lee.braddock
 */
public class HtmlParser
{
    private String html;

    public HtmlParser(String html)
    {
        this.html = html;
    }

    public String getTgt() throws HtmlParserException
    {
        Document doc = Jsoup.parse(html);

        Elements elements = doc.getElementsByTag("form");

        if(elements.size() < 1)
        {
            throw new HtmlParserException("Could not get tgt");
        }

        Element element = elements.get(0);

        String action = element.attr("action");

        return action.substring(action.lastIndexOf("TGT"));
    }
}
