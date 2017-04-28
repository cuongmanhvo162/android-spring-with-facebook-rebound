package cuongvo.springwithfacebookrebound.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by cuongvo on 10/19/16.
 */

public class FontUtil {
    public static final String NUNITO_REGULAR = "nunito_regular.ttf";
    public static final String NUNITO_BOLD = "nunito_bold.ttf";

    public static Typeface getTypeface(Context context, String fontName) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/".concat(fontName));
        return font;
    }
}
