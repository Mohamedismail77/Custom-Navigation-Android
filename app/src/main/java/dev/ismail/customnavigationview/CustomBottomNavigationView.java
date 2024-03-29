package dev.ismail.customnavigationview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;


public class CustomBottomNavigationView extends BottomNavigationView {

    private Path mPath;
    private Paint mPaint;
    private Point mFirstCurveStartPoint = new Point();
    private Point mFirstCurveEndPoint = new Point();
    private Point mFirstCurveControlPoint1 = new Point();
    private Point mFirstCurveControlPoint2 = new Point();

    //the coordinates of the second curve
    @SuppressWarnings("FieldCanBeLocal")
    private Point mSecondCurveStartPoint = new Point();
    private Point mSecondCurveEndPoint = new Point();
    private Point mSecondCurveControlPoint1 = new Point();
    private Point mSecondCurveControlPoint2 = new Point();
    private int mNavigationBarWidth;
    private int mNavigationBarHeight;
    private int CURVE_CIRCLE_RADIUS = 125/2;

    public CustomBottomNavigationView(Context context) {
        super(context);
        init();
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.RED);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        /*mNavigationBarWidth = getWidth();
        mNavigationBarHeight = getHeight();
        // the coordinates (x,y) of the start point before curve
        mFirstCurveStartPoint.set((mNavigationBarWidth / 2) - (CURVE_CIRCLE_RADIUS * 2) - (CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        mFirstCurveEndPoint.set(mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        mSecondCurveStartPoint = mFirstCurveEndPoint;
        mSecondCurveEndPoint.set((mNavigationBarWidth / 2) + (CURVE_CIRCLE_RADIUS * 2) + (CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
        mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);

        mPath.reset();
        mPath.moveTo(0, 0);
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y);

        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);

        mPath.lineTo(mNavigationBarWidth, 0);
        mPath.lineTo(mNavigationBarWidth, mNavigationBarHeight);
        mPath.lineTo(0, mNavigationBarHeight);*/


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mNavigationBarWidth = getWidth();
        mNavigationBarHeight = getHeight();
        switch (getSelectedItemId()){
            case R.id.homw:
                // the coordinates (x,y) of the start point before curve
                mFirstCurveStartPoint.set(0, 0);
                // the coordinates (x,y) of the end point after curve
                mFirstCurveEndPoint.set(mNavigationBarWidth / 10, mNavigationBarHeight);
                // same thing for the second curve
                mSecondCurveStartPoint = mFirstCurveEndPoint;
                mSecondCurveEndPoint.set((mNavigationBarWidth / 5), 0);

                // the coordinates (x,y)  of the 1st control point on a cubic curve
                mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
                // the coordinates (x,y)  of the 2nd control point on a cubic curve
                mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

                mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
                mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
                break;


            case R.id.gg:
                // the coordinates (x,y) of the start point before curve
                mFirstCurveStartPoint.set((mNavigationBarWidth / 5), 0);
                // the coordinates (x,y) of the end point after curve
                mFirstCurveEndPoint.set(mNavigationBarWidth*3 / 10, mNavigationBarHeight);
                // same thing for the second curve
                mSecondCurveStartPoint = mFirstCurveEndPoint;
                mSecondCurveEndPoint.set((mNavigationBarWidth*2 / 5), 0);

                // the coordinates (x,y)  of the 1st control point on a cubic curve
                mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
                // the coordinates (x,y)  of the 2nd control point on a cubic curve
                mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

                mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
                mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
                break;
            case R.id.da:
                mFirstCurveStartPoint.set((mNavigationBarWidth*2 / 5), 0);
                // the coordinates (x,y) of the end point after curve
                mFirstCurveEndPoint.set(mNavigationBarWidth / 2, mNavigationBarHeight);
                // same thing for the second curve
                mSecondCurveStartPoint = mFirstCurveEndPoint;
                mSecondCurveEndPoint.set(mNavigationBarWidth*6/10, 0);

                // the coordinates (x,y)  of the 1st control point on a cubic curve
                mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
                // the coordinates (x,y)  of the 2nd control point on a cubic curve
                mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

                mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
                mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
                break;

            case R.id.pf:
                mFirstCurveStartPoint.set((mNavigationBarWidth*6 / 10), 0);
                // the coordinates (x,y) of the end point after curve
                mFirstCurveEndPoint.set(mNavigationBarWidth*7 / 10, mNavigationBarHeight);
                // same thing for the second curve
                mSecondCurveStartPoint = mFirstCurveEndPoint;
                mSecondCurveEndPoint.set(mNavigationBarWidth*8/10, 0);

                // the coordinates (x,y)  of the 1st control point on a cubic curve
                mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
                // the coordinates (x,y)  of the 2nd control point on a cubic curve
                mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

                mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
                mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
                break;

            case R.id.pa:
                mFirstCurveStartPoint.set((mNavigationBarWidth*8 / 10), 0);
                // the coordinates (x,y) of the end point after curve
                mFirstCurveEndPoint.set(mNavigationBarWidth*9 / 10, mNavigationBarHeight);
                // same thing for the second curve
                mSecondCurveStartPoint = mFirstCurveEndPoint;
                mSecondCurveEndPoint.set(mNavigationBarWidth, 0);

                // the coordinates (x,y)  of the 1st control point on a cubic curve
                mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
                // the coordinates (x,y)  of the 2nd control point on a cubic curve
                mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

                mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
                mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
                break;
        }



        mPath.reset();
        mPath.moveTo(0, 0);
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y);

        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);

        mPath.lineTo(mNavigationBarWidth, 0);
        mPath.lineTo(mNavigationBarWidth, mNavigationBarHeight);
        mPath.lineTo(0, mNavigationBarHeight);
        canvas.drawPath(mPath, mPaint);
    }




}
