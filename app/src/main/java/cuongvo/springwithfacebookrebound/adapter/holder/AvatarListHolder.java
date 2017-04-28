package cuongvo.springwithfacebookrebound.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import cuongvo.springwithfacebookrebound.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by cuongvo on 4/27/17.
 */

public class AvatarListHolder extends RecyclerView.ViewHolder {
    public CircleImageView mAvatar;

    public AvatarListHolder(View itemView) {
        super(itemView);

        mAvatar = (CircleImageView)itemView.findViewById(R.id.adapter_avatar_image);
    }
}
