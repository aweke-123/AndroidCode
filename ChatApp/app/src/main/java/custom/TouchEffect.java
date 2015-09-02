package custom;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anjali on 1/9/15.
 */
public class TouchEffect implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v , MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Drawable d = v.getBackground();
            d.mutate();
            d.setAlpha(150);
            v.setBackgroundDrawable(d);
        }
        return false;
    }

}
