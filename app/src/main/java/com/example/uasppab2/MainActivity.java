package com.example.uasppab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImgView;
    Bitmap mBitmap;
    Canvas mCanvas;
    private int mColorBackground;
    Paint mCirclePaint = new Paint();
    Paint mHeadPaint = new Paint();
    ObjectAnimator mFadeIn,mFadeOut,mRotation;

    private Rect mRect = new Rect();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgView = findViewById(R.id.myimageview);

        mCirclePaint.setColor(getResources().getColor(R.color.black));
        mHeadPaint.setColor(getResources().getColor(R.color.white));

        mRotation = ObjectAnimator.ofFloat(mImgView,"rotationY", 180);
        mFadeIn = ObjectAnimator.ofFloat(mImgView,"alpha",0,1f );
        mFadeOut = ObjectAnimator.ofFloat(mImgView,"alpha",1f,0 );
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int vWidth = mImgView.getWidth();
        int vHeight = mImgView.getHeight();

        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImgView.setImageBitmap(mBitmap);
        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(mColorBackground);

        drawHead(vWidth,vHeight);
        drawRightEye(vWidth,vHeight);
        drawLeftEye(vWidth,vHeight);
        drawEyeConnector(vWidth,vHeight);
        animatorFlip();

    }

    private void animatorFlip() {
        mFadeIn.setDuration(1000);
        mFadeIn.start();

        mRotation.setStartDelay(1000);
        mRotation.getStartDelay();
        mRotation.setDuration(4000);
        mRotation.start();

        mFadeOut.setStartDelay(5000);
        mFadeOut.getStartDelay();
        mFadeOut.setDuration(1000);
        mFadeOut.start();

    }

    private void drawEyeConnector(int Width, int Height) {
        mRect.set(Width/2-150,Height/2-10, Width/2+150, Height/2+10);
                mCanvas.drawRect(mRect, mCirclePaint);
    }

    private void drawLeftEye(int Width, int Height) {
        mCanvas.drawCircle(Width/2-150, Height/2, 50, mCirclePaint);
    }

    private void drawRightEye(int Width, int Height) {
        mCanvas.drawCircle(Width/2+150, Height/2, 50, mCirclePaint);
    }

    private void drawHead(int Width, int Height) {
        RectF ovalBounds = new RectF();
        ovalBounds.set(Width/2-300, Height/2-200, Width/2+300, Height/2+200);
        mCanvas.drawOval(ovalBounds,mHeadPaint);
    }





}