package com.xz.ui.fragment.one;

import com.xz.ui.R;
import com.xz.ui.fragment.one.entity.OneGrid1Entity;
import com.xz.ui.fragment.one.entity.OneGrid2Entity;
import com.xz.ui.fragment.one.entity.OneGrid3Entity;
import com.xz.ui.fragment.one.entity.OneHeadEntity;
import com.xz.ui.fragment.one.entity.OneTitleEntity;
import com.xz.xadapter.XRvPureDataAdapter;
import com.xz.xadapter.xutil.XRvViewHolder;

/**
 * Created by DEV on 2018/3/15.
 */

public class OneAdapter extends XRvPureDataAdapter<Object> {
    /**
     * 头部
     */
    public static final int ITEM_HEAD = 111;
    /**
     * 标题
     */
    public static final int ITEM_TITLE = 112;
    /**
     * 一行一个=个的标识
     */
    public static final int ITEM_GRID_1 = 113;
    /**
     * 一行两个的标识
     */
    public static final int ITEM_GRID_2 = 114;
    /**
     * 一行三个的标识
     */
    public static final int ITEM_GRID_3 = 115;

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position) instanceof OneHeadEntity) {
            return ITEM_HEAD;
        } else if (mDatas.get(position) instanceof OneTitleEntity) {
            return ITEM_TITLE;
        } else if (mDatas.get(position) instanceof OneGrid1Entity) {
            return ITEM_GRID_1;
        } else if (mDatas.get(position) instanceof OneGrid2Entity) {
            return ITEM_GRID_2;
        } else if (mDatas.get(position) instanceof OneGrid3Entity) {
            return ITEM_GRID_3;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getItemLayout(int viewType) {
        if (viewType == ITEM_HEAD) {
            return R.layout.item_one_head;
        } else if (viewType == ITEM_TITLE) {
            return R.layout.item_one_title;
        } else if (viewType == ITEM_GRID_1) {
            return R.layout.item_one_grid_1;
        } else if (viewType == ITEM_GRID_2) {
            return R.layout.item_one_grid_2;
        } else if (viewType == ITEM_GRID_3) {
            return R.layout.item_one_grid_3;
        } else {
            return viewType;
        }
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case ITEM_HEAD:
                OneHeadEntity head = (OneHeadEntity) mDatas.get(position);
                holder.setText(R.id.ioh_tv1, head.getTv1Txt());
                holder.setText(R.id.ioh_tv2, head.getTv2Txt());
                holder.setText(R.id.ioh_tv3, head.getTv3Txt());
                holder.setText(R.id.ioh_tv4, head.getTv4Txt());
                break;
            case ITEM_TITLE:
                OneTitleEntity title = (OneTitleEntity) mDatas.get(position);
                holder.setText(R.id.iot_txt, title.getTxt());
                break;
            case ITEM_GRID_1:
                OneGrid1Entity grid1 = (OneGrid1Entity) mDatas.get(position);
                holder.setText(R.id.iog1_txt, grid1.getTxt());
                break;
            case ITEM_GRID_2:
                OneGrid2Entity grid2 = (OneGrid2Entity) mDatas.get(position);
                holder.setText(R.id.iog2_txt, grid2.getTxt());
                break;
            case ITEM_GRID_3:
                OneGrid3Entity grid3 = (OneGrid3Entity) mDatas.get(position);
                holder.setText(R.id.iog3_txt, grid3.getTxt());
                break;
            default:
                break;
        }
    }
}
