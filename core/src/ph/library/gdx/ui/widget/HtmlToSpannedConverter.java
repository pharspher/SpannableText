
package ph.library.gdx.ui.widget;

import java.io.IOException;
import java.io.StringReader;

import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.badlogic.gdx.Gdx;

public class HtmlToSpannedConverter implements ContentHandler {
	private HTMLSchema htmlSchema;
	private String text;

	public HtmlToSpannedConverter (String text) {
		this.htmlSchema = new HTMLSchema();
		this.text = text;
	}

	public SpannedString convert () {
		Parser parser = new Parser();
		parser.setContentHandler(this);

		try {
			parser.setProperty(Parser.schemaProperty, htmlSchema);
			parser.parse(new InputSource(new StringReader(text)));

		} catch (IOException | SAXException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void handleStartTag(String tag, Attributes attributes) {
		
	}

	public void handleEndTag(String tag) {
		
	}

	@Override
	public void startElement (String uri, String localName, String qName, Attributes atts) throws SAXException {
		handleStartTag(localName, atts);
	}

	@Override
	public void endElement (String uri, String localName, String qName) throws SAXException {
		handleEndTag(localName);
	}

	@Override
	public void characters (char[] ch, int start, int length) throws SAXException {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char c = ch[i + start];

			if (c == ' ' || c == '\n') {
				char pred;
				int len = sb.length();

				if (len == 0) {
					pred = '\n';

				} else {
					pred = sb.charAt(len - 1);
				}

				if (pred != ' ' && pred != '\n') {
					sb.append(' ');
				}
			} else {
				sb.append(c);
			}
		}
		Gdx.app.log("roger_tag", "characters: " + sb.toString());
	}

	@Override
	public void setDocumentLocator (Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument () throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endDocument () throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPrefixMapping (String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPrefixMapping (String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace (char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction (String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity (String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}
