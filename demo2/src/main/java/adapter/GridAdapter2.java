package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huixing.demo2.R;

/**
 * Created by huixing on 2016/10/25.
 */

public class GridAdapter2 extends BaseAdapter {

    private int images[] = {R.mipmap.add_income_gongzi_icon,R.mipmap.add_income_jiangjin_icon,
            R.mipmap.add_income_fuli_icon,R.mipmap.add_income_touzishouyi_icon,R.mipmap.add_income_hongbao_icon,
            R.mipmap.add_income_jianzhi_icon,R.mipmap.add_income_shenghuofei_icon,
            R.mipmap.add_income_baoxiao_icon,R.mipmap.add_income_tuikuan_icon,R.mipmap.add_income_gongjijin_icon,
            R.mipmap.add_income_shebaojin_icon};
    private String title[] = {"工资","奖金","福利","投资收益","红包",
            "兼职","生活费","报销","退款","公积金","社保金"};
    private Context context;

    public GridAdapter2(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView ==null){

            convertView = View.inflate(context,R.layout.grid_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_grid);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_grid);

            convertView.setTag(holder);

        }else{

            holder = (ViewHolder) convertView.getTag();


        }

        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(title[position]);

        return convertView;
    }

    class  ViewHolder{

        private ImageView imageView;
        private TextView textView;

    }

}
