package com.xz.ui.fragment.flowlayout;

import android.widget.TextView;

import com.xz.ui.R;
import com.xz.xadapter.XRvPureDataAdapter;
import com.xz.xadapter.xutil.XRvViewHolder;

public class FlowLayoutAdapter extends XRvPureDataAdapter<FlowLayoutEntity>{
    private static final int ITEM_TITLE_CODE = 123;

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isBigType) {
            return ITEM_TITLE_CODE;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getItemLayout(int viewType) {
        if (viewType == ITEM_TITLE_CODE) {
            return R.layout.item_flow_layout_title;
        } else {
            return R.layout.item_flow_layout;
        }
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {
        if (getItem(position).isBigType) {
            TextView titleTv = holder.getView(R.id.iflt_title_tv);
            titleTv.setText(getItem(position).name);
        } else {
            TextView typeTv = holder.getView(R.id.iflt_tv);
            typeTv.setText(getItem(position).name);
//            ViewGroup.LayoutParams lp = typeTv.getLayoutParams();
//            if (lp instanceof FlexboxLayoutManager.LayoutParams) {
//                FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) typeTv.getLayoutParams();
//                flexboxLp.setFlexGrow(1.0f);
//            }
        }
    }
}
