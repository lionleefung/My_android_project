package com.example.lilingyun.firstpro;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RecycleAdapter_2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int ITEM_TYPE_HEADER=0;
    public static final int ITEM_TYPE_CONTENT=1;
    public static final int ITEM_TYPE_BOTTOM=2;
    //模拟数据
    //public String[] texts_weapon={"苗刀","双剑","板斧","飞镖","弓箭"};
    //public String[] texts_magic={"天火术","万木幽兰","哈哈哈","装死","跑为上策"};
    public String[] texts_armor={"骑士","刺客","皇上","加菲猫","小猪佩奇"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mWeaponCount=1;//头部View个数
    private int mMagicCount=1;//尾部View个数

    public RecycleAdapter_2(Context context){
        mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    //内容长度
    public  int getContentItemCount(){
        return texts_armor.length;
    }
    //判断当前item类型
    @Override
    public int getItemViewType(int position){
        int dataItemCount = getContentItemCount();
        if(mWeaponCount != 0 && position < mWeaponCount){
            //头部View
            return ITEM_TYPE_HEADER;
        }else if(mMagicCount != 0 && position >= (mMagicCount + dataItemCount)){
            //底部View
            return ITEM_TYPE_BOTTOM;
        } else {
            //内容View
            return ITEM_TYPE_CONTENT;
        }
    }
    //内容 ViewHolder
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private Button textView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.btn1);
        }
    }
    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {

            super(itemView);

        }
    }
    //底部 ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.weapon, parent, false));
        } else if (viewType == ITEM_TYPE_CONTENT) {
            return  new ContentViewHolder(mLayoutInflater.inflate(R.layout.armor, parent, false));
        } else if (viewType == ITEM_TYPE_BOTTOM) {
            return new BottomViewHolder(mLayoutInflater.inflate(R.layout.magic, parent, false));
        }
        return null;
    }

    @Override
    //将数据与界面绑定
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText(texts_armor[position - mWeaponCount]);
        } else if (holder instanceof BottomViewHolder) {
        }
    }
    @Override
    public int getItemCount() {
        return mWeaponCount + getContentItemCount() + mMagicCount;
    }
}


