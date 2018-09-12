package com.xz.ui.fragment.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.xz.ui.R;
import com.xz.ui.util.GsonUtil;
import com.xz.ui.util.ToastUtil;
import com.xz.xadapter.XRvPureAdapter;

import java.util.ArrayList;
import java.util.List;

public class FlowLayoutFragment extends Fragment {

    private FlowLayoutAdapter mAdapter;

    public static FlowLayoutFragment newInstance() {

        Bundle args = new Bundle();

        FlowLayoutFragment fragment = new FlowLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View contentView = inflater.inflate(R.layout.fragment_flow_layout, container, false);
        initView(contentView);
        initData();
        return contentView;
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.ffl_rv);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        //设置主轴排列方式
        layoutManager.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        //居左对齐
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new FlowLayoutAdapter();

        mAdapter.setOnItemClickListener(new XRvPureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastUtil.show(mAdapter.getItem(position).name);

                if (!mAdapter.getItem(position).isBigType) {
                    //只获取 小分类名
                }
            }
        });

        recyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        //json 建议复制到json格式转化的网站上看看一个格式
        String jsonData="{\"data\":[{\"id\":1,\"name\":\"年代\",\"tags\":[\"先秦\", \"汉朝\", \"魏晋\", \"南北朝\", \"隋朝\", \"唐朝\", \"宋朝\", \"金朝\", \"辽朝\", \"元朝\", \"明朝\", \"清朝\", \"近当代\", \"五代\"]}, {\"id\":2,\"name\":\"教材同步\",\"tags\":[\"小学一年级\", \"小学二年级\", \"小学三年级\", \"小学四年级\", \"小学五年级\", \"小学六年级\", \"初中一年级\", \"初中二年级\", \"初中三年级\"]}, {\"id\":3,\"name\":\"语种\",\"tags\":[\"中文诗\", \"外文诗\"]}],\"code\":0}\n";
        FlowLayoutJsonDto flowLayoutJsonDto = GsonUtil.jsonStringToObject(jsonData, FlowLayoutJsonDto.class);
        List<CategoriesDTO> datas = flowLayoutJsonDto.getData();
        //这里处理通用的一种 大分类，小分类数据,
        //把数据分类好，大分类标记好
        List<FlowLayoutEntity> lists = new ArrayList<>();
        if (datas != null && datas.size() > 0) {
            for (CategoriesDTO cd : datas) {
                //大分类
                lists.add(new FlowLayoutEntity(true, cd.getName()));
                for (String minType : cd.getTags()) {
                    lists.add(new FlowLayoutEntity(false, minType));
                }
            }
        }
        mAdapter.setDatas(lists, true);
    }
}
