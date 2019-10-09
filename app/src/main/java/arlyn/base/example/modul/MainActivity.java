package arlyn.base.example.modul;

import androidx.appcompat.app.AppCompatActivity;
import arlyn.base.example.R;
import arlyn.playground.base.BaseFragmentHolderActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseFragmentHolderActivity {
    MainFragment mainFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.logo_pens_putih);
        ivIcon.setVisibility(View.VISIBLE);
        mainFragment = new MainFragment();
        setCurrentFragment(mainFragment, false);

    }

}