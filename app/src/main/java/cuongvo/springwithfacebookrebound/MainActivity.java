package cuongvo.springwithfacebookrebound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cuongvo.springwithfacebookrebound.util.AvatarUtil;
import cuongvo.springwithfacebookrebound.util.RecycleViewOnItemTouchListener;
import cuongvo.springwithfacebookrebound.view.AvatarView;

public class MainActivity extends AppCompatActivity {
    private AvatarView mAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAvatarView = (AvatarView) findViewById(R.id.avatar_list_view);
        mAvatarView.setTitle("Favorite");
        mAvatarView.setList(AvatarUtil.createAvatarList());
        mAvatarView.getList().addOnItemTouchListener(new RecycleViewOnItemTouchListener(this, new RecycleViewOnItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean pressReleased) {
                if (pressReleased) {

                }
            }
        }));
    }


}
