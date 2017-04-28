package cuongvo.springwithfacebookrebound.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by cuongvo on 2/14/17.
 */

public class RecyclerViewUtil {
    public static RecyclerView.LayoutManager createVerticalLayoutManager(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context
                , LinearLayoutManager.VERTICAL
                , false);
        return layoutManager;
    }

    public static RecyclerView.LayoutManager createHorizontalLayoutManager(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context
                , LinearLayoutManager.HORIZONTAL
                , false);
        return layoutManager;
    }



    public static RecyclerView.LayoutManager createStagged(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        return staggeredGridLayoutManager;
    }
}
