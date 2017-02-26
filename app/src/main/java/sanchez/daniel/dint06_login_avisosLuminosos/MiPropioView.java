package sanchez.daniel.dint06_login_avisosLuminosos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by daniel.rodriguez on 11/01/2017.
 */
public class MiPropioView extends View {
    public boolean loginCorrecto;

    public void eliminarCirculo (Boolean loginCorrecto) {
        this.loginCorrecto = loginCorrecto;
        invalidate(); //Necesario para que no de fallo el boolean
    }

    public MiPropioView(Context context) {
        super(context);
    }
    public MiPropioView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MiPropioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setStrokeWidth(5);

        if (loginCorrecto) {
            paint.setColor(Color.GREEN);
            canvas.drawCircle(25, 25, 25, paint);
            paint.setColor(Color.TRANSPARENT);
            canvas.drawCircle(80, 25, 25, paint);
        } else {
            paint.setColor(Color.TRANSPARENT);
            canvas.drawCircle(25, 25, 25, paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(80, 25, 25, paint);
        }
    }

    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = 150;
        int heigth = 50;

        switch(widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
                if(width > widthSize) {
                    width = widthSize;
                }
                break;
        }
        switch(heightMode) {
            case MeasureSpec.EXACTLY:
                heigth = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                if(heigth > heightSize) {
                    heigth = heightSize;
                }
                break;
        }
        this.setMeasuredDimension(width, heigth);
    }
}