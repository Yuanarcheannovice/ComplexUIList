package com.xz.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xz.ui.R;
import com.xz.ui.adapter.OneAdapter;
import com.xz.ui.divider.OneDivider;
import com.xz.ui.entity.OneEntity;
import com.xz.ui.entity.OneGrid1Entity;
import com.xz.ui.entity.OneGrid2Entity;
import com.xz.ui.entity.OneGrid3Entity;
import com.xz.ui.entity.OneHeadEntity;
import com.xz.ui.entity.OneTitleEntity;

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
                OneEntity item = mAdapter.getItem(position);
                switch (item.getItemTag()) {
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
        recyclerView.addItemDecoration(new OneDivider(getContext(),mAdapter.getDatas()));
        recyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        //数据需要做处理，按照顺序排列
        //每个对应实体，都需要给上标识
        List<OneEntity> lists = new ArrayList<>();
        //head------------------------
        OneEntity oneHeadE = new OneEntity();
        oneHeadE.setItemTag(OneAdapter.ITEM_HEAD);
        OneHeadEntity oneHeadEntity = new OneHeadEntity();
        oneHeadEntity.setTv1Txt("啤酒");
        oneHeadEntity.setTv2Txt("白酒");
        oneHeadEntity.setTv3Txt("红酒");
        oneHeadEntity.setTv4Txt("鸡尾酒");
        oneHeadE.setOneHead(oneHeadEntity);
        lists.add(oneHeadE);
        //每日精选title--------------------------
        OneEntity oneTitleSe = new OneEntity();
        oneTitleSe.setItemTag(OneAdapter.ITEM_TITLE);
        oneTitleSe.setOneTitle(new OneTitleEntity("每日精选"));
        lists.add(oneTitleSe);
        //每日精选item(3列)
        //1
        OneEntity oneGr31 = new OneEntity();
        oneGr31.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr31.setOneGrid3(new OneGrid3Entity("鸡腿"));
        lists.add(oneGr31);
        //2
        OneEntity oneGr32 = new OneEntity();
        oneGr32.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr32.setOneGrid3(new OneGrid3Entity("鸭腿"));
        lists.add(oneGr32);
        //3
        OneEntity oneGr33 = new OneEntity();
        oneGr33.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr33.setOneGrid3(new OneGrid3Entity("狗腿"));
        lists.add(oneGr33);
        //4
        OneEntity oneGr34 = new OneEntity();
        oneGr34.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr34.setOneGrid3(new OneGrid3Entity("猪腿"));
        lists.add(oneGr34);
        //5
        OneEntity oneGr35 = new OneEntity();
        oneGr35.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr35.setOneGrid3(new OneGrid3Entity("牛腿"));
        lists.add(oneGr35);
        //6
        OneEntity oneGr36 = new OneEntity();
        oneGr36.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr36.setOneGrid3(new OneGrid3Entity("鹅腿"));
        lists.add(oneGr36);
        //7
        OneEntity oneGr37 = new OneEntity();
        oneGr37.setItemTag(OneAdapter.ITEM_GRID_3);
        oneGr37.setOneGrid3(new OneGrid3Entity("兔腿"));
        lists.add(oneGr37);
        //当前推荐title------------------------------
        OneEntity oneTitleRe = new OneEntity();
        oneTitleRe.setItemTag(OneAdapter.ITEM_TITLE);
        oneTitleRe.setOneTitle(new OneTitleEntity("当前推荐"));
        lists.add(oneTitleRe);
        //当前推荐tiem (grid2)
        //1
        OneEntity oneGr21 = new OneEntity();
        oneGr21.setItemTag(OneAdapter.ITEM_GRID_2);
        oneGr21.setOneGrid2(new OneGrid2Entity("鸡翅"));
        lists.add(oneGr21);
        //2
        OneEntity oneGr22 = new OneEntity();
        oneGr22.setItemTag(OneAdapter.ITEM_GRID_2);
        oneGr22.setOneGrid2(new OneGrid2Entity("鸭翅"));
        lists.add(oneGr22);
        //3
        OneEntity oneGr23 = new OneEntity();
        oneGr23.setItemTag(OneAdapter.ITEM_GRID_2);
        oneGr23.setOneGrid2(new OneGrid2Entity("鹅翅"));
        lists.add(oneGr23);

        //更多推荐title------------------------------
        OneEntity oneTitleMo = new OneEntity();
        oneTitleMo.setItemTag(OneAdapter.ITEM_TITLE);
        oneTitleMo.setOneTitle(new OneTitleEntity("更多推荐"));
        lists.add(oneTitleMo);
        //更多推荐tiem (grid1)
        //1
        OneEntity oneGr11 = new OneEntity();
        oneGr11.setItemTag(OneAdapter.ITEM_GRID_1);
        oneGr11.setOneGrid1(new OneGrid1Entity("烧烤"));
        lists.add(oneGr11);
        //2
        OneEntity oneGr12 = new OneEntity();
        oneGr12.setItemTag(OneAdapter.ITEM_GRID_1);
        oneGr12.setOneGrid1(new OneGrid1Entity("火锅"));
        lists.add(oneGr12);

        mAdapter.setDatas(lists, true);
    }

}
