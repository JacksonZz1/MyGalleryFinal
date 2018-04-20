package cn.finalteam.galleryfinal.sample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyasong
 * @date 28/09/2017 14:27
 * @description 创建GridView的Adapter
 */
public class GridViewAdapter extends BaseAdapter {

    private ArrayList<String> imgList;
    private Context context;
    private final LayoutInflater mInflater;

    public GridViewAdapter(Context context, ArrayList<String> imgList) {
        this.context = context;
        this.imgList = imgList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        //因为最后多了一个添加图片的ImageView
        int count = imgList == null ? 1 : imgList.size() + 1;
        if (count > Constants.MAX_SELECT_PIV_NUM) {
            //如果选择的图片数量超过了9张 则将最后的添加照片的按钮隐藏
            return imgList.size();
        } else {
            return count;
        }
    }

    @Override
    public Object getItem(int position) {
        return imgList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_item, parent, false);
        }
        ImageView iv_item = (ImageView) convertView.findViewById(R.id.pic_iv);
        if (position < imgList.size()) {
            //表示+号之前需要显示正常的图片
            String picUrl = imgList.get(position);
            Glide.with(context).load(picUrl).into(iv_item);
        } else {
            //显示最后一个+号
            iv_item.setImageResource(R.mipmap.zj);
        }
        Log.d("Postion","------"+imgList.size()+"------");
        Log.d("Postion","------"+position+"------");
        return convertView;
    }
}
