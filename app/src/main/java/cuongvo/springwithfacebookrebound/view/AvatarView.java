package cuongvo.springwithfacebookrebound.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cuongvo.springwithfacebookrebound.R;
import cuongvo.springwithfacebookrebound.adapter.AvatarListAdapter;
import cuongvo.springwithfacebookrebound.data.AvatarData;
import cuongvo.springwithfacebookrebound.util.FontUtil;
import cuongvo.springwithfacebookrebound.util.RecyclerViewUtil;


/**
 * Created by cuongvo on 4/26/17.
 */

public class AvatarView extends LinearLayout {

    private Context mContext;
    private TextView mTitle;
    private RecyclerView mList;
    private AvatarListAdapter mAvatarListAdapter;

    public AvatarView(Context context) {
        super(context);
        init(context);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AvatarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        View view = inflate(mContext, R.layout.view_avatar, this);

        mTitle = (TextView) view.findViewById(R.id.view_avatar_title);
        mTitle.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NUNITO_BOLD));

        mList = (RecyclerView) view.findViewById(R.id.view_avatar_list);
        mList.setLayoutManager(RecyclerViewUtil.createHorizontalLayoutManager(mContext));
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setList(List<AvatarData> list) {
        mAvatarListAdapter = new AvatarListAdapter(mContext, list);
        mList.setAdapter(mAvatarListAdapter);
        mAvatarListAdapter.notifyDataSetChanged();
    }

    public void displayTitle(boolean display) {
        if (display) {
            mTitle.setVisibility(View.VISIBLE);
        } else {
            mTitle.setVisibility(View.GONE);
        }
    }

    public RecyclerView getList(){
        return this.mList;
    }
}
