package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.cognitioco.drunkster.R;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {

    int xPos = 0;
    int yPos = 0;
    private Bitmap multiple;
    private Bitmap single;
    private Random random;
    private Context context;
    private GameListener selectionListener;
    private int width;
    private int height;
    private int[] viewCoord = new int[2];
    private OnTouchListener listener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            int touchX = (int) event.getX();
            int touchY = (int) event.getY();

            int imageX = touchX - xPos; // viewCoords[0] is the X coordinate
            int imageY = touchY - yPos;

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (touchX >= xPos && touchX < (xPos + single.getWidth())
                        && touchY >= yPos && touchY < (yPos + single.getHeight())) {
                    selectionListener.onUserSelection(true);
                    invalidate();
                    return true;
                } else {
                    invalidate();
                    selectionListener.onUserSelection(false);
                    return false;
                }
            }
            return false;
        }
    };

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

    public GameListener getSelectionListener() {
        return selectionListener;
    }

    public void setSelectionListener(GameListener selectionListener) {
        this.selectionListener = selectionListener;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int x) {
        this.xPos = x;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    private void init(AttributeSet attr) {


        multiple = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_martini);
        single = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_beerpint);
        setOnTouchListener(listener);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        width = getWidth();
        height = getHeight();

        int size = random.nextInt(100);

        for (int i = 0; i < size; i++) {
            canvas.drawBitmap(multiple, random.nextInt(width), random.nextInt(height), null);
        }

        xPos = random.nextInt(width);
        yPos = random.nextInt(height);

        canvas.drawBitmap(single, xPos, yPos, null);


    }


}
