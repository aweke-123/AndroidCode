package custom;

import android.app.ActionBar;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.anjali.chatapp.R;

/**
 * Created by anjali on 1/9/15.
 */
public class CustomActivity extends FragmentActivity implements View.OnClickListener {

    public static final TouchEffect TOUCH = new TouchEffect();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupActionBar();
    }

    //It will setup title bar and display
    protected void setupActionBar(){
        final ActionBar actionBar = getActionBar();
        if(actionBar == null)
            return;
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.drawable.logo_login);
        actionBar.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.actionbar_bg));
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    //sets touch and click listener
    public View setTouchNClick(int id){
        View v = setClick(id);
        if(v != null)
            v.setOnTouchListener(TOUCH);
        return v;
    }

    //set click listener
    public View setClick(int id){
        View v = findViewById(id);
        if(v != null)
            v.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v){

    }


}
