package com.xz.ui.divider;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.xz.ui.R;
import com.xz.ui.adapter.OneAdapter;
import com.xz.ui.entity.OneEntity;

import java.util.List;


/**
 * @author xz
 * @date 2018/2/6
 * 活动视频列表的分割线
 */

public class OneDivider extends Y_DividerItemDecoration {

    private final int mColor;
    private Y_Divider none;
    private List<OneEntity> mLists;
    private Y_Divider d1;
    /**
     * 一排两列左边
     */
    private Y_Divider d2l;
    /**
     * 一排两列右边
     */
    private Y_Divider d2r;


    private int d2Tag=-1;

    /**
     * 一排三列的中间
     */
    private Y_Divider d3c;
    private int d3Tag=-1;

    public OneDivider(Context context, List<OneEntity> lists) {
        super(context);
        mLists = lists;
        mColor = ContextCompat.getColor(context, R.color.colorAccent);
        none = new Y_DividerBuilder().create();
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        switch (mLists.get(itemPosition).getItemTag()) {
            case OneAdapter.ITEM_HEAD:
                if (d1 == null) {
                    d1 = new Y_DividerBuilder()
                            .setBottomSideLine(true, mColor, 2, 0, 0)
                            .create();
                }
                return d1;
            case OneAdapter.ITEM_TITLE:
                if (d1 == null) {
                    d1 = new Y_DividerBuilder()
                            .setBottomSideLine(true, mColor, 2, 0, 0)
                            .create();
                }
                return d1;
            case OneAdapter.ITEM_GRID_1:
                if (d1 == null) {
                    d1 = new Y_DividerBuilder()
                            .setBottomSideLine(true, mColor, 2, 0, 0)
                            .create();
                }
                return d1;
            case OneAdapter.ITEM_GRID_2:
                //如果上一个是title，就标记一次，记录此时的下标
                if(mLists.get(itemPosition-1).getItemTag()==OneAdapter.ITEM_TITLE)    {
                    d2Tag=itemPosition;
                }
                //当前position减去一排两列第一个的position再%2,判断分割线
                if((itemPosition-d2Tag)%2==0){
                    if (d2l == null) {
                        d2l = new Y_DividerBuilder()
                                .setBottomSideLine(true, mColor, 2, 0, 0)
                                .setRightSideLine(true, mColor, 1, 0, 0)
                                .create();
                    }
                    return d2l;
                }else{
                    if (d2r == null) {
                        d2r = new Y_DividerBuilder()
                                .setBottomSideLine(true, mColor, 2, 0, 0)
                                .setLeftSideLine(true, mColor, 1, 0, 0)
                                .create();
                    }
                    return d2r;
                }

            case OneAdapter.ITEM_GRID_3:
                //如果上一个是title，就标记一次，记录此时的下标
                if(mLists.get(itemPosition-1).getItemTag()==OneAdapter.ITEM_TITLE)    {
                    d3Tag=itemPosition;
                }
              //当前position减去一排两列第一个的position再%2,判断分割线
                if((itemPosition-d3Tag)%3==0){
                    if (d2l == null) {
                        d2l = new Y_DividerBuilder()
                                .setBottomSideLine(true, mColor, 2, 0, 0)
                                .setRightSideLine(true, mColor, 1, 0, 0)
                                .create();
                    }
                    return d2l;
                }else if((itemPosition-d3Tag)%3==1){
                    if (d3c == null) {
                        d3c = new Y_DividerBuilder()
                                .setRightSideLine(true, mColor, 1, 0, 0)
                                .setBottomSideLine(true, mColor, 2, 0, 0)
                                .setLeftSideLine(true, mColor, 1, 0, 0)
                                .create();
                    }
                    return d3c;
                }else{
                    if (d2r == null) {
                        d2r = new Y_DividerBuilder()
                                .setBottomSideLine(true, mColor, 2, 0, 0)
                                .setLeftSideLine(true, mColor, 1, 0, 0)
                                .create();
                    }
                    return d2r;
                }
            default:
                return none;
        }
    }
}
