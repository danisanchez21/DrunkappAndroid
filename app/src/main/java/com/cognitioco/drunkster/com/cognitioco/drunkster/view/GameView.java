package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.cognitioco.drunkster.R;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {

    private Bitmap multiple;
    private Bitmap single;
    private Random random;
    private Context context;


    public GameView(Context context) {
        super(context);
        random = new Random();
        this.context = context;

        init(null);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        random = new Random();
        this.context = context;
        init(attrs);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        random = new Random();
        init(attrs);
    }

    private void init(AttributeSet attr) {

        multiple = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_martini);
        single = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_beerpint);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < 40; i++) {
            canvas.drawBitmap(multiple, random.nextInt(getWidth()), random.nextInt(getHeight()), null);
        }

        canvas.drawBitmap(single, random.nextInt(getWidth()), random.nextInt(getHeight()), null);
    }

}
