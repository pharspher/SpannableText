package ph.library.gdx.ui.widget;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpannableText extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	SpannedTextWidget mTextWidget;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		String text = "<color=\"#323232\"><b>Roger</b> is a <color=\"#121212\"><i>stupid</i></color> boy</color>";
		text = text.replaceAll("<color=", "<font color=").replaceAll("</color>", "</font>");

		Gdx.app.log("roger_tag", "text: " + text);

		HtmlToSpannedConverter converter = new HtmlToSpannedConverter(text);
		SpannedString spannedString = converter.convert();

		mTextWidget = new SpannedTextWidget(spannedString);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
