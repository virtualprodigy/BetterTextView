package com.virtualprodigy.bettertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by virtualprodigyllc on 6/28/16.
 */

public class BetterTextView extends TextView {
    private boolean scaleWithinBounds;
    private String typefaceAsset;
    private Context context;
    private final String FONT_DIRECTORY = "fonts/";

    public BetterTextView(Context context) {
        super(context);
        init(context, null);
    }

    public BetterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BetterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * Initializes the BetterTextView
     * handles reading the custom attrs
     *
     * @param context
     */
    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.betterTextViewAttrs,
                0, 0);

        try {
            scaleWithinBounds = typedArray.getBoolean(R.styleable.betterTextViewAttrs_typefaceAsset, false);
            typefaceAsset = FONT_DIRECTORY + typedArray.getString(R.styleable.betterTextViewAttrs_typefaceAsset);
        } finally {
            typedArray.recycle();
        }

        setTypeface();
    }

    /**
     * Sets whether the TextView should scale to fit within its bounds
     *
     * @param scaleWithinBounds
     */
    public void setScaleWithinBounds(boolean scaleWithinBounds) {
        this.scaleWithinBounds = scaleWithinBounds;
    }

    /**
     * Allows the TypeFace to be set. Type faces are assumed to be stored in
     * assets/fonts so only the TTF files name is needed
     *
     * @param typefaceAsset - Name of the TTF file
     */
    public void setTypefaceAsset(String typefaceAsset) {
        this.typefaceAsset = FONT_DIRECTORY + typefaceAsset;
        setTypeface();
    }

    /**
     * Local method to call the parent set type face
     */
    private void setTypeface() {
        Typeface font = Typeface.createFromAsset(context.getAssets(), typefaceAsset);
        setTypeface(font);
    }
}
