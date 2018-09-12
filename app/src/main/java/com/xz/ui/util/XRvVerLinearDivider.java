package com.xz.ui.util;


import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import com.xz.ui.R;
import com.xz.ui.util.divider.Y_Divider;
import com.xz.ui.util.divider.Y_DividerBuilder;
import com.xz.ui.util.divider.Y_DividerItemDecoration;


/**
 * @author xcoder_xz
 * @date 8017/5/1 0001
 */

public class XRvVerLinearDivider extends Y_DividerItemDecoration {
    private Context mContext;
    private int mColor;
    private float mWidthDp;
    private float mStartPadding;
    private float mEndPadding;
    private boolean isShowTopLine;
    private Y_Divider divider1;
    private Y_Divider divider2;

    private XRvVerLinearDivider(Context context, int color, float widthDp, float startPadding, float endPadding, boolean isShowTopLine) {
        super(context);
        this.mColor = ContextCompat.getColor(context, color);
        this.mWidthDp = widthDp;
        this.mStartPadding = startPadding;
        this.mEndPadding = endPadding;
        this.isShowTopLine = isShowTopLine;
        this.mContext = context;
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        if (itemPosition == 0 && isShowTopLine) {
            if (divider1 == null) {
                divider1 = new Y_DividerBuilder()
                        .setTopSideLine(true, mColor, mWidthDp, mStartPadding, mEndPadding)
                        .setBottomSideLine(true, mColor, mWidthDp, mStartPadding, mEndPadding)
                        .create();
            }
            return divider1;
        } else {
            if (divider2 == null) {
                divider2 = new Y_DividerBuilder()
                        .setBottomSideLine(true, mColor, mWidthDp, mStartPadding, mEndPadding)
                        .create();
            }
            return divider2;
        }
    }


    public static class Builder {
        private int mColor;
        private float mWidthDp = 0.5f;
        private float mStartPadding = 0;
        private float mEndPadding = 0;
        private boolean isShowTopLine = false;
        private Context mContext;

        public Builder(Context context) {
            this.mContext = context;
            mColor = R.color.divider_color;
        }

        /**
         * 设置分割线颜色
         */
        public Builder setLineColorResoure(@ColorRes int color) {
            this.mColor = color;
            return this;
        }

        /**
         * 设置线条宽度/高度
         */
        public Builder setLineWidthDp(float widthDp) {
            this.mWidthDp = widthDp;
            return this;
        }

        /**
         * 设置开始边距
         */
        public Builder setStartPadding(float startPadding) {
            this.mStartPadding = startPadding;
            return this;
        }

        /**
         * 设置结束边距
         */
        public Builder setEndPadding(float endPadding) {
            this.mEndPadding = endPadding;
            return this;
        }

        public Builder setPadding(float startPadding, float endPadding) {
            this.mStartPadding = startPadding;
            this.mEndPadding = endPadding;
            return this;
        }

        /**
         * 是否显示第一行的分割线
         */
        public Builder setShowTopLine(boolean showTopLine) {
            this.isShowTopLine = showTopLine;
            return this;
        }

        public XRvVerLinearDivider build() {
            return new XRvVerLinearDivider(mContext, mColor, mWidthDp, mStartPadding, mEndPadding, isShowTopLine);
        }

    }
}