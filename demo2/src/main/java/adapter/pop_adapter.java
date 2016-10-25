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

public class pop_adapter extends BaseAdapter {

    private Context context;

    private int images[] = {R.mipmap.add_activity_xianjin_icon,R.mipmap.add_activity_chuxuka_icon,
    R.mipmap.add_activity_xinyongka_icon,R.mipmap.add_activity_zhifubao_icon};

    private String des[] = {"现金","储蓄卡","信用卡","支付宝"};

    public pop_adapter(Context context) {
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
        if (convertView == null){
            convertView = View.inflate(context,R.layout.popwindow_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_zijinleixing);
            holder.textView = (TextView) convertView.findViewById(R.id.name_zijinleixing);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.ischoice);

            convertView.setTag(holder);

        }else {

            holder = (ViewHolder) convertView.getTag();
        }

            holder.imageView.setImageResource(images[position]);
        holder.textView.setText(des[position]);
        holder.imageView2.setImageResource(R.mipmap.add_activity_right_icon);

        return convertView;
    }


    class ViewHolder{


        ImageView imageView;
        TextView textView;
        ImageView imageView2;

    }
}
