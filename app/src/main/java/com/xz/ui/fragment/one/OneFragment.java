package com.xz.ui.fragment.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xz.ui.R;
import com.xz.ui.util.OneDivider;
import com.xz.ui.fragment.one.entity.OneGrid1Entity;
import com.xz.ui.fragment.one.entity.OneGrid2Entity;
import com.xz.ui.fragment.one.entity.OneGrid3Entity;
import com.xz.ui.fragment.one.entity.OneHeadEntity;
import com.xz.ui.fragment.one.entity.OneTitleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV on 2018/3/15.
 */

public class OneFragment extends Fragment {

    private OneAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View contentView = inflater.inflate(R.layout.fragment_one, container, false);
        initView(contentView);
        initData();
        return contentView;
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.fo_rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        //控制每行条目（根据UI的最大行数）
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mAdapter.getItemViewType(position)) {
                    case OneAdapter.ITEM_HEAD:
                        return 6;
                    case OneAdapter.ITEM_TITLE:
                        return 6;
                    case OneAdapter.ITEM_GRID_1:
                        return 6;
                    case OneAdapter.ITEM_GRID_2:
                        return 3;
                    case OneAdapter.ITEM_GRID_3:
                        return 2;
                    default:
                        return 6;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new OneAdapter();
        //这里使用的是自动的分割线，如果嫌麻烦或者看不懂，可以直接在item的layout加分割线
        recyclerView.addItemDecoration(new OneDivider(getContext(),mAdapter));
        recyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        //数据需要做处理，按照Ui顺序排列
        List<Object> lists = new ArrayList<>();
        //head------------------------
        OneHeadEntity oneHeadEntity = new OneHeadEntity();
        oneHeadEntity.setTv1Txt("啤酒");
        oneHeadEntity.setTv2Txt("白酒");
        oneHeadEntity.setTv3Txt("红酒");
        oneHeadEntity.setTv4Txt("鸡尾酒");
        lists.add(oneHeadEntity);
        //每日精选title--------------------------
        lists.add(new OneTitleEntity("每日精选"));
        //每日精选item(3列)
        //1
        lists.add(new OneGrid3Entity("鸡腿"));
        //2
        lists.add(new OneGrid3Entity("鸭腿"));
        //3
        lists.add(new OneGrid3Entity("狗腿"));
        //4
        lists.add(new OneGrid3Entity("猪腿"));
        //5
        lists.add(new OneGrid3Entity("牛腿"));
        //6
        lists.add(new OneGrid3Entity("鹅腿"));
        //7
        lists.add(new OneGrid3Entity("兔腿"));
        //当前推荐title------------------------------
        lists.add(new OneTitleEntity("当前推荐"));
        //当前推荐tiem (grid2)
        //1
        lists.add(new OneGrid2Entity("鸡翅"));
        //2
        lists.add(new OneGrid2Entity("鸭翅"));
        //3
        lists.add(new OneGrid2Entity("鹅翅"));

        //更多推荐title------------------------------
        lists.add(new OneTitleEntity("更多推荐"));
        //更多推荐tiem (grid1)
        //1
        lists.add(new OneGrid1Entity("烧烤"));
        //2
        lists.add(new OneGrid1Entity("火锅"));

        mAdapter.setDatas(lists, true);
    }

}
