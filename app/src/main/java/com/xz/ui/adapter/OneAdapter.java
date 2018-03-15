package com.xz.ui.adapter;

import com.xz.ui.R;
import com.xz.ui.entity.OneEntity;
import com.xz.xadapter.XRvPureDataAdapter;
import com.xz.xadapter.xutil.XRvViewHolder;

/**
 * Created by DEV on 2018/3/15.
 */

public class OneAdapter extends XRvPureDataAdapter<OneEntity> {
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
        switch (getItem(position).getItemTag()) {
            case ITEM_HEAD:
                return R.layout.item_one_head;
            case ITEM_TITLE:
                return R.layout.item_one_title;
            case ITEM_GRID_1:
                return R.layout.item_one_grid_1;
            case ITEM_GRID_2:
                return R.layout.item_one_grid_2;
            case ITEM_GRID_3:
                return R.layout.item_one_grid_3;
            default:
                break;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemLayout(int viewType) {
        return viewType;
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {
        OneEntity one = mDatas.get(position);
        switch (getItem(position).getItemTag()) {
            case ITEM_HEAD:
                holder.setText(R.id.ioh_tv1, one.getOneHead().getTv1Txt());
                holder.setText(R.id.ioh_tv2, one.getOneHead().getTv2Txt());
                holder.setText(R.id.ioh_tv3, one.getOneHead().getTv3Txt());
                holder.setText(R.id.ioh_tv4, one.getOneHead().getTv4Txt());
                break;
            case ITEM_TITLE:
                holder.setText(R.id.iot_txt, one.getOneTitle().getTxt());
                break;
            case ITEM_GRID_1:
                holder.setText(R.id.iog1_txt, one.getOneGrid1().getTxt());
                break;
            case ITEM_GRID_2:
                holder.setText(R.id.iog2_txt, one.getOneGrid2().getTxt());
                break;
            case ITEM_GRID_3:
                holder.setText(R.id.iog3_txt, one.getOneGrid3().getTxt());
                break;
            default:
                break;
        }
    }
}
