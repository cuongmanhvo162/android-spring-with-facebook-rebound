package cuongvo.springwithfacebookrebound.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

import java.util.List;

import cuongvo.springwithfacebookrebound.R;
import cuongvo.springwithfacebookrebound.adapter.holder.AvatarListHolder;
import cuongvo.springwithfacebookrebound.data.AvatarData;


/**
 * Created by cuongvo on 4/27/17.
 */

public class AvatarListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AvatarData> mList;

    private SpringSystem mSpringSystem;
    private Spring mSpring;

    public AvatarListAdapter(Context context, List<AvatarData> list) {
        this.mContext = context;
        this.mList = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        LayoutInflater inflaterMainCategory = (LayoutInflater) parent
                .getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflaterMainCategory.inflate(R.layout.adapter_avatar_list, parent, false);

        AvatarListHolder avatarListHolder = new AvatarListHolder(view);

        return avatarListHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mSpringSystem = SpringSystem.create();

        AvatarData avatarData = mList.get(position);
        final AvatarListHolder avatarListHolder = (AvatarListHolder) holder;

        Log.d("AvatarAdapter", "scale x " + avatarListHolder.mAvatar.getScaleX());
        Log.d("AvatarAdapter", "scale y " + avatarListHolder.mAvatar.getScaleY());

        avatarListHolder.mAvatar.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mSpring = mSpringSystem.createSpring();
                        mSpring.addListener(new SpringListener() {
                            @Override
                            public void onSpringUpdate(Spring spring) {
                                float scale = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 1, 0.5);
                                avatarListHolder.mAvatar.setScaleX(scale);
                                avatarListHolder.mAvatar.setScaleY(scale);
                            }

                            @Override
                            public void onSpringAtRest(Spring spring) {

                            }

                            @Override
                            public void onSpringActivate(Spring spring) {

                            }

                            @Override
                            public void onSpringEndStateChange(Spring spring) {

                            }
                        });
                        mSpring.setEndValue(1);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        mSpring.setEndValue(0);
//                        mSpring.destroy();
                        break;
                }
                return true;
            }
        });

        if (!TextUtils.isEmpty(avatarData.getImageUrl())) {
            Glide.with(mContext).load(avatarData
                    .getImageUrl())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(avatarListHolder.mAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
